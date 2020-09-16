package com.example.demo.repository;

import com.example.demo.entity.Source;
import com.example.demo.entity.SourceImage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.List;


@Repository
public interface SourceImageRepository extends CrudRepository<SourceImage,Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into sourcemanagerdb.source_image(source_id, image) values(?1,?2)",nativeQuery = true)
    void addSourceImage(int source_id, InputStream image);

    @Modifying
    @Transactional
    @Query(value = "select * from sourcemanagerdb.source_image where source_id=:sourceId", nativeQuery = true)
    List<SourceImage> findBySourceId(@Param("sourceId") int source_id);
}
