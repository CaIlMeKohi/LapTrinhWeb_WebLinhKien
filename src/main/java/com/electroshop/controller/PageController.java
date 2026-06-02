package com.electroshop.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.electroshop.entity.Product;
import com.electroshop.service.ProductService;

@Controller
public class PageController {
    private final ProductService productService;

    @Autowired
    public PageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("featuredProducts", products.subList(0, Math.min(products.size(), 4)));
        model.addAttribute("productCount", products.size());
        return "home";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) return "redirect:/products";
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", Arrays.asList("Vi dieu khien", "Cam bien", "Nguon", "Dong co", "Ket noi", "Phu kien"));
        return "categories";
    }

    @GetMapping("/categories/{category}")
    public String productsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("heading", "San pham theo danh muc: " + category);
        model.addAttribute("products", productService.findByCategory(category));
        return "search-results";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", defaultValue = "") String keyword, Model model) {
        model.addAttribute("heading", "Ket qua tim kiem");
        model.addAttribute("keyword", keyword);
        model.addAttribute("products", keyword.isBlank() ? Arrays.asList() : productService.search(keyword));
        return "search-results";
    }

    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blogs", Arrays.asList(
                "Bat dau voi Arduino",
                "Chon cam bien phu hop",
                "Nguon dien cho mach"
        ));
        return "blogs";
    }

    @GetMapping({"/promotions", "/contact"})
    public String placeholder(Model model) {
        model.addAttribute("heading", "Trang dang cap nhat");
        return "placeholder";
    }
}
