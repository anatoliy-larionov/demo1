package com.epam.mvc.smoke.controller;

import com.epam.mvc.smoke.dto.Category;
import com.epam.mvc.smoke.dto.Product;
import com.epam.mvc.smoke.service.CategoryService;
import com.epam.mvc.smoke.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public AdminController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin";
    }

    @GetMapping("admin/delete/{idCategory}/{idProduct}")
    public String deleteProduct(@PathVariable("idCategory") long idCategory,
                                @PathVariable("idProduct") long idProduct) {
        List<Product> products = categoryService.findById(idCategory).getProducts();
        Product product1 = products.stream().filter(product -> product.getId() == idProduct).findFirst().get();
        productService.delete(product1.getId());

        /*        *//*Product findProduct = categoryService.findById(idCategory).getProductFromCategoryById(idProduct);*//*
        categoryService.findById(idCategory).getProducts()
                .stream()
                .filter(product -> product.getId() == idProduct)
                .map(product -> {
                    this.categoryService.delete(idProduct);
                    return product;
                });*/
        return "redirect:/admin";
    }

    @PostMapping("admin/{idCategory}")
    public String addProduct(@PathVariable long idCategory, Model model, @Valid Product product,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin";
        }
        categoryService.findById(idCategory).getProducts().add(product);
        return "redirect:/admin";
    }

    @PostMapping("admin/update/{idProduct}")
    public String updateProduct(@PathVariable("idProduct") long idProduct, Product product) {
        product.setId(idProduct);
        for (Category category : categoryService.findAll()) {
            for (Product p : category.getProducts()) {
                if (p.getId() == product.getId()) {
                    p.setPrice(product.getPrice());
                    p.setDescription(product.getDescription());
                    p.setName(product.getName());
                }
            }
        }
        return "redirect:/admin";
    }
}

