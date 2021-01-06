package com.reto.backend.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_computadora")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComputadora;
    private String marca;
    private String serie;
    private String tipoPantalla;
    private String tarjetaVideo;
    private String tipoLectora;

    @OneToOne(mappedBy = "computadora")
    @JoinColumn(name = "id")
    private Comun comun;


}
