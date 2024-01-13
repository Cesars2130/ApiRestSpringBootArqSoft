package com.application.apiSpringBoot.SpringBootRest.controllers;

import com.application.apiSpringBoot.SpringBootRest.controllers.dto.ProductDTO;
import com.application.apiSpringBoot.SpringBootRest.controllers.dto.ProductTypeDTO;
import com.application.apiSpringBoot.SpringBootRest.entities.Product;
import com.application.apiSpringBoot.SpringBootRest.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .Description(product.getDescription())
                    .productType(product.getProductType()).build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> productDTOList = productService.findAll().stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .Description(product.getDescription())
                        .price(product.getPrice())
                        .productType(product.getProductType()).build()
                ).toList();
        return ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(ProductDTO productDTO) throws URISyntaxException {
        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getDescription().isBlank() || productDTO.getProductType() == null) {
            return ResponseEntity.badRequest().build();
        }
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .Description((productDTO.getDescription()))
                .productType(productDTO.getProductType())
                .build();
        productService.save(product);
        return ResponseEntity.created(new URI("/api/Product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO){
            Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setProductType(productDTO.getProductType());
            product.setDescription(productDTO.getDescription());
            productService.save(product);
            return ResponseEntity.ok("Registro Actualizado Correctamente");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id")
    public ResponseEntity<?> deleteById (@PathVariable Long id){
        if (id !=null){
            productService.deleteById(id);
            ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
