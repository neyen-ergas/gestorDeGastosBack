package com.gestor.gestor.services; // O el paquete correcto

import com.gestor.gestor.repositorys.GastoRepository;
import com.gestor.gestor.repositorys.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReporteService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private GastoRepository gastoRepository;


    public Double calcularBalanceTotal() {
        Double totalIngresos = ingresoRepository.sumMonto();
        Double totalGastos = gastoRepository.sumPrice();

        if (totalIngresos == null) {
            totalIngresos = 0.0;
        }
        if (totalGastos == null) {
            totalGastos = 0.0;
        }

        return totalIngresos - totalGastos;
    }
}