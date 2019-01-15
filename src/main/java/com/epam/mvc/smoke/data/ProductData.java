package com.epam.mvc.smoke.data;

import com.epam.mvc.smoke.dto.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductData {
    private List<Product> productList = new ArrayList<>();

    public ProductData() {
        productList.add(new Product(0,"Black", 4322, "Description"));
        productList.add(new Product(1, "Gold", 3232, "Description"));
        productList.add(new Product(2, "Yellow", 1453, "Description"));
        productList.add(new Product(3,"Red", 2133, "Description"));
    }

    public List<Product> getProductList() {
        return productList;
    }
}
