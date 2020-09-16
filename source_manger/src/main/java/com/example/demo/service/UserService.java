package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Source;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private JSONObject getJsonResult(User user,String msg){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg",msg);
        jsonObject.put("data",user);
        return jsonObject;
    }

    public JSONObject findByName(String username) {
        return getJsonResult(userRepository.findByUsername(username).get(0),"success");
    }

    public JSONObject login(String username) {
        User user=new User();
        user.setUsername(username);
        userRepository.save(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","login successfully");
        return jsonObject;
    }

    public JSONObject updateAddress(String username,String phone_number,String area, String address) {
        User userImpl=userRepository.findByUsername(username).get(0);
        userImpl.setAddress(address);
        userImpl.setArea(area);
        userImpl.setPhone_number(phone_number);
        userRepository.deleteById(userImpl.getId());
        userRepository.save(userImpl);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","update info successfully");
        return jsonObject;
    }

    public JSONObject findAddressByName(String username){
        User user=userRepository.findByUsername(username).get(0);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success");
        String bigAddress=user.getArea()+user.getAddress();
        jsonObject.put("data",bigAddress);
        return jsonObject;
    }

    public JSONObject updateBalance(String username, int blance) {
        User userImpl=userRepository.findByUsername(username).get(0);
        userImpl.setBalance(blance);
        userRepository.deleteById(userImpl.getId());
        userRepository.save(userImpl);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","update balance successfully");
        return jsonObject;
    }

    public JSONObject findBalanceByName(String username) {
        User user=userRepository.findByUsername(username).get(0);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","success");
        jsonObject.put("data",user.getBalance());
        return jsonObject;
    }
}
