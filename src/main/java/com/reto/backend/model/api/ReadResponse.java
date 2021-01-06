package com.reto.backend.model.api;

import com.reto.backend.model.entity.Computadora;
import com.reto.backend.model.entity.Laptop;
import com.reto.backend.model.entity.MaquinaEscribir;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;

import java.util.List;

@Setter
@Getter
public class ReadResponse {

    private Computadora computadora;
    private JSONArray laptopArray;
    private List<MaquinaEscribir> maquinaEscribirs;


}
