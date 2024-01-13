package com.application.apiSpringBoot.SpringBootRest.controllers;

import com.application.apiSpringBoot.SpringBootRest.controllers.dto.ProductTypeDTO;
import com.application.apiSpringBoot.SpringBootRest.entities.ProductType;

import com.application.apiSpringBoot.SpringBootRest.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ProductType")

public class ProductTypeController {
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id){

        Optional<ProductType> productTypeOptional = iProductTypeService.findById(id);

        if (productTypeOptional.isPresent()){
            ProductType productType = productTypeOptional.get();

            ProductTypeDTO  productTypeDTO = ProductTypeDTO.builder()
                    .id(productType.getId())
                    .name(productType.getName())
                    .productList(productType.getProductList())
                    .build();

            return ResponseEntity.ok(productTypeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public  ResponseEntity <?> findAll(){
        List<ProductTypeDTO> productTypeDTOList = iProductTypeService.findAll()
                .stream()
                .map(productType -> ProductTypeDTO.builder()
                        .id(productType.getId())
                        .name(productType.getName())
                        .productList(productType.getProductList())
                        .build()).toList();
        return ResponseEntity.ok(productTypeDTOList);

    }

@PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody ProductTypeDTO productTypeDTO) throws URISyntaxException {
    if (productTypeDTO.getName().isBlank()) {
        return ResponseEntity.badRequest().build();
    }

    iProductTypeService.save(ProductType.builder().name(productTypeDTO.getName()).build());
    return ResponseEntity.created(new URI("/api/ProductType/save")).build();
    }


    @PutMapping
    public ResponseEntity<?> updateProductType (@PathVariable Long id, @RequestBody ProductTypeDTO productTypeDTO){
        Optional<ProductType> productTypeOptional = iProductTypeService.findById(id);
        if (productTypeOptional.isPresent()) {
            ProductType productType = productTypeOptional.get();
            productType.setName(productTypeDTO.getName());
            iProductTypeService.save(productType);
            return ResponseEntity.ok("Resgistro Actualizado");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(id != null){
            iProductTypeService.deleteById(id);
            return ResponseEntity.ok("Resgistro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
