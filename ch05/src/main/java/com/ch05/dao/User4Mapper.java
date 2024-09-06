package com.ch05.dao;

import com.ch05.dto.User4DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// mybatis scanning을 위해 @Mapper 선언
@Mapper
public interface User4Mapper {

    public void insertUser4(User4DTO user4DTO);
    public List<User4DTO> selectUser4s();
    public User4DTO selectUser4(String uid);
    public void updateUser4(User4DTO user4DTO);
    public void deleteUser4(String uid);

}