package com.example.vinculacion_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vinculacion_service.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // Spring arma la consulta solo a partir del nombre del método
    List<Solicitud> findByUsuarioCorreo(String usuarioCorreo);
}
