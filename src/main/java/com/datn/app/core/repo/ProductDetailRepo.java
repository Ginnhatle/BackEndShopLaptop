package com.datn.app.core.repo;

import com.datn.app.core.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {
}
