package com.example.source_manager_server.repository;

import com.example.source_manager_server.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source,Integer> {
}
