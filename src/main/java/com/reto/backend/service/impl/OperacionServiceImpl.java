package com.reto.backend.service.impl;


import com.reto.backend.model.api.ReadResponse;
import com.reto.backend.model.entity.Computadora;
import com.reto.backend.model.entity.Comun;
import com.reto.backend.model.entity.Laptop;
import com.reto.backend.model.entity.MaquinaEscribir;
import com.reto.backend.repository.ComputadoraRepository;
import com.reto.backend.repository.ComunRepository;
import com.reto.backend.repository.LaptopRepository;
import com.reto.backend.repository.MaquinaEscribirRepository;
import com.reto.backend.service.OperacionService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperacionServiceImpl implements OperacionService {

    @Autowired
    ComunRepository comunRepository;

    @Autowired
    ComputadoraRepository computadoraRepository;

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    MaquinaEscribirRepository maquinaEscribirRepository;

    @Override
    public List<Comun> create(Comun tipoObjeto) {
        Comun comun = new Comun();
        comun.setTipoObjeto(tipoObjeto.getTipoObjeto());

        if (tipoObjeto.getComputadora() != null) {
            comun.setMouse(Boolean.TRUE);
            comun.setTeclado(Boolean.TRUE);

            comun.setComputadora(Computadora.builder()
                    .marca(tipoObjeto.getComputadora().getMarca())
                    .serie(tipoObjeto.getComputadora().getSerie())
                    .tipoPantalla(tipoObjeto.getComputadora().getTipoPantalla())
                    .tarjetaVideo(tipoObjeto.getComputadora().getTarjetaVideo())
                    .tipoLectora(tipoObjeto.getComputadora().getTipoLectora())
                    .build());

        } else if (tipoObjeto.getLaptop() != null) {
            comun.setMouse(Boolean.TRUE);
            comun.setTeclado(Boolean.TRUE);

            comun.setLaptop(Laptop.builder()
                    .marca(tipoObjeto.getLaptop().getMarca())
                    .serie(tipoObjeto.getLaptop().getSerie())
                    .tipoPantalla(tipoObjeto.getLaptop().getTipoPantalla())
                    .tarjetaVideo(tipoObjeto.getLaptop().getTarjetaVideo())
                    .tipoLectora(tipoObjeto.getLaptop().getTipoLectora())
                    .build());

        } else if (tipoObjeto.getMaquinaEscribir() != null) {
            comun.setMouse(Boolean.FALSE);
            comun.setTeclado(Boolean.TRUE);

            comun.setMaquinaEscribir(MaquinaEscribir.builder()
                    .marca(tipoObjeto.getMaquinaEscribir().getMarca())
                    .serie(tipoObjeto.getMaquinaEscribir().getSerie())
                    .build());

        } else {
            comun.setMouse(Boolean.FALSE);
            comun.setTeclado(Boolean.FALSE);
        }

        comunRepository.save(comun);
        List<Comun> lista = new ArrayList<>();
        lista.add(comun);
        return lista;
    }

    @Override
    public List<ReadResponse> read() {

        List<ReadResponse> total = new ArrayList<>();
        ReadResponse readResponse = new ReadResponse();
        //compu -json
        Optional<Computadora> c = computadoraRepository.findById(1L);
        if (c.isPresent()) {
            readResponse.setComputadora(c.get());
        }


        //laptop - array
        Optional<Laptop> lap = laptopRepository.findById(1L);
        if(lap.isPresent()) {
            JSONArray array = new JSONArray();
            array.add("idLaptop: " + lap.get().getIdLaptop());
            array.add("marca: " + lap.get().getMarca());
            array.add("serie: " + lap.get().getSerie());
            array.add("pantalla: " + lap.get().getTipoPantalla());
            array.add("tarjetaVideo: " + lap.get().getTarjetaVideo());
            array.add("tipoLectora: " + lap.get().getTipoLectora());
            JSONArray array2 = new JSONArray();
            for (int i = 0; i < array.size(); i++) {
                JSONArray array1 = new JSONArray();
                array1.add(array.get(i));
                array2.add(array1);
            }
            readResponse.setLaptopArray(array2);
        }
        //maquina -lista

        Optional<MaquinaEscribir> m = maquinaEscribirRepository.findById(1L);
        List<MaquinaEscribir> lista = new ArrayList<>();
        if (m.isPresent()) {
            lista.add(m.get());
            readResponse.setMaquinaEscribirs(lista);
        }

        total.add(readResponse);
        return total;
    }


}
