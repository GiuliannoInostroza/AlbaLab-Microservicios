--liquibase formatted sql

--changeset albalab:1
CREATE TABLE solicitud (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_correo VARCHAR(255),
    nombre VARCHAR(255),
    tipo VARCHAR(100),
    cantidad INT,
    fecha BIGINT,
    mensaje VARCHAR(500),
    recurrente BOOLEAN,
    acepta_contacto BOOLEAN,
    estado VARCHAR(30),
    fecha_creacion DATETIME
);
