package com.application.apiSpringBoot.SpringBootRest.services;

import com.application.apiSpringBoot.SpringBootRest.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    void save(Product product);
    void deleteById(Long id);
}
