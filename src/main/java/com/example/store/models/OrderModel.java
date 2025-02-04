package com.example.store.models;

import com.example.store.models.dtos.OrderDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @ManyToMany
    @JoinTable(name = "order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductModel> products = new ArrayList<>();

    public OrderModel(){}

    public OrderModel(OrderDTO order) {
        this.orderId = order.getOrderId();
        this.customer = order.getCustomer();
        this.products = order.getProducts();
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerModel getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public List<ProductModel> getProducts() {
        return products;
    }
    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
