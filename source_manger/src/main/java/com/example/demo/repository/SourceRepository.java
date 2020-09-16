package com.example.demo.repository;

import com.example.demo.entity.Source;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends CrudRepository<Source,Integer> {
    List<Source> findByType1AndType2(int type1, int type2);

    List<Source> findByName(String name);

    @Query(value = "select * from sourcemanagerdb.source order by historical_usage desc limit 0,10",nativeQuery = true)
    List<Source> findHomepage();

    List<Source> findByPublisher(String publisher);

//    @Query(value = "INSERT INTO sourcemanagerdb.source VALUES (12,'Billwww',1,2,'Bill',null,null,0.1,'a','a',1,1,true,1)",nativeQuery = true)
//    void save();
}
