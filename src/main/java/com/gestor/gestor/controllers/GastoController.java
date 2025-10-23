package com.gestor.gestor.controllers;

import com.gestor.gestor.services.GastoService;
import com.gestor.gestor.entitys.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestor/gasto")
public class GastoController {
    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Gasto> getAllProducts() {
        return gastoService.getAllGastos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> getGastoById(@PathVariable Long id) {
        return gastoService.getGastoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gasto createGasto(@RequestBody Gasto product) {
        return gastoService.saveGasto(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> updateGasto(@PathVariable Long id, @RequestBody Gasto gastoDetails) {
        return ResponseEntity.ok(gastoService.updateGasto(id, gastoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long id) {
        gastoService.deleteGasto(id);
        return ResponseEntity.noContent().build();
    }
}
