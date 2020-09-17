package com.example.demo.service;


import com.example.demo.entity.*;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.SourceRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Date;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SourceRepository sourceRepository;
    @Autowired
    private UserRepository usersRepository;

    public List<Order> findByUserId(int user_id){
        return orderRepository.findByUserId(user_id);
    }

    public List<OrderDetail> findBySourceId(int source_id) {
        List<Order> orders;
        List<OrderDetail> orderDetails = new ArrayList<>();
        orders = orderRepository.findBySourceId(source_id);
        for (Order order: orders) {
            Source source = sourceRepository.findByID(source_id).get(0);
            OrderDetail detail = new OrderDetail(order, new SourceDetail(source, "http://172.23.41.146:8080/sourceimage/get?source_id="+source.getId()));
            User user = usersRepository.findByUserId(order.getSubscriber_id()).get(0);
            detail.setSubsecriber(user.getUsername());
            orderDetails.add(detail);
        }
        return orderDetails;
    }

    public List<OrderDetail> findByUsername(String username){
        List<User> usersList = usersRepository.findIdByUsername(username);
        List<Order> orders = new ArrayList<>();
        List<OrderDetail> orderDetails = new ArrayList<>();

        if(!usersList.isEmpty()){
            orders = findByUserId(usersList.get(0).getId());
            for (Order order: orders) {
                Source source = sourceRepository.findByID(order.getSource_id()).get(0);
                orderDetails.add(new OrderDetail(order, new SourceDetail(source, "http://172.23.41.146:8080/sourceimage/get?source_id="+source.getId())));
            }
            return orderDetails;
        } else{
            System.out.println("usersList是空的");
            return null;
        }
    }

    public void deleteByOrderId(int order_id){
        orderRepository.deleteByOrderId(order_id);
    }

    public synchronized void makeOrder(int user_id, int source_id, String start_time, String end_time, double sum_price){

        Order order = new Order();
        List<Source> sourceList = sourceRepository.findByID(source_id);
        if(sourceList.isEmpty()){
//            System.out.println("sourceList是空的");
        }
        if(!sourceList.isEmpty()){
//            System.out.println("sourceList不为空");
            Source source = sourceList.get(0);
//            order.setId(10);
            order.setOwner(source.getPublisher());
            order.setSource_id(source_id);
            order.setEnd_time(end_time);
            order.setStart_time(start_time);
            order.setStatement(source.getUnit_price());
            order.setSubscriber_id(user_id);
            order.setSum_price(sum_price);

            orderRepository.insertOrder(order.getOwner(),order.getSubscriber_id(),order.getSource_id(),
                    order.getStatement(),order.getSum_price(),order.getStart_time(),order.getEnd_time());
        }

    }

    public void updateIs_agreed(int order_id,int is_agreed){
        orderRepository.updateIs_agreed(order_id,is_agreed);
    }
}
