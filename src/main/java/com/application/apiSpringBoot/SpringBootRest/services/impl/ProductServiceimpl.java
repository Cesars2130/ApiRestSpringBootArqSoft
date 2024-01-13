package com.application.apiSpringBoot.SpringBootRest.services.impl;

import com.application.apiSpringBoot.SpringBootRest.entities.Product;
import com.application.apiSpringBoot.SpringBootRest.persistence.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimpl implements IProductDAO {

    @Autowired
    private IProductDAO iProductDAO;
    @Override
    public List<Product> findAll() {
        return iProductDAO.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductDAO.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductDAO.save(product);
    }

    @Override
    public void deleteById(Long id) {
        iProductDAO.deleteById(id);
    }
}
