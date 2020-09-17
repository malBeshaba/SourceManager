package com.example.demo.controller;


import com.example.demo.JsonResult;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     *通过用户名获取用户订单
     * */
    @GetMapping(
            value ="/getorder",
            produces = "application/json;"+"charset=utf-8"
    )
    public JsonResult<List<OrderDetail>> findByUsername(@RequestParam("username") String username){
        return new JsonResult<List<OrderDetail>>(orderService.findByUsername(username));
    }

    @GetMapping(
            value = "/getBySourceId",
            produces = "application/json;"+"charset=utf-8"
    )
    public JsonResult<List<OrderDetail>> findBySourceId(@RequestParam("source_id") int id) {
        return new JsonResult<>(orderService.findBySourceId(id));
    }

    /**
     *通过id删除订单
     * */
    @DeleteMapping(
            value = "/deleteorder",
            produces = "application/json;"+"charset=utf-8"
    )
    public JsonResult deleteByOrderId(@RequestParam("order_id")int order_id){
        orderService.deleteByOrderId(order_id);
        return new JsonResult();
    }

    /**
     *下订单
     * */

    @PostMapping(
            value = "/makeorder",
            produces = "application/json;"+"charset=utf-8"
    )
    public JsonResult makeOrder(@RequestParam("user_id") int user_id,
                                @RequestParam("source_id") int source_id,
                                @RequestParam("start_time") String start_time,
                                @RequestParam("end_time") String end_time,
                                @RequestParam("sum_price") double sum_price){
        orderService.makeOrder(user_id,source_id,start_time,end_time,sum_price);
        return new JsonResult();
    }

    @PutMapping(
            value = "/checkout",
            produces = "application/json;"+"charset=utf-8"
    )
    public JsonResult updateIs_agreed(@RequestParam("order_id") int order_id,@RequestParam("is_agreed") int is_agreed){
        orderService.updateIs_agreed(order_id,is_agreed);
        return new JsonResult();
    }

}
