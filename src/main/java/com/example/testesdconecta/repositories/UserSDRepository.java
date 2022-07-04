package com.example.testesdconecta.repositories;

import com.example.testesdconecta.controllers.dtos.UserQueryParameter;
import com.example.testesdconecta.models.Crm;
import com.example.testesdconecta.models.UserSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserSDRepository extends JpaRepository<UserSD, Integer> {
//    UserSD findByEmail(String email);

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<UserSD> findAll(UserQueryParameter parameter) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<UserSD> query = cb.createQuery(UserSD.class);
//        Root<UserSD> user = query.from(UserSD.class);
//        Root<Crm> crm = query.from(Crm.class);
//        var select = query.select(user);
//        List<Predicate> predicates = new ArrayList<>();
//        if (parameter.getName() != null && !parameter.getName().isEmpty()) {
//            Path<String> namePath = user.get("name");
//            predicates.add(cb.like(namePath, parameter.getName()));
//            select.where(cb.and(cb.like(namePath, parameter.getName())));
//        }
//        if (parameter.getSpecialty() != null && !parameter.getSpecialty().isEmpty()) {
//            Path<String> specialtyPath = crm.get("specialty");
//
//            predicates.add(cb.like(specialtyPath, parameter.getName()));
//            select.where(cb.and(cb.like(specialtyPath, parameter.getName())));
//        }
//
//        return entityManager.createQuery(query)
//                .getResultList();
//    }

   /*
   SELECT USER_SD.*
   FROM USER_SD
   JOIN CRM ON CRM.USER_ID = USER_SD.ID
   WHERE USER_SD.NAME LIKE "%NAME%" AND (CRM.SPECIALTY IS NULL OR CRM.SPECIALTY LIKE "%specialty%") GROUP BY USER_US.ID
    */

    @Modifying
    @Query(value = "SELECT USER_SD.* " +
            "FROM USER_SD " +
            "LEFT JOIN CRM ON CRM.USER_ID = USER_SD.USER_ID " +
            "WHERE (?1 IS NULL OR USER_SD.USER_NAME LIKE %?2%) " +
            "AND (?3 IS NULL OR CRM.SPECIALTY IS NULL OR CRM.SPECIALTY LIKE %?4%) " +
            "GROUP BY USER_SD.USER_ID ", nativeQuery = true)
    List<UserSD> findAllByFilter(String name1, String name2, String specialty1, String specialty2);

//    @Query(value =
//            "SELECT " +
//            "   NEW com.example.testesdconecta.controllers.dtos.UserQueryParameter( " +
//            "   Crm.specialty " +
//            " )" +
//            "" +
//            "FROM UserSD userSD " +
//            "JOIN userSD.specialty specialty " +
//            " " +
//            "WHERE " + "((:specialty is null or :userSD.specialty like concat('%' :specialty, '%')) " +
//            List<UserQueryParameter> findAllByFilter(
//                    String specialty,
//                    String name
//    );

/*
queryParameter
 */

}
