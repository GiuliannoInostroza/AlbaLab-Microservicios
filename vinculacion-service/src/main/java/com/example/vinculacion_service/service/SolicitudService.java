package com.example.vinculacion_service.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vinculacion_service.exception.ResourceNotFoundException;
import com.example.vinculacion_service.model.Solicitud;
import com.example.vinculacion_service.repository.SolicitudRepository;

@Service
public class SolicitudService {

	private final SolicitudRepository solicitudRepository;

	public SolicitudService(SolicitudRepository solicitudRepository) {
		this.solicitudRepository = solicitudRepository;
	}

	// Toda solicitud nueva parte en estado RECIBIDA y con su fecha de creación
	public Solicitud guardar(Solicitud solicitud) {
		solicitud.setId(null);
		solicitud.setEstado("RECIBIDA");
		solicitud.setFechaCreacion(new Date());
		return solicitudRepository.save(solicitud);
	}

	public List<Solicitud> listarPorUsuario(String correo) {
		return solicitudRepository.findByUsuarioCorreo(correo);
	}

	// Solo se cambian los datos del formulario; el estado y la fecha de creación se mantienen
	public Solicitud actualizar(Long id, Solicitud solicitud) {
		Solicitud existente = solicitudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Solicitud no existe"));
		existente.setNombre(solicitud.getNombre());
		existente.setTipo(solicitud.getTipo());
		existente.setCantidad(solicitud.getCantidad());
		existente.setFecha(solicitud.getFecha());
		existente.setMensaje(solicitud.getMensaje());
		existente.setRecurrente(solicitud.getRecurrente());
		existente.setAceptaContacto(solicitud.getAceptaContacto());
		return solicitudRepository.save(existente);
	}

	public void eliminar(Long id) {
		Solicitud existente = solicitudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Solicitud no existe"));
		solicitudRepository.delete(existente);
	}
}
