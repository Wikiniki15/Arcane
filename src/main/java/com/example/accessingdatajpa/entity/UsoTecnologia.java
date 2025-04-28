package com.example.accessingdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_uso_tecnologia;

    private Long id_personaje;
    private Long id_tecnologia;

    // Getters y Setters

    public Long getId_uso_tecnologia() {
        return id_uso_tecnologia;
    }

    public void setId_uso_tecnologia(Long id_uso_tecnologia) {
        this.id_uso_tecnologia = id_uso_tecnologia;
    }

    public Long getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Long getId_tecnologia() {
        return id_tecnologia;
    }

    public void setId_tecnologia(Long id_tecnologia) {
        this.id_tecnologia = id_tecnologia;
    }
}
