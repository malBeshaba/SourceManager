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

    @Query(value = "select * from sourcemanagerdb.source order by sourcemanagerdb.source.historicalusage desc limit 0,10",nativeQuery = true)
    List<Source> findHomepage();
}
