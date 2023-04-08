package com.datn.app.core.dto;

import com.datn.app.core.entity.Category;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ProductDTO {

    private String name;

    private Double price;

    private Double discount;

    private String description;

    private Integer status;

    private Long categoryId; 
}
