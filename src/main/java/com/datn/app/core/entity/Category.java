package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`name`")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Attribute.class)
    @JoinTable(name = "category_attribute",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Set<Attribute> attributes;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
