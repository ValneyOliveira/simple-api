package com.example.store.controllers;

import com.example.store.models.dtos.ProductDTO;
import com.example.store.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/store")
public class ProductController {
    private final ProductService productService;

    // Constructor to initialize ProductService
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Endpoint to retrieve all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> findAllProducts(){
        // Retrieve all products from ProductService
        var allProduct = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(allProduct);
    }

    // Endpoint to retrieve a product by its ID
    @GetMapping("/product/{code}")
    public ResponseEntity<Optional<ProductDTO>> findProductById(@PathVariable(value = "code") @RequestBody int code){
        // Retrieve product by its code from ProductService
        var product = productService.getProductByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND).body(product);
    }

    // Endpoint to create a new product
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDTO){
        // Save the new product using ProductService
        productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product saved");
    }

    // Endpoint to update a product
    @PutMapping("/products")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO){
        // Update the product using ProductService
        productService.updateProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    // Endpoint to delete a product
    @DeleteMapping("/products")
    public ResponseEntity<String> deleteProduct(@NotNull @RequestBody ProductDTO product){
        // Delete the product using ProductService
        productService.deleteProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
    }
}
