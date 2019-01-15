package com.epam.mvc.smoke.repository.impl;

import com.epam.mvc.smoke.data.ProductData;
import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductData productData;

    @Override
    public List<Product> findAll() {
        return this.productData.getProductList();
    }

    @Override
    public Product update(Product product) {
        return this.productData.getProductList().set(product.getId(), product);
    }

    @Override
    public Product findById(int idProduct) {
        return this.productData.getProductList().get(idProduct);
    }

    @Override
    public void add(Product product) {
        this.productData.getProductList().add(product);
    }

    @Override
    public void delete(int idProduct) {
        this.productData.getProductList().stream().filter(product -> product.getId() == idProduct).findFirst()
                .map(p -> {
                    productData.getProductList().remove(p);
                    return p;
                });
    }

    @Override
    public List<Product> findProductsByName(String nameProduct) {
        return this.productData.getProductList()
                .stream()
                .filter(product -> product.getName().equals(nameProduct))
                .collect(Collectors.toList());
    }
}
