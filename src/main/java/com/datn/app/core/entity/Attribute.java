package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "attributes")
@Data
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "attribute_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    private String name;

    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
}
