package com.example.store.services;

import com.example.store.exceptions.DeletionErrorException;
import com.example.store.exceptions.NotFoundException;
import com.example.store.exceptions.SaveErrorException;
import com.example.store.exceptions.UpdateErrorException;
import com.example.store.models.ProductModel;
import com.example.store.models.dtos.ProductDTO;
import com.example.store.repositories.ProductRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Constructor to initialize ProductRepository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to retrieve all products from the database and convert them to DTOs
    public List<ProductDTO> getAllProducts() {
        List<ProductModel> productModels = productRepository.findAll();

        // Map ProductModel objects to ProductDTOs
        List<ProductDTO> products = productModels.stream().map(
                        productModel -> new ProductDTO(
                                productModel.getProductId(),
                                productModel.getName(),
                                productModel.getQuantity(),
                                productModel.getPrice(),
                                productModel.getDescription(),
                                productModel.getCode()))
                .collect(Collectors.toList());
        return products;
    }

    // Method to retrieve a product by its code
    public Optional<ProductDTO> getProductByCode(int code) {
        Optional<ProductModel> productOptional = productRepository.findByCode(code);

        if (productOptional.isPresent()) {
            // Map ProductModel to ProductDTO if present
            return productOptional.map(
                    productItem -> new ProductDTO(productOptional.get())
            );
        }
        else {
            throw new NotFoundException("Product with code: " + code + "not found!");
        }
    }

    // Method to save a new product
    public ProductModel saveProduct(@NotNull ProductDTO productDTO) {
        // Create ProductModel object from ProductDTO
        ProductModel productModel = new ProductModel(productDTO);

        try {
            // Save the new product to the repository
            var savedProduct = productRepository.save(productModel);
            return savedProduct;
        }
        catch (Exception e){
            throw new SaveErrorException("Error to save product");
        }
    }

    // Method to update an existing product
    public ProductDTO updateProduct(@NotNull ProductDTO productDTO) {
        // Find product in repository by its ID/*
        Optional<ProductModel> updateProductOptional = productRepository.findById(productDTO.getId());

        if(updateProductOptional.isPresent()){
            ProductModel updateProduct = updateProductOptional.get();
            // Update the product
            updateProduct.setName(productDTO.getName());
            updateProduct.setQuantity(productDTO.getQuantity());
            updateProduct.setPrice(productDTO.getPrice());
            updateProduct.setDescription(productDTO.getDescription());
            updateProduct.setCode(productDTO.getCode());

            // Save the updated product to the repository
            var updatedProduct = productRepository.save(updateProduct);
            return new ProductDTO(updatedProduct);
        }
        else {
            // Handle case where product with provided ID is not found
            throw new UpdateErrorException("Error to update Product");
        }
    }

    // Method to delete a product by its code
    public void deleteProduct(@NotNull ProductDTO product) {
        try {
            productRepository.deleteByCode(product.getCode());
        }
        catch (Exception e){
            throw new DeletionErrorException("Error to delete product with Id: " + product.getId());
        }
    }
}