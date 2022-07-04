package com.example.testesdconecta.services;

import com.example.testesdconecta.controllers.dtos.CreateUser;
import com.example.testesdconecta.controllers.dtos.UpdateUser;
import com.example.testesdconecta.controllers.dtos.UserQueryParameter;
import com.example.testesdconecta.models.Crm;
import com.example.testesdconecta.models.UserSD;

import java.util.List;

public interface UserService {
    UserSD saveUser(UserSD userSD);

    Crm saveCrm(Crm crm);

    //    void addCrmToUser(String email, String crm);
//    UserSD getUser(String email);
    List<UserSD> getUsers();

    List<Crm> getCrm();

    UserSD getUserById(Integer userId);

    Crm getCrmById(Integer crmId);


    void deleteUserById(Integer userId);

    void deleteAllCrm(Integer userId);

    UserSD save(CreateUser createUser);

    UserSD save(Integer userId, UpdateUser updateUser);

    List<UserSD> findAll(UserQueryParameter queryParameter);
}
