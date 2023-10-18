package com.example.distribuidora.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    private Integer idCategory;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 30)
    private String nameOfCategory;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 100)
    private String descriptionCategory;
}
