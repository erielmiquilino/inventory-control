package com.inventoryControl.controllers.product;

import com.inventoryControl.domain.Product;
import com.inventoryControl.service.product.IProductService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/product")
//@Api(value = "product")
//public class ProductController {
//
//    private final IProductService productService;
//
//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping("add")
//    public Product postProduct(Product product){
//        return productService.addProduct(product);
//    }
//
//    @GetMapping("getAll")
//    public List<Product> getProducts(){
//        return productService.getAllProducts();
//    }
//
//}
