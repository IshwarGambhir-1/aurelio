package com.yash.shopapp.productservice.service;

import com.yash.shopapp.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
