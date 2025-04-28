package com.example.accessingdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Afiliacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_afiliacion;

    private Long id_personaje;
    private Long id_organizacion;
    private String rol;
    private String fecha_ingreso;

    // Getters y Setters

    public Long getId_afiliacion() {
        return id_afiliacion;
    }

    public void setId_afiliacion(Long id_afiliacion) {
        this.id_afiliacion = id_afiliacion;
    }

    public Long getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Long getId_organizacion() {
        return id_organizacion;
    }

    public void setId_organizacion(Long id_organizacion) {
        this.id_organizacion = id_organizacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}
