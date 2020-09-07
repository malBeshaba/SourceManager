package com.example.source_manager_server.controller;

import com.example.source_manager_server.repository.SourceRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceController {
    private final SourceRepository repository;

    public SourceController(SourceRepository repository) {
        this.repository = repository;
    }


}
