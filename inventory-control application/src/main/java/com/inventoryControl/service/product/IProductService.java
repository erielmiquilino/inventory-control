package com.inventoryControl.service.product;

import com.inventoryControl.domain.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();
}
