package com.epam.mvc.smoke.repository;

import com.epam.mvc.smoke.dto.Product;
import java.util.List;

public interface ProductRepository extends BasicRepository<Product> {
    List<Product> findProductsByName(String nameProduct);

}
