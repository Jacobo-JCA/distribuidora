package com.example.distribuidora.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {

    private Integer idClient;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    private String ruc;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String nameContact;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String card;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String direction;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String city;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String department;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String telephone;
}
