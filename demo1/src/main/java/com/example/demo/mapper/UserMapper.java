package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();

    User findById(Long id);

    void insert(User user);

    void update(@Param("id") Long id, @Param("user") User user);

    void delete(Long id);

}
