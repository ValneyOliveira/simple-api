package com.example.store.models.dtos;

import com.example.store.models.ProductModel;

public class ProductDTO {
    private int productId;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private int code;

    public ProductDTO(int productId, String name, int quantity, double price, String description, int code){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.code = code;
    }

    public ProductDTO(ProductModel productModel){
        this.productId = productModel.getProductId();
        this.name = productModel.getName();
        this.quantity = productModel.getQuantity();
        this.description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.code = productModel.getCode();
    }

    public int getId(){
        return productId;
    }
    public void setId(int productId){
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

}
