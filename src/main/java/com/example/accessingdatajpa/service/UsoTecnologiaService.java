package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.UsoTecnologia;
import com.example.accessingdatajpa.repository.UsoTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsoTecnologiaService {

    @Autowired
    private UsoTecnologiaRepository usoTecnologiaRepository;

    public List<UsoTecnologia> getAllUsosTecnologia() {
        return usoTecnologiaRepository.findAll();
    }

    public Optional<UsoTecnologia> getUsoTecnologiaById(Long id) {
        return usoTecnologiaRepository.findById(id);
    }

    public UsoTecnologia saveUsoTecnologia(UsoTecnologia usoTecnologia) {
        return usoTecnologiaRepository.save(usoTecnologia);
    }

    public void deleteUsoTecnologia(Long id) {
        usoTecnologiaRepository.deleteById(id);
    }
}
