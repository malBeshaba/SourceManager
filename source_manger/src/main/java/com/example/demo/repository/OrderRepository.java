//package com.example.demo.repository;
//
//import com.example.demo.entity.Order;
//import org.aspectj.weaver.ast.Or;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public interface OrderRepository extends CrudRepository<Order,Integer> {
//    List<Order> findByUserId(int user_id);
//
//    void deleteByOrderId(int order_id);
//
//    @Query(value = "insert into sourcemanagerdb.Order values(,(select publisher from sourcemanagerdb.source where id = source_id),user_id,source_id,)(select unitPrice from sourcemanagerdb.source where id = source_id),sum_price,start_time,end_time")
//    void makeOrder(int user_id, int source_id, Date start_time, Date end_time);
//    // 租赁时间/h：int sum_hours = ((end_time.getMonth() - start_time.getMonth())*30 + end_time.getDate() - start_time.getDate()) * 24
//    //           + end_time.getHours() - start_time.getHours()
//    //总价：int sum_price = sum_hours * unitPrice
//}
