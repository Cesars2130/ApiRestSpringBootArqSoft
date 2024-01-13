package com.application.apiSpringBoot.SpringBootRest.persistence;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;

import java.util.List;
import java.util.Optional;

public interface IProductTypeDAO {

    List<ProductType> findAll();
    Optional <ProductType> findById(Long id);
    void save(ProductType productType);

    void deleteById(Long id);

}
