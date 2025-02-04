package com.example.store.repositories;

import com.example.store.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>{
    Optional<CustomerModel> findByName(String name);

}
