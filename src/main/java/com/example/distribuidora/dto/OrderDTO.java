package com.example.distribuidora.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDTO {

    @EqualsAndHashCode.Include
    private Integer idOrder;

    @NotNull
    private Integer client;

    @NotNull
    private Integer employee;

    @NotNull
    private Integer transporter;

    @NotNull
    private LocalDateTime dateOrder;

    @NotNull
    private LocalDateTime dateShipping;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String direction;

    @Min(value = 1)
    @Max(value = 9999)
    private double valueOrder;

}
