package com.demo.disclaimer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "acceptance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idDisclaimer", referencedColumnName ="id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public DisclaimerEntity disclaimerId;

    public Long userId;

    public String createAt;

}
