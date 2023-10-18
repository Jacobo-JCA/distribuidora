package com.example.distribuidora.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_provider", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_PROVIDER"))
    private Provider provider;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double priceBuy;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double priceSale;

    @Column(nullable = false)
    private short stockCurrent;

    @Column(nullable = false)
    private short stockMin;

}
