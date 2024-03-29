package com.application.apiSpringBoot.SpringBootRest.repository;

import com.application.apiSpringBoot.SpringBootRest.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
