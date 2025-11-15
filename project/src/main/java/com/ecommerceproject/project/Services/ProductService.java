package com.ecommerceproject.project.Services;

import java.util.List;

import com.ecommerceproject.project.models.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSinglProduct(Long productId);
    Product createProduct(Product product);
    Product replaceProduct(Long productId,Product product);
}
