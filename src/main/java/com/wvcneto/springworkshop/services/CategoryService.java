package com.wvcneto.springworkshop.services;

import com.wvcneto.springworkshop.entities.Category;
import com.wvcneto.springworkshop.repositories.CategoryRepository;
import com.wvcneto.springworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {   return categoryRepository.findAll(); }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
