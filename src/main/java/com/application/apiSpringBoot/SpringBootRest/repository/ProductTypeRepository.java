package com.application.apiSpringBoot.SpringBootRest.repository;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

}
