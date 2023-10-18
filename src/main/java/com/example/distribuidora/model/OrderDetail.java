package com.example.distribuidora.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@IdClass(OrderDetailPK.class)
public class OrderDetail {

    @Id
    private Order order;

    @Id
    private Product product;

    @Column(nullable = false)
    private short quantity;
}
