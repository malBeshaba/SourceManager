package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.JsonResult;
import com.example.demo.service.SourceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
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

    @RequestMapping(value = "upload")
    @ResponseBody
    public JSONObject register(@RequestParam("file") MultipartFile file, @RequestHeader("source_id") int id) throws SQLException {
                JSONObject jsonObject=new JSONObject();
                boolean b = service.insert(id, file);
        System.out.println("id:"+id);
                if (b) {
                    jsonObject.put("code",0);
                    jsonObject.put("msg","success");
        } else {
            jsonObject.put("code",-1);
            jsonObject.put("msg","fail");
        }

        return jsonObject;
    }


}
