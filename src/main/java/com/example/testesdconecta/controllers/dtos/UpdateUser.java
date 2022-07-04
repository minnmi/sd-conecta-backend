package com.example.testesdconecta.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {
    private Integer id;
    @NotEmpty(message = "name cant be empty")
    @NotNull(message = "name cant be null")
    private String name;
    @NotEmpty(message = "email cant be empty")
    @NotNull(message = "email name cant be null")
    private String email;
    private String surname;
    private String mobilePhone;
    private List<SaveCrmWithSpecialtyRequest> crmList;
}
