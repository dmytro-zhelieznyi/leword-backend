package com.qozz.leword.service;

import com.qozz.leword.data.entity.User;
import com.qozz.leword.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(User user) {
        Optional<User> optionalUser
                = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }

        return optionalUser.get();
    }

}
