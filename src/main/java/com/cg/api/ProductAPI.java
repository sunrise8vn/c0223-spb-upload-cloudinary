package com.cg.api;


import com.cg.model.dto.product.ProductCreReqDTO;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> addNew(@ModelAttribute ProductCreReqDTO productCreReqDTO) {

        productService.create(productCreReqDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
