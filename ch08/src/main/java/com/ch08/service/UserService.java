package com.ch08.service;

import com.ch08.dto.UserDTO;
import com.ch08.entity.User;
import com.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void insertUser(UserDTO userDTO) {
        String encoded = passwordEncoder.encode(userDTO.getPass()); // 비밀번호 암호화
        userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userRepository.save(user);
    }

    public UserDTO selectUser(String uid) {
        Optional<User> optUser = userRepository.findById(uid);

        if (optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTO();
        }

        return null;
    }

}
