package com.ch07.service;

import com.ch07.dto.User2DTO;
import com.ch07.entity.User2;
import com.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    //생성자 주입
    private final User2Repository user2Repository;

    public void insertUser2(User2DTO user2DTO) {
        //DTO를 엔티티로 변환
        User2 entity = user2DTO.toEntity();

        //entity 저장
        user2Repository.save(entity);
    }

    public User2DTO selectUser2(String uid) {
        /*
            Optional
            - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
            - Spring JPA find ~ 메서드의 결과 타입
         */

        Optional<User2> opt = user2Repository.findById(uid);
        if (opt.isPresent()) {
            // Optinal 타입으로 정의된 etitiy 가져오기
            User2 user2 = opt.get();
            // Entity를 DTO로 변환해서 반환
            return user2.toDTO();
        }
        return null;
    }

    public List<User2DTO> selectUser2s() {
        // Entity 전체 조회
        List<User2> user2s = user2Repository.findAll();
        // for(외부 반복자)를 이용해 Entity 리스트를 DTO로 변환 - traffic이 높아져 권장 x
        /*
        List<User2DTO> user2DTOS = new ArrayList<>();
        for(User2 user2 : user2s) {
            user2DTOS.add(user2.toDTO());
        }
        */

        //stream(내부 반복자)를 이용해 Entity 리스트를 DTO로 변환
        List<User2DTO> users = user2s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public void updateUser2(User2DTO user2DTO) {

        boolean result = user2Repository.existsById(user2DTO.getUid());

        if (result) {

            User2 entity = user2DTO.toEntity();

            user2Repository.save(entity);
        }

    }

    public void deleteUser2(String uid) {
        //엔티티 삭제
        user2Repository.deleteById(uid);
    }
}
