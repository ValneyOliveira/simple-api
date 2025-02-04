package com.example.store.controllers;

import com.example.store.models.dtos.CustomerDTO;
import com.example.store.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/store")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") @RequestBody int id){
        var customer = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        var customerSaved = customerService.saveCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Customer " + customerSaved.getName() + "Saved!");
    }

    @DeleteMapping("/customers")
    public ResponseEntity<String> deleteCustomer(@RequestBody CustomerDTO customer){
        customerService.deleteCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer Saved successfully!");
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customer){
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}
