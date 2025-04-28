package com.example.accessingdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_personaje_a")
    private Personaje personajeA;

    @ManyToOne
    @JoinColumn(name = "id_personaje_b")
    private Personaje personajeB;

    private String tipo_relacion;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getPersonajeA() {
        return personajeA;
    }

    public void setPersonajeA(Personaje personajeA) {
        this.personajeA = personajeA;
    }

    public Personaje getPersonajeB() {
        return personajeB;
    }

    public void setPersonajeB(Personaje personajeB) {
        this.personajeB = personajeB;
    }

    public String getTipo_relacion() {
        return tipo_relacion;
    }

    public void setTipo_relacion(String tipo_relacion) {
        this.tipo_relacion = tipo_relacion;
    }
}
