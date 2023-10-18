package com.example.distribuidora.dto;

import com.example.distribuidora.model.Category;
import com.example.distribuidora.model.Provider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Integer idProduct;

    @NotNull
    private Category category;

    @NotNull
    private Provider provider;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @Min(value = 1)
    @Max(value = 9999)
    private double priceBuy;

    @Min(value = 1)
    @Max(value = 9999)
    private double priceSale;

    @NotNull
    private short stockCurrent;

    @NotNull
    private short stockMin;

}
