package com.example.testesdconecta.services;

import com.example.testesdconecta.controllers.dtos.SaveCrmWithSpecialtyRequest;
import com.example.testesdconecta.models.Crm;
import com.example.testesdconecta.models.UserSD;
import com.example.testesdconecta.repositories.CrmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CrmServiceImpl implements CrmService {

    private final CrmRepository crmRepository;

    @Override
    public void save(UserSD userSD, List<SaveCrmWithSpecialtyRequest> crmList) {
        if (userSD.getUserId() > 0) {
            crmRepository.deleteAllByUserId(userSD.getUserId());
        }
        for (var crmRequest : crmList) {
            var crm = new Crm();
            crm.setCrm(crmRequest.getCrm());
            crm.setUf(crmRequest.getUf());
            crm.setSpecialty(crmRequest.getSpecialty());
            crm.setUserSD(userSD);
            this.crmRepository.save(crm);
        }
    }
}
