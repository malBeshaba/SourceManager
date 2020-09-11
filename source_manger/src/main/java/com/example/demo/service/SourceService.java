package com.example.demo.service;

import com.example.demo.entity.Source;
import com.example.demo.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    public List<Source> findByType1AndType2(int type1, int type2){
        return sourceRepository.findByType1AndType2(type1,type2);
    }

    public List<Source> findByName(String name) {
        return sourceRepository.findByName(name);
    }

    public List<Source> findHomepage() {
        return sourceRepository.findHomepage();
    }


    public void addSource(Source source) {
        sourceRepository.save(source);
    }
}
