package com.gestor.gestor.repositorys;

import com.gestor.gestor.entitys.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
    @Query("SELECT SUM(i.monto) FROM Ingreso i")
    Double sumMonto();
}