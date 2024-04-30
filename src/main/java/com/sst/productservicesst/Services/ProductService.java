package com.sst.productservicesst.Services;

import com.sst.productservicesst.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
