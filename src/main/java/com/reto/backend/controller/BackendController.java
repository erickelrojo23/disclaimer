package com.reto.backend.controller;

import com.reto.backend.model.api.ReadResponse;
import com.reto.backend.model.entity.Comun;
import com.reto.backend.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo")
public class BackendController {

    @Autowired
    OperacionService operacionService;

    @PostMapping("/crear")
    public List<Comun> createBackend(@RequestBody Comun tipoObjeto) {

        List<Comun> listCreate = operacionService.create(tipoObjeto);
        return listCreate;
    }


    @GetMapping("/listar")
    public List<ReadResponse> readBackend() {
        List<ReadResponse> listRead = operacionService.read();
        return listRead;
    }
}
