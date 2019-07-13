package com.example.springangular.controller;

import com.example.springangular.model.User;
import com.example.springangular.repository.UserRepository;
import com.example.springangular.service.DTO.UserDTO;
import com.example.springangular.service.Mapper.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepository;

    private ProductMapper productMapper;

    public UserController(ProductMapper productMapper, UserRepository userRepository) {
        this.productMapper = productMapper;
        this.userRepository = userRepository;
    }

    /** Return all USERS */
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(productMapper.toUserDTOs(userRepository.findAll()));
    }

    /** Return User by Id */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok(productMapper.toUserDTO(userRepository.findById(userId).get()));
    }

    /** Create User */
    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    /** Update User */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long userId,
                                              @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(userId).get();
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setBirthdate(userDetails.getBirthdate());
        user.setCountry(userDetails.getCountry());
        user.setRole(userDetails.getRole());
        user.setStatus(userDetails.getStatus());
        user.setSkills(userDetails.getSkills());

        final User updateUser = userRepository.save(user);
        return ResponseEntity.ok(productMapper.toUserDTO(updateUser));
    }

    /** Delete User */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).get();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
