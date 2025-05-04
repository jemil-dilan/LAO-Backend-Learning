package org.example.gestion_utilisateur.service;

import org.example.gestion_utilisateur.domain.User;
import org.example.gestion_utilisateur.dto.CreateUserDTO;
import org.example.gestion_utilisateur.dto.UserDTO;
import org.example.gestion_utilisateur.exceptions.ConflictException;
import org.example.gestion_utilisateur.exceptions.ResourceNotFoundException;
import org.example.gestion_utilisateur.mapper.UserMapper;
import org.example.gestion_utilisateur.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)){userRepository.deleteById(id);}
        else {throw new ResourceNotFoundException("User doesn't exist");}
    }

    public UserDTO createUser(CreateUserDTO createUserDTO) {
        if (userRepository.existsByEmail(createUserDTO.getEmail())) {
            throw new ConflictException("Email already exists");
        }
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(createUserDTO)));
    }

    public void updateUser(Long id,CreateUserDTO createUserDTO) {
        if (userRepository.existsById(id)) {
            User entity = userMapper.toEntity(createUserDTO);
            entity.setId(id);
            entity.setLastUpdatedDate(LocalDateTime.now());
            userRepository.save(entity);
        } else{throw new ConflictException("Email already exists");}
    }
}
