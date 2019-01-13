package com.epam.mvc.smoke.repository;

import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.dto.User;

public interface UserRepository extends BasicRepository<User> {
    User findUserByLogin(String login);
    void addProductIntoBasket(Product product);
    void deleteProductFromBasket(Product product);
}
