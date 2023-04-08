package com.datn.app.core.service;

import com.datn.app.core.dto.ProductDTO;
import com.datn.app.core.entity.Product;
import com.datn.app.core.service.base.ServiceCore;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductService extends ServiceCore<Product, Long> {
    ResponseEntity<?> SaveP(ProductDTO productDTO);
}
