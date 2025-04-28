package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Tecnologia;
import com.example.accessingdatajpa.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    public List<Tecnologia> getAllTecnologias() {
        return tecnologiaRepository.findAll();
    }

    public Optional<Tecnologia> getTecnologiaById(Long id) {
        return tecnologiaRepository.findById(id);
    }

    public Tecnologia saveTecnologia(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    public void deleteTecnologia(Long id) {
        tecnologiaRepository.deleteById(id);
    }
}
