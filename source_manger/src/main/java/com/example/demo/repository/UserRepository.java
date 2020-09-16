package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findByUsername(String username);
}
