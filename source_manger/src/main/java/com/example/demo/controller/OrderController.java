//package com.example.demo.controller;
//
//
//import com.example.demo.JsonResult;
//import com.example.demo.entity.Order;
//import com.example.demo.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/Order")
//public class OrderController {
//    @Autowired
//    private OrderService orderService;
//    /**
//     *通过用户id获取用户订单
//     * */
//    JsonResult<List<Order>> findByUserId(@RequestParam("subscriber_id") int user_id){
//        return new JsonResult<List<Order>>(orderService.findByUserId(user_id));
//    }
//
//    /**
//     *通过id删除订单
//     * */
//    JsonResult deleteByOrderId(int order_id){
//        return new JsonResult();
//    }
//
//}
