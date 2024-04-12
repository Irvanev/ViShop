package com.example.petproject.services.impl;

import com.example.petproject.dtos.users.UserDto;
import com.example.petproject.models.entities.User;
import com.example.petproject.models.enums.RoleEnum;
import com.example.petproject.repositories.RoleRepository;
import com.example.petproject.repositories.UserRepository;
import com.example.petproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository, RoleRepository roleRepository,
                                  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void addUser(UserDto userRegistrationDto) {
        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }
        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationDto.getUsername());

        if (byUsername.isPresent()) {
            throw new RuntimeException("login.used");
        }
        var role = roleRepository.
                findByRoleName(RoleEnum.USER).orElseThrow();

        User user = new User(
                userRegistrationDto.getUsername(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.getFullName()
        );
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setRole(role);

        this.userRepository.save(user);
    }
}
