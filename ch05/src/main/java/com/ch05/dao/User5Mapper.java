package com.ch05.dao;

import com.ch05.dto.User5DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// mybatis scanning을 위해 @Mapper 선언
@Mapper
public interface User5Mapper {

    public void insertUser5(User5DTO user5DTO);
    public List<User5DTO> selectUser5s();
    public User5DTO selectUser5(String uid);
    public void updateUser5(User5DTO user5DTO);
    public void deleteUser5(String uid);

}