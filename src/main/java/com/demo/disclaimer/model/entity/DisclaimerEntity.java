package com.demo.disclaimer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "disclaimer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisclaimerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String text;
    public String version;
    public String create_at;
    public String update_at;



}
