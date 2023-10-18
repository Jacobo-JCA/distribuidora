package com.example.distribuidora.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "order_data")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name="FK_ORDER_CLIENT"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_EMPLOYEE"))
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_transporter", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_TRANSPORTER"))
    private Transporter transporter;

    @Column(nullable = false)
    private LocalDateTime dateOrder;

    @Column(nullable = false)
    private LocalDateTime dateShipping;

    @Column(nullable = false, length = 100)
    private String direction;

    @Column(columnDefinition = "decimal(6,2)")
    private double valueOrder;

}
