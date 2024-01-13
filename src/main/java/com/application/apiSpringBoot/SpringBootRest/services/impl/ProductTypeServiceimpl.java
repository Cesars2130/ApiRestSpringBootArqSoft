package com.application.apiSpringBoot.SpringBootRest.services.impl;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;
import com.application.apiSpringBoot.SpringBootRest.persistence.IProductTypeDAO;
import com.application.apiSpringBoot.SpringBootRest.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceimpl implements IProductTypeService {

    @Autowired
    private IProductTypeDAO iProductTypeDAO;

    @Override
    public List<ProductType> findAll() {
        return iProductTypeDAO.findAll();
    }

    @Override
    public Optional<ProductType> findById(Long id) {
        return iProductTypeDAO.findById(id);
    }

    @Override
    public void save(ProductType productType) {
        iProductTypeDAO.save(productType);
    }

    @Override
    public void deleteById(Long id) {
        iProductTypeDAO.deleteById(id);
    }
}
