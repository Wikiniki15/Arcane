package com.example.accessingdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class UsoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_personaje")
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name = "id_tecnologia")
    private Tecnologia tecnologia;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
}
