package com.example.testesdconecta.models;

import com.example.testesdconecta.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Crm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crm_id")
    private Integer crmId;

    @Column(name = "user_crm")
    private String crm;

    @Column(name = "uf")
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Basic(optional = true)
    @Column(name = "specialty")
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_crm_user_idx"))
    private UserSD userSD;
}
