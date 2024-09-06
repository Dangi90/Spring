package com.ch05.service;

import com.ch05.dao.User5Mapper;
import com.ch05.dto.User5DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User5Service {

    private final User5Mapper user5Mapper;

    @Autowired
    public User5Service(User5Mapper user5Mapper) {
        this.user5Mapper = user5Mapper;
    }

    public void insertUser5(User5DTO user5DTO){
        user5Mapper.insertUser5(user5DTO);
    }
    public List<User5DTO> selectUser5s(){
        return user5Mapper.selectUser5s();
    }
    public User5DTO selectUser5(String uid){
        return user5Mapper.selectUser5(uid);
    }
    public void updateUser5(User5DTO user5DTO){
        user5Mapper.updateUser5(user5DTO);
    }
    public void deleteUser5(String uid){
        user5Mapper.deleteUser5(uid);
    }

}