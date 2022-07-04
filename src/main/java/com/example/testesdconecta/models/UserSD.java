package com.example.testesdconecta.models;

import com.example.testesdconecta.enums.Authorization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_sd")
public class UserSD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_email")
    @NotNull
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "authorization_status")
    @Enumerated(EnumType.STRING)
    private Authorization authorizationStatus;

    @OneToMany(mappedBy = "crm", fetch = FetchType.EAGER)
    private Collection<Crm> crmCollection = new ArrayList<>();
}
