package com.example.store.models;

import com.example.store.models.dtos.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true)
    private int productId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private int code;

    //Constructors
    public ProductModel(){}

    public ProductModel(ProductDTO productDTO){
        this.productId = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.description = productDTO.getDescription();
        this.quantity = productDTO.getQuantity();
        this.code = productDTO.getCode();
    }


    public ProductModel(int productId, String name, int quantity, double price, String description, int code){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.code = code;
    }


    // GETTERS AND SETTERS

    public int getProductId(){
        return productId;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code = code;
    }


}
