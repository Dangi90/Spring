package com.ch07.service;

import com.ch07.dto.User3DTO;
import com.ch07.entity.User3;
import com.ch07.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User3Service {

    //생성자 주입
    private final User3Repository user3Repository;

    public void insertUser3(User3DTO user3DTO) {
        //DTO를 엔티티로 변환
        User3 entity = user3DTO.toEntity();

        //entity 저장
        user3Repository.save(entity);
    }

    public User3DTO selectUser3(String uid) {
        /*
            Optional
            - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
            - Spring JPA find ~ 메서드의 결과 타입
         */

        Optional<User3> opt = user3Repository.findById(uid);
        if (opt.isPresent()) {
            // Optinal 타입으로 정의된 etitiy 가져오기
            User3 user3 = opt.get();
            // Entity를 DTO로 변환해서 반환
            return user3.toDTO();
        }
        return null;
    }

    public List<User3DTO> selectUser3s() {
        // Entity 전체 조회
        List<User3> user3s = user3Repository.findAll();
        // for(외부 반복자)를 이용해 Entity 리스트를 DTO로 변환 - traffic이 높아져 권장 x
        /*
        List<User3DTO> user3DTOS = new ArrayList<>();
        for(User3 user3 : user3s) {
            user3DTOS.add(user3.toDTO());
        }
        */

        //stream(내부 반복자)를 이용해 Entity 리스트를 DTO로 변환
        List<User3DTO> users = user3s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public void updateUser3(User3DTO user3DTO) {

        boolean result = user3Repository.existsById(user3DTO.getUid());

        if (result) {

            User3 entity = user3DTO.toEntity();

            user3Repository.save(entity);
        }

    }

    public void deleteUser3(String uid) {
        //엔티티 삭제
        user3Repository.deleteById(uid);
    }
}
