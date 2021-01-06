package com.reto.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "tbl_comun")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean teclado;
    private boolean mouse;
    private String tipoObjeto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idComputadora", referencedColumnName ="idComputadora", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Computadora computadora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idLaptop", referencedColumnName ="idLaptop", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Laptop laptop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idMaquina", referencedColumnName ="idMaquina", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private MaquinaEscribir maquinaEscribir;

}
