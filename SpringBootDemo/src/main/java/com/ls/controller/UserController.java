package com.ls.controller;

import com.github.pagehelper.PageInfo;
import com.ls.entity.User;
import com.ls.service.UserService;
import org.assertj.core.util.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author yyb
 * @time 2020/3/6
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String t() {
        return "11";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> add() {
        logger.info("UserController.add start");
        User user = new User();
        user.setAddress("杭州");
        user.setCreateTime(new Date());
        user.setEmail("XXX@163.com");
        user.setMobile("159XXXXXXXX");
        user.setName("Simon");
        user.setRole(1);
        return ResponseEntity.ok(userService.create(user));
    }

    @RequestMapping(value = "/add1", method = RequestMethod.POST)
    public ResponseEntity<Integer> add1() {
        logger.info("UserController.add1 start");
        User user = new User();
        user.setAddress("杭州");
        user.setCreateTime(new Date());
        user.setEmail("XXX@163.com");
        user.setMobile("159XXXXXXXX");
        user.setName("Simon");
        user.setRole(1);
        return ResponseEntity.ok(userService.create1(user));
    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    public ResponseEntity<String> addList() {
        logger.info("UserController.addList start");
        for (int i = 0; i < 10; i++) {
            add();
        }
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") Integer id) {
        logger.info("UserController.getById start");
        return ResponseEntity.ok(userService.getById(id));
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<User>> findByName(@PathVariable("name") String name) {
        logger.info("UserController.findByName start");
        return ResponseEntity.ok(userService.getByMap(Maps.newHashMap("name", "Simon"), 0, 10));
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        logger.info("UserController.deleteById start");
        return ResponseEntity.ok("OK deleteRow=" + userService.delete(id));
    }

}


