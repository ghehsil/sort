package com.ls.dao;

import com.ls.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    List<User> getByMap(Map<String, Object> map);

    User getById(Integer id);

    Integer create(User user);

    Integer create1(User user);

    int update(User user);

    int delete(Integer id);
}