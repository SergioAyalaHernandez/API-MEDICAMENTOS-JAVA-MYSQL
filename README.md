
## Resumen
El proyecto Medicamentos es una API RESTful desarrollada en Spring Boot para la gestión de medicamentos en un sistema de farmacia. Proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre la entidad "Medicamento".

## Endpoints

### Obtener un medicamento por ID
- **Método:** GET
- **URL:** `/api/v1/medicamento/byid/{id}`
- **Descripción:** Obtiene un medicamento específico por su ID.
- **Respuesta Exitosa (200):** Retorna el medicamento encontrado en formato JSON.
  ```json
  {"idMedicamento":1,"nombreMedicamento":"DolexForte"}
- **Respuesta Error (404):** Si el medicamento no es encontrado.
- **Respuesta Error (500):** Error interno del servidor.

### Eliminar un medicamento por ID
- **Método:** DELETE
- **URL:** `/api/v1/medicamento/{id}`
- **Descripción:** Elimina un medicamento existente en el sistema por su ID.
- **Respuesta Exitosa (200):** Retorna un booleano indicando si el medicamento fue eliminado correctamente.
- **Respuesta Error (404):** Si el medicamento no es encontrado.
- **Respuesta Error (500):** Error interno del servidor.

### Crear un nuevo medicamento
- **Método:** POST
- **URL:** `/api/v1/medicamento/`
- **Descripción:** Crea un nuevo medicamento en el sistema.
- **Respuesta Exitosa (200):** Retorna el medicamento creado en formato JSON.
  ```json
  {"idMedicamento":1,"nombreMedicamento":"DolexForte"}
  ```
- **Cuerpo de la Solicitud:**
  ```json
  {"nombreMedicamento":"DolexForte"}
  ```

### Actualizar un medicamento
- **Método:** PUT
- **URL:** `/api/v1/medicamento/{id}`
- **Descripción:** Actualiza un medicamento existente en el sistema.
- **Respuesta Exitosa (200):** Retorna el medicamento actualizado en formato JSON.
  ```json
  {"idMedicamento":1,"nombreMedicamento":"DolexForte"}
  ```
- **Cuerpo de la Solicitud:**
  ```json
  {"nombreMedicamento":"DolexForte"}
  ```

## Configuración del Proyecto
- **Lenguaje de Programación:** Java
- **Framework:** Spring Boot
- **Gestor de Base de Datos:** MySQL
- **Librerías Adicionales:** Lombok, Springdoc OpenAPI

## Configuración del Ambiente
- **Puerto del Servidor:** 8080
- **URL de la Base de Datos:** `jdbc:mysql://localhost:3307/medicamentos`
- **Usuario de la Base de Datos:** root
- **Contraseña de la Base de Datos:** (vacío)
- **Dialecto de Hibernate:** org.hibernate.dialect.MySQLDialect
- **Estrategia de Generación de Scripts:** update

## Documentación API (Swagger)
- **Habilitar Generación de Documentación:** true
- **Habilitar Interfaz de Usuario Swagger:** true
- **Ruta de la Interfaz de Usuario Swagger:** `/swagger.html`

## Base de datos
![db.png](db.png)
```