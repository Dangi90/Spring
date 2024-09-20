package com.sboard.service;

import com.sboard.dto.UserDTO;
import com.sboard.entity.User;
import com.sboard.repository.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service
public class UserService {

    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String joinEmail(@Email @NotEmpty String email) {
        // 인증 코드 생성 (랜덤 6자리 숫자)
        int authCode = ThreadLocalRandom.current().nextInt(100000, 1000000);

        // 메일 전송을 위한 설정
        String host = "smtp.gmail.com"; // Gmail SMTP 서버
        String from = "woo24465@gmail.com"; // 보내는 사람 이메일
        String subject = "jboard 인증번호 입니다.";
        String content = "인증 코드는: " + authCode + "입니다";

        // SMTP 설정
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("woo24465@gmail.com", "mawj nxfq tiwx regc");
            }
        });

        try {
            // 이메일 메시지 작성
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(content);

            // 이메일 전송
            Transport.send(message);
            System.out.println("이메일 전송 완료!");

        } catch (MessagingException e) {
            e.printStackTrace();
            return "이메일 전송 실패";
        }

        // 인증 코드를 반환 (일반적으로는 DB나 캐시에 저장)
        return String.valueOf(authCode);
    }



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

    public boolean checkUserExists(String uid) {
        return userRepository.existsById(uid);
    }
}
