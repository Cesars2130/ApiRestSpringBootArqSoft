package com.application.apiSpringBoot.SpringBootRest.persistence.impl;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;
import com.application.apiSpringBoot.SpringBootRest.persistence.IProductTypeDAO;
import com.application.apiSpringBoot.SpringBootRest.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductTypeDAOimpl implements IProductTypeDAO {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return (List<ProductType>) productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void deleteById(Long id) {
        productTypeRepository.deleteById(id);
    }
}
