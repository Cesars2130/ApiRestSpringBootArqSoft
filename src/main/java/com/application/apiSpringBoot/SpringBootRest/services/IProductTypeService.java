package com.application.apiSpringBoot.SpringBootRest.services;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;

import java.util.List;
import java.util.Optional;

public interface IProductTypeService {
    List<ProductType> findAll();
    Optional<ProductType> findById(Long id);
    void save(ProductType productType);

    void deleteById(Long id);
}
