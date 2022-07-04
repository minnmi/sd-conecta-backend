package com.example.testesdconecta.services;

import com.example.testesdconecta.controllers.dtos.CreateUser;
import com.example.testesdconecta.controllers.dtos.UpdateUser;
import com.example.testesdconecta.controllers.dtos.UserQueryParameter;
import com.example.testesdconecta.exceptions.EntityNotFoundException;
import com.example.testesdconecta.models.Crm;
import com.example.testesdconecta.models.UserSD;
import com.example.testesdconecta.repositories.CrmRepository;
import com.example.testesdconecta.repositories.UserSDRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserSDRepository userSDRepository;
    private final CrmRepository crmRepository;
    private final CrmService crmService;

    @Override
    public UserSD saveUser(UserSD userSD) {
        return userSDRepository.save(userSD);
    }

    @Override
    public Crm saveCrm(Crm crm) {
        return crmRepository.save(crm);
    }

//    @Override
//    public void addCrmToUser(String email, String crm) {
//        UserSD userSD = userSDRepository.findByEmail(email);
//        Crm crmName = crmRepository.findByCrmName(crm);
//        userSD.getCrmCollection().add(crmName);
//
//    }

//    @Override
//    public UserSD getUser(String email) {
//        return userSDRepository.findByEmail(email);
//    }

    @Override
    public List<UserSD> getUsers() {
        return userSDRepository.findAll();
    }

    @Override
    public List<Crm> getCrm() {
        return crmRepository.findAll();
    }

    @Override
    public UserSD getUserById(Integer userId) {
        UserSD userSaved = this.userSDRepository.findById(userId).orElseThrow();
        return userSaved;
    }

    @Override
    public UserSD save(CreateUser createUser) {
        var user = new UserSD();
        BeanUtils.copyProperties(createUser, user, "crmList", "userId");
        var createdUser = this.userSDRepository.save(user);
        this.crmService.save(createdUser, createUser.getCrmList());
        return createdUser;
    }

    @Override
    public UserSD save(Integer userId, UpdateUser updateUser) {
        var user = this.userSDRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found."));
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        user.setSurname(updateUser.getSurname());
        user.setMobilePhone(updateUser.getMobilePhone());
        var updatedUser = this.userSDRepository.save(user);
        this.crmService.save(updatedUser, updateUser.getCrmList());
        return updatedUser;
    }

    @Override
    public List<UserSD> findAll(UserQueryParameter queryParameter) {
        return this.userSDRepository.findAllByFilter(queryParameter.getName(), queryParameter.getName(), queryParameter.getSpecialty(), queryParameter.getSpecialty());
    }



    @Override
    public void deleteUserById(Integer userId) {
       deleteAllCrm(userId);

       userSDRepository.deleteById(userId);
    }

    @Override
    public void deleteAllCrm(Integer userId) {
        final var crmList = crmRepository.findAllByUserId(userId);
        for (var crm : crmList) {
            crmService.deleteById(crm.getCrmId());
        }
    }

    @Override
    public Crm getCrmById(Integer crmId) {
        Crm crmSaved = this.crmRepository.findById(crmId).orElseThrow();
        return crmSaved;
    }



}
