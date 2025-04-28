package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Organizacion;
import com.example.accessingdatajpa.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Organizacion> actualizarOrganizacion(Long id, Organizacion organizacionDetalles) {
        Optional<Organizacion> organizacionOptional = organizacionRepository.findById(id);
        if (organizacionOptional.isPresent()) {
            Organizacion organizacionExistente = organizacionOptional.get();
            organizacionExistente.setNombre(organizacionDetalles.getNombre());
            organizacionExistente.setCiudad_base(organizacionDetalles.getCiudad_base());
            organizacionExistente.setTipo(organizacionDetalles.getTipo());
            organizacionRepository.save(organizacionExistente);
            return ResponseEntity.ok(organizacionExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
