package com.example.store.repositories;

import com.example.store.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    Optional<ProductModel> findByCode(int code);
    Optional<ProductModel> findByName(String name);
    Optional<ProductModel> deleteByCode(int code);

}
