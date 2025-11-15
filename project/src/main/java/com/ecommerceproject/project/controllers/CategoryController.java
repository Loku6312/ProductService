package com.ecommerceproject.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping("/{categoryId}")
    public String getCategoryById(@PathVariable("categoryId") Long categoryId) {
        throw new RuntimeException();
    }
    
}
