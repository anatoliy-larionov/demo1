package com.epam.mvc.smoke.service.impl;

import com.epam.mvc.smoke.dto.Category;
import com.epam.mvc.smoke.repository.CategoryRepository;
import com.epam.mvc.smoke.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepository.update(category);
    }

    @Override
    public Category findById(long idCategory) {
        return this.categoryRepository.findById(idCategory);
    }

    @Override
    public void add(Category category) {
        this.categoryRepository.add(category);
    }

    @Override
    public void delete(long idCategory) {
        this.categoryRepository.delete(idCategory);
    }
}
