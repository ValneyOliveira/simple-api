package com.example.store.models.dtos;

import com.example.store.models.CustomerModel;
import com.example.store.models.OrderModel;
import com.example.store.models.ProductModel;
import java.util.List;

public class OrderDTO {
    private int orderId;

    private CustomerModel customer;

    private List<ProductModel> products;

    public OrderDTO(){}

    public OrderDTO(OrderModel order) {
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
