package com.gestor.gestor.entitys;

import jakarta.persistence.*;
import lombok.Data; // Asumo que usas Lombok
import java.time.LocalDate;

@Entity
@Data
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private Double monto;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}