package com.electroshop.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electroshop.entity.Product;
import com.electroshop.service.ProductService;

@Controller
public class AdminController {
    @Autowired
    private ProductService productService;

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("productCount", productService.findAll().size());
        return "admin/dashboard";
    }

    @GetMapping("/admin/products")
    public String products(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("/admin/products/create")
    public String createPage(Model model) {
        model.addAttribute("product", new Product());
        return "admin/product-form";
    }

    @GetMapping("/admin/products/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "admin/product-form";
    }

    @PostMapping("/admin/products/save")
    public String save(@RequestParam(required = false) Long id, @RequestParam String name,
                       @RequestParam String category, @RequestParam BigDecimal price,
                       @RequestParam Integer stock, @RequestParam(required = false) String description) {
        Product product = id == null ? new Product() : productService.findById(id);
        product.setName(name); product.setCategory(category); product.setPrice(price); product.setStock(stock);
        product.setDescription(description); product.setImageUrl("/assets/images/product-placeholder.svg");
        productService.save(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }

    @GetMapping({"/admin/categories", "/admin/customers", "/admin/orders", "/admin/blogs", "/admin/revenue", "/admin/settings"})
    public String placeholder(Model model) {
        model.addAttribute("heading", "Khu vuc quan tri dang cap nhat");
        return "admin/placeholder";
    }

    @GetMapping("/error/403")
    public String forbidden() { return "pages/error/403"; }
}
