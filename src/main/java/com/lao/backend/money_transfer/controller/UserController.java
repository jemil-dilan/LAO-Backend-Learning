package com.lao.backend.money_transfer.controller;

import com.lao.backend.money_transfer.dto.CreateUserDTO;
import com.lao.backend.money_transfer.dto.UserDTO;
import com.lao.backend.money_transfer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody CreateUserDTO createUserDTO){
        userService.updateUser(id,createUserDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
