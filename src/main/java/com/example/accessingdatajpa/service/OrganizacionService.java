package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Organizacion;
import com.example.accessingdatajpa.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizacionService {

    @Autowired
    private OrganizacionRepository organizacionRepository;

    public List<Organizacion> getAllOrganizaciones() {
        return organizacionRepository.findAll();
    }

    public Optional<Organizacion> getOrganizacionById(Long id) {
        return organizacionRepository.findById(id);
    }

    public Organizacion saveOrganizacion(Organizacion organizacion) {
        return organizacionRepository.save(organizacion);
    }

    public void deleteOrganizacion(Long id) {
        organizacionRepository.deleteById(id);
    }
}
