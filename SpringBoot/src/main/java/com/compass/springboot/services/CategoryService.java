package com.compass.springboot.services;

import com.compass.springboot.entities.Category;
import com.compass.springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        return repository.findAll();
    };

    public Category findById(Long id) {

        return repository.findById(id).get();
    }
}
