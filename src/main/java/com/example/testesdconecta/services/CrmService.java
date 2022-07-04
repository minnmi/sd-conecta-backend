package com.example.testesdconecta.services;

import com.example.testesdconecta.controllers.dtos.SaveCrmWithSpecialtyRequest;
import com.example.testesdconecta.models.UserSD;

import java.util.List;

public interface CrmService {
    void save(UserSD createdUser, List<SaveCrmWithSpecialtyRequest> crmList);
}
