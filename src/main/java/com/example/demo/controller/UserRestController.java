package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "userId", required = true) int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findByName(userName);
    }


    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<User> findAllUser() {
        System.out.println("开始查询所有数据...");
        return userService.findAll();
    }
}