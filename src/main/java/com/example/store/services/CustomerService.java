package com.example.store.services;

import com.example.store.exceptions.*;
import com.example.store.models.CustomerModel;
import com.example.store.models.dtos.CustomerDTO;
import com.example.store.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerModel> customerModels = customerRepository.findAll();
        // Map CustomerModel objects to CustomerDTOs
        var customerDTO = customerModels.stream().map(item -> {
            CustomerDTO customer = new CustomerDTO();

            customer.setCustumerId(item.getCustumerId());
            customer.setName(item.getName());
            customer.setPhoneNumber(item.getPhoneNumber());
            customer.setEmail(item.getEmail());
            customer.setAddress(item.getAddress());
            customer.setJoinDate(item.getJoinDate());
            return customer;
        }).collect(Collectors.toList());

        if (customerDTO.iterator().hasNext()){
            return customerDTO;
        }else {
            throw new InvalidDataException("Error to get all Customers!!");
        }
    }

    public CustomerDTO getCustomerById(int id){
        Optional<CustomerModel> customerModel = customerRepository.findById(id);

        if(customerModel.isPresent()){
            return new CustomerDTO(customerModel.get());
        } else {
            throw new NotFoundException("Customer with Id: " + id + " not found!");
        }
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){

        try {
            CustomerModel customerModel = new CustomerModel(customerDTO);
            var customerSaved = customerRepository.save(customerModel);

            return new CustomerDTO(customerSaved);
        }
        catch (Exception e){
            throw new SaveErrorException("Customer not saved!!");
        }
    }

    public CustomerDTO updateCustomer(Integer customerId, CustomerDTO customerDTO){
        Optional<CustomerModel> customerOptional = customerRepository.findById(customerDTO.getCustumerId());

        if(customerOptional.isPresent()){
            CustomerModel updateCustomer = customerOptional.get();

            updateCustomer.setName(customerDTO.getName());
            updateCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
            updateCustomer.setEmail(customerDTO.getEmail());
            updateCustomer.setAddress(customerDTO.getAddress());
            var customer = customerRepository.save(updateCustomer);
            return new CustomerDTO(customer);
        }
        else {
            throw new UpdateErrorException("Error to update customer with Id: " + customerDTO.getCustumerId());
        }
    }

    public void deleteCustomer(CustomerDTO customerDTO){

        try{
            customerRepository.deleteById(customerDTO.getCustumerId());
        }
        catch (Exception e){
            throw new DeletionErrorException("Error to delete Customer with Id: " + customerDTO.getCustumerId() + " not found!");
        }
    }
}
