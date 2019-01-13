package com.epam.mvc.smoke.data;

import com.epam.mvc.smoke.dto.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryData {
    private List<Category> categoryList = new ArrayList<>();
    private ProductData productData = new ProductData();

    public CategoryData() {
        categoryList.add(new Category(0, "Kalyan", productData.getProductList()));
        categoryList.add(new Category(1, "Tabak", productData.getProductList()));
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
