package com.reto.backend.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_laptop")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLaptop;
    private String marca;
    private String serie;
    private String tipoPantalla;
    private String tarjetaVideo;
    private String tipoLectora;

    @OneToOne(mappedBy = "laptop")
    @JoinColumn(name = "id")
    private Comun comun;

}
