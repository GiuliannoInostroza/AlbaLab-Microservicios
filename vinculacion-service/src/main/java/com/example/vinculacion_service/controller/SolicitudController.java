package com.example.vinculacion_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vinculacion_service.dto.SolicitudDTO;
import com.example.vinculacion_service.model.Solicitud;
import com.example.vinculacion_service.service.SolicitudService;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

	private final SolicitudService solicitudService;

	public SolicitudController(SolicitudService solicitudService) {
		this.solicitudService = solicitudService;
	}

	@PostMapping
	public ResponseEntity<SolicitudDTO> crearSolicitud(@RequestBody SolicitudDTO solicitudDto) {
		Solicitud nueva = solicitudService.guardar(solicitudDto.toModel());
		return ResponseEntity.ok(SolicitudDTO.fromModel(nueva));
	}

	@GetMapping("/usuario/{correo}")
	public ResponseEntity<List<SolicitudDTO>> listarPorUsuario(@PathVariable String correo) {
		List<Solicitud> solicitudes = solicitudService.listarPorUsuario(correo);
		List<SolicitudDTO> dtos = solicitudes.stream().map(SolicitudDTO::fromModel).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SolicitudDTO> actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudDTO solicitudDto) {
		Solicitud actualizada = solicitudService.actualizar(id, solicitudDto.toModel());
		return ResponseEntity.ok(SolicitudDTO.fromModel(actualizada));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarSolicitud(@PathVariable Long id) {
		solicitudService.eliminar(id);
		return ResponseEntity.ok("Solicitud eliminada exitosamente");
	}
}
