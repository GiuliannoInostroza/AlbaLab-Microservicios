# AlbaLab-Microservicios

Backend en **Spring Boot** de la app móvil [Alba Lab Conecta](https://github.com/GiuliannoInostroza/AppAlbaLab) para el caso **CORPALIV / Alba Lab** (Evaluación Parcial 4).

## Integrantes

- Giulianno Inostroza
- Pascal Pacheco
- Nicolás Pérez

## Microservicios

| Servicio | Puerto | Base de datos | Responsabilidad |
|---|---|---|---|
| `api-gateway` | 9090 | - | Puerta de entrada única. Revisa el token JWT y reenvía cada ruta a su microservicio |
| `auth-service` | 9094 | `bd_users` | Registro e inicio de sesión de usuarios; entrega el token JWT |
| `contenidos-service` | 9091 | `bd_contenidos` | Programas, productos y servicios RSE de la organización |
| `vinculacion-service` | 9092 | `bd_vinculacion` | Solicitudes de colaboración (CRUD completo) |

Cada servicio de negocio tiene los paquetes `model` (entidad JPA), `dto` (lo que viaja en JSON, con `toModel()` y `fromModel()`), `repository` (JpaRepository), `service` (lógica), `controller` (endpoints REST) y `config` (Liquibase). Las tablas y los datos de ejemplo se crean con Liquibase desde `src/main/resources/db/changelog/db.changelog.sql`.

## Endpoints

Todos se llaman a través del gateway: `http://localhost:9090` (desde el emulador: `http://10.0.2.2:9090`). Las rutas que no son `/auth/**` necesitan el encabezado `Authorization: Bearer <token>`; sin él el gateway responde 401.

| Método | Endpoint | Servicio | Descripción |
|---|---|---|---|
| POST | `/auth/register` | auth-service | Crea un usuario. Cuerpo: `{"email": "...", "password": "..."}` |
| POST | `/auth/login` | auth-service | Devuelve `{"status": "ok", "token": "..."}` o `{"status": "error", "token": ""}` |
| GET | `/programas` | contenidos-service | Lista los programas |
| POST | `/programas` | contenidos-service | Crea un programa |
| GET | `/solicitudes/usuario/{correo}` | vinculacion-service | Lista las solicitudes de un usuario |
| POST | `/solicitudes` | vinculacion-service | Crea una solicitud; queda en estado RECIBIDA con su fecha de creación |
| PUT | `/solicitudes/{id}` | vinculacion-service | Actualiza los datos del formulario (404 si no existe) |
| DELETE | `/solicitudes/{id}` | vinculacion-service | Elimina la solicitud (404 si no existe) |

## Pasos para ejecutar

Requisitos: Java 21, Docker Desktop y MySQL en el puerto 3306 con usuario `root` sin contraseña (por ejemplo XAMPP). Las bases de datos se crean solas.

### Windows (laboratorio)

1. Encender MySQL (XAMPP) y Docker Desktop.
2. Si la red bloquea Maven Central, ejecutar `actualizar-maven.bat` (usa el mirror de `configuracion-maven`).
3. Compilar los 4 servicios: `build-all.bat`.
4. Levantar los contenedores: `docker compose up -d --build`.
5. Probar: `curl http://localhost:9090/programas` debe responder 401 (falta el token), lo que confirma que el gateway está arriba.

### Linux o macOS

```bash
for s in api-gateway auth-service contenidos-service vinculacion-service; do (cd $s && sh mvnw clean package -DskipTests); done
docker compose up -d --build
```

### Probar con Postman

1. En Postman: **Import** > elegir `postman/AlbaLab-Microservicios.postman_collection.json`.
2. Ejecutar **1. auth-service > Iniciar sesión**: guarda el token JWT en la variable `token` y las demás peticiones lo envían solas.
3. Probar el resto en orden. **Crear solicitud** guarda el `id` creado, que usan **Actualizar** y **Eliminar**.
4. **Programas SIN token** muestra que el gateway responde 401 si falta el token.

Los servicios tienen `spring.jpa.show-sql=true`, así que `docker compose logs -f vinculacion-service` muestra cada `insert`, `update` y `delete` que llega desde la app o desde Postman.

### Probar con curl

```bash
curl -X POST http://localhost:9090/auth/register -H "Content-Type: application/json" -d '{"email":"prueba@alba.cl","password":"Clave123"}'
curl -X POST http://localhost:9090/auth/login -H "Content-Type: application/json" -d '{"email":"prueba@alba.cl","password":"Clave123"}'
curl http://localhost:9090/programas -H "Authorization: Bearer <token>"
```
