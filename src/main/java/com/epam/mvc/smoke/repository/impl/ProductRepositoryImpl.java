package com.epam.mvc.smoke.repository.impl;

import com.epam.mvc.smoke.data.ProductData;
import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ProductData productData = new ProductData();

    @Override
    public List<Product> findProductsByName(String nameProduct) {
        return this.productData.getProductList().stream()
                .filter(product -> product.getName().equals(nameProduct))
                .collect(Collectors.toList());
    }


    @Override
    public List<Product> findAll() {
        return this.productData.getProductList();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product findById(long idProduct) {
        return this.productData.getProductList().stream()
                .filter(product -> product.getId() == idProduct)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Product product) {
        this.productData.getProductList().add(product);
    }

    @Override
    public void delete(long idProduct) {
        this.productData.getProductList().remove((int)idProduct);
    }
}
