package com.application.apiSpringBoot.SpringBootRest.controllers.dto;

import com.application.apiSpringBoot.SpringBootRest.entities.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductTypeDTO {
    private Long id;
    private String name;

    private List<Product> productList = new ArrayList<>();
}
