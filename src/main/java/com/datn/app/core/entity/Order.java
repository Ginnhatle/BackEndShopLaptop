package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "oders")
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    private String code;
    private String address;
    private String phoneNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private Integer status;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,targetEntity = OrderDetail.class)
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,targetEntity = Transaction.class)
    private List<Transaction> transactions;
}
