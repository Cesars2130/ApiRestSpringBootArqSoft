package com.application.apiSpringBoot.SpringBootRest.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "producto")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")

    private String Description;
    @Column(name = "precio")

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name= "id_tipoDeProducto", nullable = false)
    @JsonIgnore
    private ProductType productType;
}
