package com.datn.app.endpoint;

import com.datn.app.core.dto.ProductDTO;
import com.datn.app.core.entity.Product;
import com.datn.app.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
private final ProductService productService;
    @GetMapping("/find-all")
    public List<Product> getAll(){
        return productService.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO){

        return ResponseEntity.ok(productService.SaveP(productDTO));
    }
}
