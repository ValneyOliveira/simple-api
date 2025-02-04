package com.example.store.services;

import com.example.store.exceptions.*;
import com.example.store.models.OrderModel;
import com.example.store.models.dtos.OrderDTO;
import com.example.store.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders(){
        List<OrderModel> ordersModels = orderRepository.findAll();

        if(ordersModels.iterator().hasNext()){
            return ordersModels.stream().map(OrderDTO::new).collect(Collectors.toList());
        }
        else {
            throw new InvalidDataException("Error to list all orders!");
        }
    }

    public Optional<OrderDTO> findOrderById(Integer orderId){
        Optional<OrderModel> order = orderRepository.findById(orderId);

        if (order.isPresent()){
            return Optional.of(new OrderDTO(order.get()));
        }
        else {
            throw new NotFoundException("Order with Id: " + orderId + " not found!");
        }
    }

    public String saveOrder(OrderDTO order){
        OrderModel orderModel = new OrderModel(order);
        try {
            var orderSaved = orderRepository.save(orderModel);
            return orderSaved.toString();
        }
        catch (Exception e){
            throw new SaveErrorException("Error to save order!");
        }
    }

    public void deleteOrder(Integer orderId){
        var order = orderRepository.findById(orderId);

        if (order.isPresent()){
            orderRepository.deleteById(orderId);
        }
        else {
            throw new DeletionErrorException("Error to delete order with Id: " + orderId);
        }
    }

    @Transactional
    public OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO){
        Optional<OrderModel> order = orderRepository.findById(orderId);

        if(order.isPresent()){
            OrderModel orderModel = order.get();

            orderModel.setCustomer(orderDTO.getCustomer());
            orderModel.setProducts(orderDTO.getProducts());
            var updated = orderRepository.save(orderModel);
            
            return new OrderDTO(updated);
        }
        else {
            throw new UpdateErrorException("Error to update Order with Id: " + orderId);
        }
    }
}
