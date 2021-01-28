package com.ls.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ls.dao.GoodsDao;
import com.ls.dataSourceConfig.DynamicDataSourceContextHolder;
import com.ls.dao.UserDao;
import com.ls.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private GoodsDao goodsDao;

    public PageInfo<User> getByMap(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        DynamicDataSourceContextHolder.resetDatabaseType();
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userDao.getByMap(map));
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public User create(User user) {
        logger.info("UserService.create start");
        userDao.create(user);
        return user;
    }

    public Integer create1(User user) {
        logger.info("UserService.create1 start");
        userDao.create1(user);
        return user.getId();
    }

    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Transactional(rollbackFor = {Exception.class, Error.class})
    public int delete(Integer id) {
        logger.info("UserService.delete id={}", id);
        userDao.delete(id);
        logger.info("UserService.delete is done");
        throw new RuntimeException("1");
        //return goodsDao.delete(id);
    }

}