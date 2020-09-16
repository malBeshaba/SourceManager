package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.JsonResult;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(@RequestParam("username")String username){
        return userService.login(username);
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("info")
    @ResponseBody
    public JSONObject getInfo(@RequestParam("username")String username){
        return userService.findByName(username);
    }

    /**
     * 存入地址等信息
     */
    @RequestMapping("address")
    @ResponseBody
    public JSONObject updateAddress(@RequestParam("username")String username,@RequestParam("tel")String phone_number,@RequestParam("area")String area,@RequestParam("address")String address){
        return  userService.updateAddress(username,phone_number,area,address);
    }

    /**
     * 查询地址
     */
    @GetMapping("address")
    @ResponseBody
    public JSONObject getAddress(@RequestParam("username")String username){
        return userService.findAddressByName(username);
    }

    /**
     * 修改余额
     */
    @RequestMapping("money")
    @ResponseBody
    public JSONObject updateBalance(@RequestParam("username")String username,@RequestParam("num")int blance){
        return userService.updateBalance(username,blance);
    }

    /**
     * 获取余额
     */
    @GetMapping("money")
    @ResponseBody
    public JSONObject getBalance(@RequestParam("username")String username){
        return userService.findBalanceByName(username);
    }

}
