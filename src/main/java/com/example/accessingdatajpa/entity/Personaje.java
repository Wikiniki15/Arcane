package com.example.accessingdatajpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personaje;

    private String nombre;
    private String origen;
    private String rol;
    private String alineacion;

    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<Afiliacion> afiliaciones;

    @OneToMany(mappedBy = "personajeA", cascade = CascadeType.ALL)
    private List<Relacion> relacionesA;

    @OneToMany(mappedBy = "personajeB", cascade = CascadeType.ALL)
    private List<Relacion> relacionesB;

    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
    private List<UsoTecnologia> usosTecnologia;

    // Getters y Setters

    public Long getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public List<Afiliacion> getAfiliaciones() {
        return afiliaciones;
    }

    public void setAfiliaciones(List<Afiliacion> afiliaciones) {
        this.afiliaciones = afiliaciones;
    }

    public List<Relacion> getRelacionesA() {
        return relacionesA;
    }

    public void setRelacionesA(List<Relacion> relacionesA) {
        this.relacionesA = relacionesA;
    }

    public List<Relacion> getRelacionesB() {
        return relacionesB;
    }

    public void setRelacionesB(List<Relacion> relacionesB) {
        this.relacionesB = relacionesB;
    }

    public List<UsoTecnologia> getUsosTecnologia() {
        return usosTecnologia;
    }

    public void setUsosTecnologia(List<UsoTecnologia> usosTecnologia) {
        this.usosTecnologia = usosTecnologia;
    }
}
