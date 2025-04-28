package com.example.accessingdatajpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_organizacion;

    private String nombre;
    private String ciudad_base;
    private String tipo;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    private List<Afiliacion> afiliaciones;

    // Getters y Setters

    public Long getId_organizacion() {
        return id_organizacion;
    }

    public void setId_organizacion(Long id_organizacion) {
        this.id_organizacion = id_organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad_base() {
        return ciudad_base;
    }

    public void setCiudad_base(String ciudad_base) {
        this.ciudad_base = ciudad_base;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Afiliacion> getAfiliaciones() {
        return afiliaciones;
    }

    public void setAfiliaciones(List<Afiliacion> afiliaciones) {
        this.afiliaciones = afiliaciones;
    }
}
