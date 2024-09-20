package com.sboard.controller;

import com.sboard.dto.UserDTO;
import com.sboard.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegisterController {

    private final UserService userService; // UserService 주입

    public RegisterController(UserService userService) {
        this.userService = userService; // 생성자에서 주입
    }

    @PostMapping("/checkUser")
    public ResponseEntity<String> checkUser(@RequestBody UserDTO userDTO) {
        String uid = userDTO.getUid();
        boolean exists = userService.checkUserExists(uid); // UserService의 메서드 호출

        if (exists) {
            return ResponseEntity.ok("이미 사용중인 아이디입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 아이디입니다.");
        }
    }

    @PostMapping("/joinEmail")
    public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
        // 회원 정보 저장 로직 추가
        System.out.println(userDTO.getEmail());
        userService.joinEmail(userDTO.getEmail()); // 유저 정보 저장

        // 이메일 인증 코드 생성 및 전송
        String email = userDTO.getEmail();
        String authCode = userService.joinEmail(email);

        // 인증 코드 확인 메일 전송 메시지 반환
        return ResponseEntity.ok("SU");
    }
}
