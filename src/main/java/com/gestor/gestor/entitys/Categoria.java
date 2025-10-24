package com.gestor.gestor.entitys;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "categoria")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ya lo tenías
    private String name;

    // NUEVOS CAMPOS
    // nombre lógico del icono (ej: "pig", "wallet", "bus"...)
    @Column(length = 50)
    private String icon;

    // color ARGB en hex (ej: "FF7BE0C3")
    @Column(length = 16)
    private String color;

    public Categoria() {}

    public Categoria(Long id, String name, String icon, String color) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
