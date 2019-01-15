package com.epam.mvc.smoke.service.impl;

import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.repository.ProductRepository;
import com.epam.mvc.smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductsByName(String nameProduct) {
        return this.productRepository.findProductsByName(nameProduct);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return this.productRepository.update(product);
    }

    @Override
    public Product findById(int idProduct) {
        return this.productRepository.findById(idProduct);
    }

    @Override
    public void add(Product product) {
        this.productRepository.add(product);
    }

    @Override
    public void delete(int idProduct) {
        this.productRepository.delete(idProduct);
    }
}
