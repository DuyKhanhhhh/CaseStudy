package com.example.casestudy_web.service;

import com.example.casestudy_web.model.Product;

import java.util.List;

public interface IProductService {
    Product selectProduct(int id);
    List<Product> searchProduct(String  name);
    boolean deleteProduct(int id);
    List<Product> selectAllProduct();
    void insertProduct(Product product);
    boolean updateProduct(Product user);
}
