package com.example.testesdconecta.repositories;

import com.example.testesdconecta.models.Crm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrmRepository extends JpaRepository<Crm, Integer> {

    // Crm findByCrmName(String crm);

    @Modifying
    @Query(value = "DELETE FROM CRM WHERE CRM.USER_ID=?1", nativeQuery = true)
    void deleteAllByUserId(Integer idUser);

    @Query(value =
            "SELECT CRM.* " +
            "FROM CRM " +
            "WHERE (CRM.USER_ID=?1)", nativeQuery = true)
    List<Crm> findAllByUserId(Integer userId);


}
