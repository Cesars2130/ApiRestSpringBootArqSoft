package com.application.apiSpringBoot.SpringBootRest.persistence.impl;

import com.application.apiSpringBoot.SpringBootRest.entities.Product;
import com.application.apiSpringBoot.SpringBootRest.persistence.IProductDAO;
import com.application.apiSpringBoot.SpringBootRest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOimpl implements IProductDAO {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll() ;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
