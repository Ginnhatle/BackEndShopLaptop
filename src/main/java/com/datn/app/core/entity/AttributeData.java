package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "attribute_data")
public class AttributeData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "attribute_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "attribute_data_value")
    private String value;
    @Column(name = "attribute_data_type")

    private String type;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Attribute.class)
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = ProductDetail.class)
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;
}
