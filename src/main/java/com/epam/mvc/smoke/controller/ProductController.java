package com.epam.mvc.smoke.controller;

import com.epam.mvc.smoke.dto.Category;
import com.epam.mvc.smoke.dto.User;
import com.epam.mvc.smoke.service.CategoryService;
import com.epam.mvc.smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    private CategoryService categoryService;
    private UserService userService;

    @Autowired
    public ProductController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String printListProducts(Model model) {
        List<Category> categories = categoryService.findAll();
        List<User> users = userService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("users", users);
        return "index";
    }
}
