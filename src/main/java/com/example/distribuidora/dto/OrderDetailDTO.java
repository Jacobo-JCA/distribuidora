package com.example.distribuidora.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {

    @NotNull
    private OrderDTO order;

    @NotNull
    private ProductDTO product;

    private short quantity;
}
