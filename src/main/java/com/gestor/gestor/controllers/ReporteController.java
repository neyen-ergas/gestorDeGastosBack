package com.gestor.gestor.controllers;

import com.gestor.gestor.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/balance")
    public Map<String, Double> getBalanceTotal() {
        Double balance = reporteService.calcularBalanceTotal();

        Map<String, Double> response = new HashMap<>();
        response.put("balanceTotal", balance);
        return response;
    }
}