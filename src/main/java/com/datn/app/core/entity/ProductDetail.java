package com.datn.app.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_detail")
@Data
public class ProductDetail implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    @OneToMany(mappedBy = "productDetail",cascade = CascadeType.ALL,targetEntity = Image.class)
    @JsonIgnore
    private List<Image> images;
}
