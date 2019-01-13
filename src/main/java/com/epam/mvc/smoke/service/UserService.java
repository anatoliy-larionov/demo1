package com.epam.mvc.smoke.service;

import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.dto.User;

public interface UserService extends BasicService<User> {
    User findUserByLogin(String login);
    User authenticateUser(User user);
    void addProductIntoBasket(Product product);
    void deleteProductFromBasket(Product product);
}
