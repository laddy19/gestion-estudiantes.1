# 🎓 Proyecto: Gestión de Estudiantes y Calificaciones

## 📘 Descripción General
Este proyecto es una **API RESTful** desarrollada con **Spring Boot (Java)** que permite gestionar estudiantes y sus calificaciones.  
Incluye operaciones **CRUD (Crear, Leer, Actualizar y Eliminar)**, validación de datos y conexión con una base de datos MySQL.  
También se integra una interfaz sencilla en **HTML (index.html)** para probar la API desde el navegador.

---

## 🎯 Alcance del Proyecto

**Objetivo General:**  
Desarrollar una aplicación web que permita registrar y administrar estudiantes junto con sus calificaciones.

**Objetivos Específicos:**
- Implementar un backend con **Spring Boot** siguiendo el patrón **MVC**.  
- Diseñar endpoints RESTful para operaciones CRUD.  
- Conectar la aplicación con una base de datos **MySQL**.  
- Validar los datos de entrada y manejar errores de forma controlada.  
- Documentar la arquitectura, endpoints y configuración del entorno.

---

## 🧱 Arquitectura Seleccionada: MVC (Modelo - Vista - Controlador)

El patrón **MVC** (Modelo-Vista-Controlador) organiza el código en capas con responsabilidades bien definidas:

| Capa | Descripción | Ejemplo |
|------|--------------|----------|
| **Modelo (Model)** | Representa las entidades del sistema. | `Estudiante.java`, `Calificacion.java` |
| **Repositorio (Repository)** | Gestiona la persistencia de datos con JPA. | `EstudianteRepository.java` |
| **Servicio (Service)** | Contiene la lógica de negocio y validaciones. | `EstudianteService.java` |
| **Controlador (Controller)** | Expone los endpoints REST a los usuarios. | `EstudianteController.java` |
| **Vista (View)** | Interfaz simple en HTML para probar la API. | `index.html` |

**Ventajas del patrón MVC:**
- Separación de responsabilidades.  
- Facilita el mantenimiento y escalabilidad.  
- Favorece la reutilización de código.  
- Permite la integración de distintas interfaces (web, API, móvil).

---

## 📂 Estructura del Proyecto

```
gestion_estudiantes/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mafe/gestion_estudiantes/
│   │   │       ├── controller/
│   │   │       │   └── EstudianteController.java
│   │   │       ├── model/
│   │   │       │   └── Estudiante.java
│   │   │       ├── repository/
│   │   │       │   └── EstudianteRepository.java
│   │   │       ├── service/
│   │   │       │   └── EstudianteService.java
│   │   │       └── GestionEstudiantesApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html
│   │       ├── templates/ (opcional)
│   │       └── application.properties
│   └── test/
│       └── ...
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## ⚙️ Tecnologías Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.x**
- 🗄️ **Spring Data JPA / Hibernate**
- 🐬 **MySQL**
- ⚙️ **Maven**
- 🌐 **HTML5 / CSS3**
- 🧩 **Git / GitHub**

---

## 🚀 Instalación y Ejecución

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/usuario/gestion_estudiantes.git
cd gestion_estudiantes
```

### 2️⃣ Configurar la Base de Datos en `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_estudiantes
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Ejecutar el Proyecto

#### Opción 1: Desde IntelliJ IDEA
1. Abre el proyecto.
2. Ejecuta la clase `GestionEstudiantesApplication.java` (clic en ▶️ Run).

#### Opción 2: Desde la Terminal
```bash
mvn spring-boot:run
```

### 4️⃣ Acceder a la Aplicación
- **API:** [http://localhost:8080/api/estudiantes](http://localhost:8080/api/estudiantes)  
- **Interfaz Web:** [http://localhost:8080/index.html](http://localhost:8080/index.html)

---

## 🧠 Justificación del Patrón de Arquitectura

El patrón **MVC** se adoptó porque:

- Mejora la organización y comprensión del código.  
- Facilita el mantenimiento y la incorporación de nuevas funcionalidades.  
- Permite trabajar en paralelo entre el backend y el frontend.  
- Es estándar en aplicaciones empresariales con **Spring Boot**.

---

## 👨‍💻 Autor

**María Fernanda Gómez Castro**  
📅 Octubre 2025  
📍 Proyecto académico
