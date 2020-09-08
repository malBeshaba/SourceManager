package com.example.source_manager_server.repository;

import com.example.source_manager_server.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source,Integer> {
    List<Source> findByType1AndType2(int type1, int type2);

    List<Source> findByName(String name);

    @Query("select * from Source order by Source.historicalUsage desc limit 0,10")
    List<Source> findHomepage();
}
