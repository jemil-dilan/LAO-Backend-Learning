package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.dto.CreateUserDTO;
import com.lao.backend.money_transfer.dto.UserDTO;
import com.lao.backend.money_transfer.mapper.user.CreateUserMapper;
import com.lao.backend.money_transfer.mapper.user.UserMapper;
import com.lao.backend.money_transfer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final CreateUserMapper createUserMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, CreateUserMapper createUserMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.createUserMapper = createUserMapper;
    }
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDTO ).toList();
    }
    public UserDTO getUserById(Long userId) {
        return userRepository.findById(userId).map(userMapper::toUserDTO).orElseThrow();
    }

    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)){userRepository.deleteById(userId);}
    }

    public UserDTO createUser(CreateUserDTO creatUserDTO) {
        if (!userRepository.existByEmail(creatUserDTO.getEmail())){
            var user = createUserMapper.toUser(creatUserDTO);
            user.setCreationDate(LocalDateTime.now());
            return userMapper.toUserDTO(userRepository.save(user));
        }
        throw new RuntimeException("User already exist");
    }

    public void updateUser(Long userId, CreateUserDTO createUserDTO){
        if (userRepository.existsById(userId)){
            var user = createUserMapper.toUser(createUserDTO);
            user.setId(userId);
            user.setUpdatedDate(LocalDateTime.now());
            userRepository.save(user);
        }
    }
}
