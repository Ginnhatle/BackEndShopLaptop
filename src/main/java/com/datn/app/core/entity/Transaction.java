package com.datn.app.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction")
@Data
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "transaction_id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Payment.class)
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
