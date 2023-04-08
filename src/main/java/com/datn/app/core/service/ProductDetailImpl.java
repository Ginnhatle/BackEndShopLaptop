package com.datn.app.core.service;

import com.datn.app.core.entity.ProductDetail;
import com.datn.app.core.repo.ProductDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
@RequiredArgsConstructor
public class ProductDetailImpl implements ProductDetailService {
    private final ProductDetailRepo productDetailRepo;

    @Override
    public ProductDetail Save(ProductDetail productDetail) {
        return productDetailRepo.save(productDetail);
    }

    @Override
    public ProductDetail doUpdateById(ProductDetail productDetail, Long aLong) {
        ProductDetail prd = productDetailRepo.findById(aLong).get();
        prd.setQuantity(prd.getQuantity());
        return productDetailRepo.save(prd);
    }

    @Override
    public ProductDetail doDeleteById(Long aLong) {
        ProductDetail prd = productDetailRepo.findById(aLong).orElse(null);
        productDetailRepo.delete(prd);
        return null;
    }

    @Override
    public ProductDetail doFindById(Long aLong) {
        return productDetailRepo.findById(aLong).orElse(null);
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepo.findAll();
    }

    @Override
    public Page<ProductDetail> findAll(Integer page, Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return productDetailRepo.findAll(pageable);
    }
}
