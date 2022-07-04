package com.example.testesdconecta.controllers.dtos;

import com.example.testesdconecta.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveCrmWithSpecialtyRequest {

    @NotEmpty(message = "Crm cant be empty")
    @NotNull(message = "Crm name cant be null")
    private String crm;
    @NotEmpty(message = "UF cant be empty")
    @NotNull(message = "UF cant be null")
    private UF uf;
    private String specialty;
}
