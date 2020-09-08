package com.example.source_manager_server.service;

import com.example.source_manager_server.entity.Source;
import com.example.source_manager_server.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {
    @Autowired
    private SourceRepository repository;

    public List<Source> findByType1AndType2(int type1, int type2) {
        return repository.findByType1AndType2(type1,type2);
    }

    public List<Source> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Source> findHomepage() {
        return repository.findHomepage();
    }

    public void addSource(Source source) {
        repository.save(source);
    }
}
