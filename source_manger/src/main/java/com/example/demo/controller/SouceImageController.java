package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.SourceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping("sourceimage")
public class SouceImageController {
    @Autowired
    private SourceImageService service;

    @GetMapping(
            value = "get",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    @ResponseBody
    public byte[] getImage(@RequestParam(value = "source_id") int id) throws SQLException {
        return service.getImage(id);
    }
}
