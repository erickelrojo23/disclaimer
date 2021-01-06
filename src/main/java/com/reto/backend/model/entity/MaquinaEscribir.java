package com.reto.backend.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_maquina")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaquinaEscribir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquina;
    private String marca;
    private String serie;

    @OneToOne(mappedBy = "maquinaEscribir")
    @JoinColumn(name = "id")
    private Comun comun;

}
