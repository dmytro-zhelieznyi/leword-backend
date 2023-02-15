package com.qozz.leword.api.controller;

import com.qozz.leword.data.entity.User;
import com.qozz.leword.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<String> findAll() {
        return userRepository.findAll()
                .stream().map(User::getEmail)
                .toList();
    }

}
