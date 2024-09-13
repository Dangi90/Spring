package com.ch10.controller;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.jwt.JwtProvider;
import com.ch10.security.MyUserDetails;
import com.ch10.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity user(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        UserDTO userDTO = userService.selectUser(user.getUid());

        return ResponseEntity.ok().body(user.toDTO());
    }


    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        log.info("Log1 : {}", userDTO);

        try {
            UsernamePasswordAuthenticationToken authToken
                    = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());

            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("Log2 : {}", authentication);


            //인증된 사용자 객체 가져오기
            MyUserDetails myuserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myuserDetails.getUser();
            log.info("Log3 : {}", user);

            // 토큰생성

            String accessToken = jwtProvider.createToken(user, 1); //1일
            String refreshToken = jwtProvider.createToken(user, 7); //7일

            // refresh 토큰 DB저장
            System.out.println(user);
            //Acess, refresh 토큰전송
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("accessToken", accessToken);
            resultMap.put("refreshToken", refreshToken);
            resultMap.put("user", user);
            log.info("Log4 : {}", resultMap);


            return ResponseEntity.ok().body(resultMap);

        } catch (Exception e) {
            //인증 실패
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("일치하는 회원이 없습니다");
        }


    }
}
