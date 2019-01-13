package com.epam.mvc.smoke.controller;

import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.service.ProductService;
import com.epam.mvc.smoke.service.SessionUserService;
import com.epam.mvc.smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;
    private ProductService productService;
    private SessionUserService sessionUserService;

    @Autowired
    public UserController(UserService userService, ProductService productService, SessionUserService sessionUserService) {
        this.userService = userService;
        this.productService = productService;
        this.sessionUserService = sessionUserService;
    }

    @GetMapping("basket")
    public String basket() {
        return "basket";
    }

    @PostMapping("basket/add/{productId}")
    public void addProductIntoBasket(@PathVariable("productId") long productId) {
        Product product = productService.findById(productId);
        userService.addProductIntoBasket(product);
    }

    @PostMapping("basket/delete/{productId}")
    public void deleteProductIntoBasket(@PathVariable("productId") long productId) {
        Product product = productService.findById(productId);
        userService.deleteProductFromBasket(product);
    }
}
