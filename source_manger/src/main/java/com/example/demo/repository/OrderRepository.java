package com.example.demo.repository;

import com.example.demo.entity.Order;
import com.example.demo.entity.Source;
import com.example.demo.entity.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
    @Query(value = "select * from sourcemanagerdb.order where sourcemanagerdb.order.subscriber_id = :user_id",nativeQuery = true)
    List<Order> findByUserId(@Param("user_id") int user_id);

    @Query(value = "select * from sourcemanagerdb.order where sourcemanagerdb.order.source_id = :user_id",nativeQuery = true)
    List<Order> findBySourceId(@Param("user_id")int source_id);

    @Modifying
    @Transactional
    @Query(value = "delete from sourcemanagerdb.order where sourcemanagerdb.order.id = ?1",nativeQuery = true)
    void deleteByOrderId(int order_id);

    @Modifying
    @Transactional
    @Query(value = "insert into sourcemanagerdb.order(owner,subscriber_id,source_id,statement,sum_price,start_time,end_time) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    void insertOrder(@Param("owner")String owner, @Param("subscriber_id")int subscriber_id,
                     @Param("source_id")int source_id, @Param("statement")double statement,
                     @Param("sum_price")double sum_price, @Param("start_time") String start_time,
                     @Param("end_time")String end_time);
    @Modifying
    @Transactional
    @Query(value = "update sourcemanagerdb.order set sourcemanagerdb.order.is_agreed = ?2 where sourcemanagerdb.order.id = ?1",nativeQuery = true)
    void updateIs_agreed(int order_id,int is_agreed);
}
