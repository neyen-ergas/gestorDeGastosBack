package com.gestor.gestor.controllers;

import com.gestor.gestor.entitys.Categoria;
import com.gestor.gestor.entitys.Gasto;
import com.gestor.gestor.services.CategoriaService;
import com.gestor.gestor.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gestor/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategoria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getGastoById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateGasto(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoriaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
