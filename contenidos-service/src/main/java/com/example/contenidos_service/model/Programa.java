package com.example.contenidos_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Programa, producto o servicio RSE de CORPALIV / Alba Lab
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String categoria;
	private String descripcion;
	private String destinoAporte;
	private String tipoColaboracion;
}
