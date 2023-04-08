package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;

    private Double price;

    private Double discount;

    private String description;

    private Integer status;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

}
