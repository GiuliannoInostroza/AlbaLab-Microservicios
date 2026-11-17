--liquibase formatted sql

--changeset albalab:1
CREATE TABLE programa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    categoria VARCHAR(100),
    descripcion VARCHAR(500),
    destino_aporte VARCHAR(255),
    tipo_colaboracion VARCHAR(100)
);

--changeset albalab:2
INSERT INTO programa (nombre, categoria, descripcion, destino_aporte, tipo_colaboracion) VALUES
('Preparación para el empleo', 'Programa', 'Talleres donde jóvenes y adultos con discapacidad múltiple desarrollan rutinas de trabajo, comunicación y autonomía.', 'Materiales de taller y monitores de apoyo.', 'Donación'),
('Escuela Especial Jan Van Dijk', 'Programa', 'Educación especializada para estudiantes con discapacidad múltiple, con foco en comunicación y vida independiente.', 'Recursos pedagógicos y adaptaciones de aula.', 'Donación'),
('Red Sociolaboral Alba Lab', 'Programa', 'Conecta a los participantes con empresas y acompaña su adaptación al puesto de trabajo.', 'Seguimiento laboral y apoyo a los equipos de las empresas.', 'Alianza empresarial'),
('Productos de los talleres', 'Producto', 'Artículos elaborados por los participantes de los talleres de producción.', 'Insumos y continuidad de los talleres.', 'Compra de productos'),
('Regalos corporativos', 'Producto', 'Packs para empresas en fechas especiales, preparados en los talleres.', 'Insumos y apoyo a los participantes.', 'Compra de productos'),
('Voluntariado corporativo', 'Servicio RSE', 'Jornadas en que equipos de una empresa comparten actividades con los estudiantes.', 'Actividades recreativas y de integración.', 'Voluntariado'),
('Capacitación en inclusión', 'Servicio RSE', 'Charlas para empresas sobre cómo incluir a personas con discapacidad en sus equipos.', 'Financia los programas de la organización.', 'Capacitación');
