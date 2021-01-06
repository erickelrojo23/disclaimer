package com.reto.backend.service;

import com.reto.backend.model.entity.Comun;
import com.reto.backend.model.api.ReadResponse;

import java.util.List;

public interface OperacionService {

    public List<Comun> create(Comun tipoObjeto);

    public List<ReadResponse> read();

}
