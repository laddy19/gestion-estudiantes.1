# 🧩 Punto 2: Desarrollo de los Servicios Web

## 📘 Descripción
En este punto se desarrollaron los servicios web de la aplicación **Gestión de Estudiantes** utilizando **Spring Boot** bajo el patrón **MVC**.  
Se implementaron endpoints RESTful que permiten realizar operaciones CRUD sobre los datos de los estudiantes.

---

## 🚀 Endpoints del API

| Operación | Método | Endpoint | Descripción |
|------------|---------|-----------|--------------|
| 🔹 Obtener todos los estudiantes | `GET` | `/api/estudiantes` | Devuelve la lista de todos los estudiantes. |
| 🔹 Obtener estudiante por ID | `GET` | `/api/estudiantes/{id}` | Devuelve un estudiante específico. |
| 🔹 Crear nuevo estudiante | `POST` | `/api/estudiantes` | Agrega un nuevo estudiante. |
| 🔹 Actualizar estudiante | `PUT` | `/api/estudiantes/{id}` | Actualiza los datos de un estudiante. |
| 🔹 Eliminar estudiante | `DELETE` | `/api/estudiantes/{id}` | Elimina un estudiante por ID. |

---

## 💻 Implementación del código

### 🧱 Modelo (`Estudiante.java`)
```java
package com.mafe.gestion_estudiantes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private double calificacion;

    public Estudiante() {}

    public Estudiante(String nombre, String apellido, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}
```

### 🧩 Repositorio (`EstudianteRepository.java`)
```java
package com.mafe.gestion_estudiantes.repository;

import com.mafe.gestion_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
```

### 🧠 Servicio (`EstudianteService.java`)
```java
package com.mafe.gestion_estudiantes.service;

import com.mafe.gestion_estudiantes.model.Estudiante;
import com.mafe.gestion_estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        return repository.findById(id).map(estudiante -> {
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setApellido(estudianteActualizado.getApellido());
            estudiante.setCalificacion(estudianteActualizado.getCalificacion());
            return repository.save(estudiante);
        }).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
```

### 🌐 Controlador (`EstudianteController.java`)
```java
package com.mafe.gestion_estudiantes.controller;

import com.mafe.gestion_estudiantes.model.Estudiante;
import com.mafe.gestion_estudiantes.service.EstudianteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Estudiante obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return service.guardar(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return service.actualizar(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
```

---

## 🧾 Ejemplos de uso (con JSON)

### ✅ Crear estudiante
**POST:** `/api/estudiantes`  
**Body:**
```json
{
  "nombre": "María",
  "apellido": "Gómez",
  "calificacion": 4.5
}
```

### 📖 Obtener todos
**GET:** `/api/estudiantes`

**Respuesta:**
```json
[
  {
    "id": 1,
    "nombre": "María",
    "apellido": "Gómez",
    "calificacion": 4.5
  },
  {
    "id": 2,
    "nombre": "Juan",
    "apellido": "Pérez",
    "calificacion": 3.8
  }
]
```

### ✏️ Actualizar
**PUT:** `/api/estudiantes/1`  
**Body:**
```json
{
  "nombre": "María Fernanda",
  "apellido": "Gómez Castro",
  "calificacion": 4.7
}
```

### ❌ Eliminar
**DELETE:** `/api/estudiantes/1`

---

## ✅ Buenas prácticas implementadas:
- Uso de **@Service**, **@Repository** y **@RestController**.  
- Validaciones simples y manejo de errores básico.  
- Separación clara por capas (**MVC**).  
- CORS habilitado para pruebas desde navegador.

---

## 👩‍💻 Autor
**María Fernanda Gómez Castro**  
📅 Octubre 2025  
📍 Proyecto académico - *Gestión de Estudiantes con Spring Boot*
