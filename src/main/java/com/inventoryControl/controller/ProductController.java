package com.inventoryControl.controller;

import com.inventoryControl.domain.Product;
import com.inventoryControl.service.product.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller("product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("add")
    public Product postProduct(Product product){
        return productService.addProduct(product);
    }

    @GetMapping("getAll")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

}
