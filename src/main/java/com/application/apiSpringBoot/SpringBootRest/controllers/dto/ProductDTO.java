package com.application.apiSpringBoot.SpringBootRest.controllers.dto;

import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String Description;
    private BigDecimal price;
    private ProductType productType;
}
