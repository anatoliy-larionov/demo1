package com.epam.mvc.smoke.data;

import com.epam.mvc.smoke.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryData {
    private List<Category> categoryList = new ArrayList<>();
    private ProductData productData;

    @Autowired
    public CategoryData(ProductData productData) {
        this.productData = productData;
        categoryList.add(new Category(0, "Kalyan", productData.getProductList()));
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
