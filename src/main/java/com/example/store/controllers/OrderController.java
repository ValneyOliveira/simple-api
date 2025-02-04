package com.example.store.controllers;

import com.example.store.models.dtos.OrderDTO;
import com.example.store.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/store/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // Retrieves all orders
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    // Retrieves an order by its ID
    @GetMapping("/order/{id}")
    public ResponseEntity<Optional<OrderDTO>> findOrderById(@PathVariable("id") Integer orderId){
        var order = orderService.findOrderById(orderId);
        //return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    // Saves a new order
    @PostMapping("/orders")
    public ResponseEntity<String> saveOrder(@RequestBody OrderDTO order){
        var savedOrderId = orderService.saveOrder(order);
        return ResponseEntity.ok().body("Order saved with ID: " + savedOrderId);
    }

    // Updates an existing order
    @PutMapping("/order/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Integer orderId, @Valid @RequestBody OrderDTO orderDTO){
        //orderService.updateOrder(orderDTO);
        orderService.updateOrder(orderId, orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");
    }

    // Deletes an order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().body("Order deleted successfully");
    }
}
