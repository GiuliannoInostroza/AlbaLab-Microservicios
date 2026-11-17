package com.example.vinculacion_service.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Solicitud de colaboración que envía un usuario desde la app
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usuarioCorreo;
	private String nombre;
	private String tipo;
	private Integer cantidad;
	private Long fecha;
	private String mensaje;
	private Boolean recurrente;
	private Boolean aceptaContacto;
	private String estado;
	private Date fechaCreacion;
}
