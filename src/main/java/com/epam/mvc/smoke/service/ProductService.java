package com.epam.mvc.smoke.service;

import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.repository.BasicRepository;
import java.util.List;

public interface ProductService extends BasicRepository<Product> {
    List<Product> findProductsByName(String nameProduct);
}
