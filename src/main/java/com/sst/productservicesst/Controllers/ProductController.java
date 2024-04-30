package com.sst.productservicesst.Controllers;

import com.sst.productservicesst.Models.Product;
import com.sst.productservicesst.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this controller is capable to host HTTP API
//localhost:8080/products--> Product Controller
@RestController
@RequestMapping("/products")
public class ProductController { // just like waiter interact with client
    //localhost:8080/products/get/10
    ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try{
//            product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            System.out.println("Hello");
//            return responseEntity;
//        }
//        catch (RuntimeException exception){
//            ExceptionDto dto= new ExceptionDto();
//            dto.setMessage("Something Went WRONG");
//            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
//            dto.setMessage("Null");
//            return response;
//        }
        return productService.getProductById(id);
    }


    //localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
