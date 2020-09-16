package com.example.demo.repository;

import com.example.demo.entity.Source;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SourceRepository extends CrudRepository<Source,Integer> {
    List<Source> findByType1AndType2(int type1, int type2);

    List<Source> findById(int id);

    List<Source> findByName(String name);

    @Query(value = "select * from sourcemanagerdb.source order by historical_usage desc limit 0,10",nativeQuery = true)
    List<Source> findHomepage();

    List<Source> findByPublisher(String publisher);

    @Modifying
    @Transactional
    @Query(value = "insert into sourcemanagerdb.source (name,type1,type2,publisher,start_time,end_time,unit_price,comments,describe,concurrent_usage,historical_usage,is_available) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)",nativeQuery = true)
    void insertSource(@Param("name") String name,@Param("type1")int type1,@Param("type2")int type2,@Param("publisher")String publisher,@Param("start_time")String start_time,@Param("")String end_time,
                      @Param("unit_price")double unit_price,@Param("comments")String comments,@Param("describe")String describe,@Param("concurrent_usage")int concurrent_usage,@Param("historical_usage")int historical_usage,
                      @Param("is_available")int is_available);

//    @Query(value = "INSERT INTO sourcemanagerdb.source VALUES (12,'Billwww',1,2,'Bill',null,null,0.1,'a','a',1,1,true,1)",nativeQuery = true)
//    void save();

    @Query(value = "select * from sourcemanagerdb.source where sourcemanagerdb.source.id = :source_id",nativeQuery = true)
    List<Source> findByID(@Param("source_id") int source_id);
}
