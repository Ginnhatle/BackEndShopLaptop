package com.datn.app.core.service;

import com.datn.app.core.dto.ProductDTO;
import com.datn.app.core.entity.Attribute;
import com.datn.app.core.entity.Category;
import com.datn.app.core.entity.Product;
import com.datn.app.core.repo.AttributeRepo;
import com.datn.app.core.repo.CategoryRepo;
import com.datn.app.core.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final AttributeRepo attributeRepo;

    @Override
    public ResponseEntity<?> SaveP(ProductDTO productDTO) {
        Category category = categoryRepo.findById(productDTO.getCategoryId()).orElse(null);
        Product product = new Product();
        try {
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDiscount(productDTO.getDiscount());
            product.setDescription(productDTO.getDescription());
            product.setCategory(category);
//            product.setStatus(ProductType.EFFECT);
//            product.setPublisher(publisher);
        } catch (RuntimeException e) {
            throw new RuntimeException("có lỗi xảy ra khi thêm sản phẩm");
        }
        productRepo.save(product);
        Attribute attribute = new Attribute();
        attribute.setName(attribute.getName());
        attributeRepo.save(attribute);
        Map<String, Object> response = new HashMap<>();
        response.put("product", product);
        response.put("message", "Thêm sản phẩm thành công");
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);

    }

    @Override
    public Product Save(Product product) {
        return null;
    }

    @Override
    public Product doUpdateById(Product product, Long aLong) {
        Product prd = productRepo.findById(aLong).get();
        prd.setName(product.getName());
        prd.setPrice(product.getPrice());
//        prd.setStatus(product.getStatus());
        prd.setDescription(product.getDescription());
        return productRepo.save(prd);
    }

    @Override
    public Product doDeleteById(Long aLong) {

        return null;
    }

    @Override
    public Product doFindById(Long aLong) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> findAll(Integer page, Integer size) {
        return null;
    }
}
