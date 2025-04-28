package com.example.accessingdatajpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tecnologia;

    private String nombre;
    private String tipo;
    private String descripcion;

    @OneToMany(mappedBy = "tecnologia", cascade = CascadeType.ALL)
    private List<UsoTecnologia> usosTecnologia;

    // Getters y Setters

    public Long getId_tecnologia() {
        return id_tecnologia;
    }

    public void setId_tecnologia(Long id_tecnologia) {
        this.id_tecnologia = id_tecnologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UsoTecnologia> getUsosTecnologia() {
        return usosTecnologia;
    }

    public void setUsosTecnologia(List<UsoTecnologia> usosTecnologia) {
        this.usosTecnologia = usosTecnologia;
    }
}
