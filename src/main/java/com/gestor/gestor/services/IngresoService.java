package com.gestor.gestor.services;

import com.gestor.gestor.entitys.Ingreso;
import com.gestor.gestor.repositorys.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    public List<Ingreso> getAllIngresos() {
        return ingresoRepository.findAll();
    }

    public Optional<Ingreso> getIngresoById(Long id) {
        return ingresoRepository.findById(id);
    }

    public Ingreso saveIngreso(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    public Ingreso updateIngreso(Long id, Ingreso ingresoDetails) {

        Ingreso ingreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ingreso no encontrado con ID: " + id));

        ingreso.setDescripcion(ingresoDetails.getDescripcion());
        ingreso.setMonto(ingresoDetails.getMonto());
        ingreso.setFecha(ingresoDetails.getFecha());
        ingreso.setCategoria(ingresoDetails.getCategoria()); // Si usas la relación

        return ingresoRepository.save(ingreso);
    }

    public void deleteIngreso(Long id) {
        Ingreso ingreso = ingresoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ingreso no encontrado con ID: " + id));
        ingresoRepository.delete(ingreso);
    }
}