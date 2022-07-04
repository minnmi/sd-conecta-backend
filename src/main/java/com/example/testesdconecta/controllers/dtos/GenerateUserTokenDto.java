package com.example.testesdconecta.controllers.dtos;

import com.example.testesdconecta.enums.Authorization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateUserTokenDto {

    private String accessToken;
    private String refreshToken;
    private Authorization authorizationStatus;
}
