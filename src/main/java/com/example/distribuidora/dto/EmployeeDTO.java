package com.example.distribuidora.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private Integer idEmployee;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String card;

    @NotNull
    private LocalDateTime dateIngress;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String telephone;

}
