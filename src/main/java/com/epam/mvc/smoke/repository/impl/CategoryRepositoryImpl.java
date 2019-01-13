package com.epam.mvc.smoke.repository.impl;

import com.epam.mvc.smoke.data.CategoryData;
import com.epam.mvc.smoke.dto.Category;
import com.epam.mvc.smoke.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private CategoryData categoryData = new CategoryData();

    @Override
    public List<Category> findAll() {
        return this.categoryData.getCategoryList();
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category findById(long idCategory) {
        return this.categoryData.getCategoryList().stream()
                .filter(category -> category.getId() == idCategory)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Category category) {
        this.categoryData.getCategoryList().add(category);
    }

    @Override
    public void delete(long idCategory) {
        this.categoryData.getCategoryList().stream()
                .filter(category -> category.getId() == idCategory)
                .findFirst()
                .map(c -> {
                    categoryData.getCategoryList().remove(c);
                    return c;
                });
    }
}
