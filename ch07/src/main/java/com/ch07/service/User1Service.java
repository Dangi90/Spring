package com.ch07.service;

import com.ch07.dto.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {

    //생성자 주입
    private final User1Repository user1Repository;

    public void insertUser1(User1DTO user1DTO) {
        //DTO를 엔티티로 변환
        User1 entity = user1DTO.toEntity();

        //entity 저장
        user1Repository.save(entity);
    }

    public User1DTO selectUser1(String uid) {
        /*
            Optional
            - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
            - Spring JPA find ~ 메서드의 결과 타입
         */

        Optional<User1> opt = user1Repository.findById(uid);
        if (opt.isPresent()) {
            // Optinal 타입으로 정의된 etitiy 가져오기
            User1 user1 = opt.get();
            // Entity를 DTO로 변환해서 반환
            return user1.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s() {
        // Entity 전체 조회
        List<User1> user1s = user1Repository.findAll();
        // for(외부 반복자)를 이용해 Entity 리스트를 DTO로 변환 - traffic이 높아져 권장 x
        /*
        List<User1DTO> user1DTOS = new ArrayList<>();
        for(User1 user1 : user1s) {
            user1DTOS.add(user1.toDTO());
        }
        */

        //stream(내부 반복자)를 이용해 Entity 리스트를 DTO로 변환
        List<User1DTO> users = user1s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public void updateUser1(User1DTO user1DTO) {

        boolean result = user1Repository.existsById(user1DTO.getUid());

        if (result) {

            User1 entity = user1DTO.toEntity();

            user1Repository.save(entity);
        }

    }

    public void deleteUser1(String uid) {
        //엔티티 삭제
        user1Repository.deleteById(uid);
    }
}
