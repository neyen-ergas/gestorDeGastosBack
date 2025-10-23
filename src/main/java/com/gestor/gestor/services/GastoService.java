package com.gestor.gestor.services;

import com.gestor.gestor.entitys.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestor.gestor.repositorys.GastoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GastoService {
    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> getAllGastos() {
        return gastoRepository.findAll();
    }

    public Optional<Gasto> getGastoById(Long id) {
        return gastoRepository.findById(id);
    }

    public Gasto saveGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto updateGasto(Long id, Gasto gastoDetails) {
        Gasto gasto = gastoRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        gasto.setName(gastoDetails.getName());
        gasto.setDescription(gastoDetails.getDescription());
        gasto.setPrice(gastoDetails.getPrice());
        gasto.setCategoria(gastoDetails.getCategoria());
        return gastoRepository.save(gasto);
    }

    public void deleteGasto(Long id) {
        Gasto gasto = gastoRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        gastoRepository.delete(gasto);
    }

}
