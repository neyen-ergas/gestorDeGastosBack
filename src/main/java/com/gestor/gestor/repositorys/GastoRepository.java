package com.gestor.gestor.repositorys;

import com.gestor.gestor.entitys.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto,Long> {
    @Query("SELECT SUM(g.price) FROM Gasto g")
    Double sumPrice();
}
