# Proyecto Backend: API de Productos

Este proyecto es una API REST que permite obtener información sobre productos y productos similares mediante solicitudes HTTP.

## Configuración inicial

Antes de ejecutar la aplicación, asegúrate de tener configurado el entorno de desarrollo correctamente.


## Scripts disponibles

En el directorio del proyecto, puedes ejecutar los siguientes comandos:

### `mvn spring-boot:run`

Este comando ejecuta la aplicación en modo de desarrollo, lo que te permitirá hacer peticiones a la API en `http://localhost:5000`.

#### Realiza peticiones a la API, GET http://localhost:8080/product/{productId}/similar

#### Respuestas de la API

1. 200 OK: Respuesta exitosa con los productos similares.
2. 404 Not Found: Si el producto solicitado no existe o no tiene productos similares.
3. 500 Internal Server Error: Si ocurre un error en el servicio. (productId 5)


### `mvn clean install`

Este comando limpia el proyecto y lo compila, generando el artefacto JAR para producción.


## Tecnologías utilizadas

- **Spring Boot**: Framework utilizado para desarrollar la API RESTful.
- **RestTemplate**: Utilizado para realizar las solicitudes HTTP al servicio externo que proporciona la información de los productos.

## Arquitectura y Patrones de Diseño

### Arquitectura General

La aplicación sigue una arquitectura basada en servicios, siguiendo los principios de diseño SOLID para garantizar que el código sea limpio, modular y fácil de mantener. La aplicación se organiza en las siguientes capas:

#### Capa de Presentación (Controller)
- Gestiona las solicitudes HTTP y coordina la interacción con la capa de servicios.
- Recibe las peticiones y responde con los resultados obtenidos de la capa de lógica de negocio.

#### Capa de Lógica de Negocio (Client)
- Contiene la lógica para obtener información de productos y sus productos similares.
- Realiza las interacciones necesarias con el cliente HTTP (`ProductClient`) para obtener los datos de productos desde un servicio externo.


### Manejo de Errores

La aplicación maneja errores de forma centralizada a través de excepciones personalizadas y un controlador global (`GlobalExceptionHandler`).

- **ErrorDetails**: Estructura de datos utilizada para representar los errores y devolver respuestas detalladas en caso de fallos.
