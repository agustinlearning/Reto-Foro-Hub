Foro Hub API REST
¡Bienvenido al proyecto Foro Hub! Esta es una API REST desarrollada con Spring Boot como parte del desafío Foro Hub del bootcamp de programación ONE - Oracle Next Education by Alura Latam.

Descripción del Proyecto
Foro Hub es una API diseñada para gestionar un foro de discusión en línea. Permite a los usuarios interactuar creando, leyendo, actualizando y eliminando tópicos (CRUD), así como autenticarse para acceder a las funcionalidades protegidas.

Tecnologías Utilizadas
Java 17: Lenguaje de programación.

Spring Boot 3.x: Framework para construir la API REST.

Spring Data JPA: Para la persistencia de datos y la interacción con la base de datos.

Spring Security: Para la autenticación y autorización de usuarios (con JWT).

JWT (JSON Web Tokens): Para la seguridad de la API.

H2 Database: Base de datos en memoria para desarrollo y pruebas.

Flyway: Para la gestión de migraciones de la base de datos.

Lombok: Para reducir el código repetitivo (getters, setters, constructores, etc.).

Jakarta Validation: Para la validación de datos de entrada.

Características
Gestión de Tópicos:

Crear nuevos tópicos.

Listar todos los tópicos (con paginación).

Obtener detalles de un tópico específico.

Actualizar tópicos existentes.

"Eliminar" tópicos (eliminación lógica, cambiando su estado a cerrado).

Validaciones de Negocio:

No se permite crear tópicos duplicados (mismo título y mensaje).

Validación de campos obligatorios y formato en la entrada de datos.

Autenticación y Autorización:

Autenticación de usuarios mediante JWT.

Protección de endpoints para que solo usuarios autenticados puedan acceder a ciertas funcionalidades.

Manejo Global de Errores: Respuestas de error consistentes para validaciones y excepciones.

Cómo Ejecutar el Proyecto
Sigue estos pasos para levantar la aplicación en tu máquina local:

Clonar el Repositorio:

git clone https://github.com/rlipac31/foro-hub.git
cd foro-hub

Configuración de la Base de Datos:

El proyecto está configurado para usar Bases de datos locales, edita las variables de entorno con tus propios valores y crea una base de datos con el gestor de tu preferencia.

Las migraciones de la base de datos se gestionan con Flyway. Al iniciar la aplicación, Flyway creará las tablas necesarias (usuarios, cursos, topicos) y algunos datos de prueba iniciales.

Configuración de la Clave Secreta JWT:

Abre el archivo src/main/resources/application.properties.

Asegúrate de que la propiedad api.security.secret esté definida con una clave secreta fuerte:

api.security.token.secret

Importante: Cambia api.security.token.secret por una cadena aleatoria y compleja.

Compilar y Ejecutar:
Puedes ejecutar la aplicación usando Maven:

./mvnw spring-boot:run

O, si usas un IDE (como IntelliJ IDEA o VS Code), puedes ejecutar la clase principal ForohubApplication.java.

Endpoints de la API
Aquí están los principales endpoints disponibles en la API:

Autenticación
POST /login

Descripción: Autentica a un usuario y devuelve un token JWT.

Cuerpo de la Solicitud (JSON):

{
    "email": "alice@example.com",
    "contrasena": "password"
}

Respuesta Exitosa (JSON):

{
    "jwtToken": "eyJhbGciOiJIUzI1Ni..."
}

Tópicos
POST /topicos

Descripción: Crea un nuevo tópico. Requiere autenticación (JWT).

Headers: Authorization: Bearer <TU_TOKEN_JWT>

Cuerpo de la Solicitud (JSON):

{
    "titulo": "Título del nuevo tópico",
    "mensaje": "Contenido detallado del mensaje del tópico.",
    "autorId": 1,
    "nombreCurso": "Nombre del Curso"
}

GET /topicos

Descripción: Lista todos los tópicos con paginación. Requiere autenticación (JWT).

Headers: Authorization: Bearer <TU_TOKEN_JWT>

Parámetros de Consulta (Opcional): ?page=0&size=10&sort=fechaCreacion,desc

page: Número de página (por defecto 0).

size: Cantidad de elementos por página (por defecto 10).

sort: Campo por el que ordenar y dirección (ej. fechaCreacion,asc o titulo,desc).

GET /topicos/{id}

Descripción: Obtiene los detalles de un tópico específico por su ID. Requiere autenticación (JWT).

Headers: Authorization: Bearer <TU_TOKEN_JWT>

PUT /topicos/{id}

Descripción: Actualiza un tópico existente por su ID. Requiere autenticación (JWT).

Headers: Authorization: Bearer <TU_TOKEN_JWT>

Cuerpo de la Solicitud (JSON - campos opcionales):

{
    "titulo": "Nuevo título (opcional)",
    "mensaje": "Nuevo mensaje (opcional)",
    "estado": "CERRADO" (opcional, ej. ABIERTO, RESUELTO)
}

DELETE /topicos/{id}

Descripción: "Elimina" lógicamente un tópico por su ID (cambia su estado a CERRADO). Requiere autenticación (JWT).

Headers: Authorization: Bearer <TU_TOKEN_JWT>

Autor
Agustín Álvarez Batista

Mi github: https://github.com/agustinlearning

Mi Linkedin: www.linkedin.com/in/agustín-álvarez-364b4434a

¡Gracias por revisar el proyecto Foro Hub! Si tienes alguna pregunta o sugerencia, no dudes en contactarme.
