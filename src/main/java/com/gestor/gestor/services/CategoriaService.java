package com.gestor.gestor.services;

import com.gestor.gestor.entitys.Categoria;
import com.gestor.gestor.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        categoria.setName(categoriaDetails.getName());
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        categoriaRepository.delete(categoria);
    }
}
