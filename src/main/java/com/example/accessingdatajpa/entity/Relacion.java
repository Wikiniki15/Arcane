package com.example.accessingdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_relacion;

    private Long id_personaje_a;
    private Long id_personaje_b;
    private String tipo_relacion;

    // Getters y Setters

    public Long getId_relacion() {
        return id_relacion;
    }

    public void setId_relacion(Long id_relacion) {
        this.id_relacion = id_relacion;
    }

    public Long getId_personaje_a() {
        return id_personaje_a;
    }

    public void setId_personaje_a(Long id_personaje_a) {
        this.id_personaje_a = id_personaje_a;
    }

    public Long getId_personaje_b() {
        return id_personaje_b;
    }

    public void setId_personaje_b(Long id_personaje_b) {
        this.id_personaje_b = id_personaje_b;
    }

    public String getTipo_relacion() {
        return tipo_relacion;
    }

    public void setTipo_relacion(String tipo_relacion) {
        this.tipo_relacion = tipo_relacion;
    }
}
