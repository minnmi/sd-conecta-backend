package com.example.testesdconecta.repositories;

import com.example.testesdconecta.models.Crm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface CrmRepository extends JpaRepository<Crm, Integer> {

    // Crm findByCrmName(String crm);

    @Modifying
    @Query(value = "DELETE FROM CRM WHERE CRM.USER_ID=?1", nativeQuery = true)
    void deleteAllByUserId(Integer idUser);


}
