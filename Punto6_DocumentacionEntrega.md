# 📘 Punto 6: Documentación y Entrega

## 🎯 Objetivo

Reunir toda la documentación técnica y de usuario del sistema **Gestión de Estudiantes**, incluyendo guías de uso, despliegue, diagramas de arquitectura y flujo de integración continua (CI).

---

## 🧭 Guía de Usuario

### 💻 Ejecución del sistema

1. Abre el proyecto en **IntelliJ IDEA** o desde la terminal.
2. Compila el código con Maven:

   ```bash
   mvn clean package
   ```
3. Ejecuta la aplicación:

   ```bash
   java -jar target/gestion-estudiantes.jar
   ```
4. Abre tu navegador en la dirección:

   ```
   http://localhost:8080/
   ```

### 🧩 Funcionalidades principales

| Funcionalidad            | Descripción                                                 |
| ------------------------ | ----------------------------------------------------------- |
| **Registrar estudiante** | Permite agregar un nuevo estudiante con sus calificaciones. |
| **Listar estudiantes**   | Muestra todos los registros almacenados.                    |
| **Actualizar datos**     | Modifica calificaciones o información de un estudiante.     |
| **Eliminar estudiante**  | Elimina un registro del sistema.                            |

---

## ☁️ Guía de Despliegue

### 🚀 Despliegue local

1. Asegúrate de tener **Java 17** y **Maven** instalados.
2. Ejecuta:

   ```bash
   mvn clean install
   java -jar target/gestion-estudiantes.jar
   ```
3. Accede desde tu navegador a `http://localhost:8080/`.

### 🌐 Despliegue remoto

Para un servidor remoto (como un VPS o nube educativa):

1. Sube el archivo `.jar` al servidor:

   ```bash
   scp target/gestion-estudiantes.jar usuario@servidor:/ruta/app/
   ```
2. Inicia el servicio:

   ```bash
   java -jar /ruta/app/gestion-estudiantes.jar &
   ```

---

## 🧩 Diagrama de Arquitectura (MVC)

```
┌────────────────────┐
│      Usuario       │
└───────┬────────────┘
        │ Peticiones HTTP
        ▼
┌────────────────────┐
│   Controlador      │  ← Maneja endpoints (Registrar, Listar, etc.)
└───────┬────────────┘
        │
        ▼
┌────────────────────┐
│      Modelo        │  ← Lógica y validación (Estudiante, Servicio)
└───────┬────────────┘
        │
        ▼
┌────────────────────┐
│       Vista        │  ← Interfaz HTML (index.html)
└────────────────────┘
```

---

## 🔄 Diagrama del flujo de CI (Integración Continua)

```
[ Commit o Pull Request ]
              │
              ▼
  ┌─────────────────────────────┐
  │ GitHub Actions: CI Pipeline │
  └─────────────────────────────┘
              │
      ┌───────┼────────┐
      ▼                ▼
 Compilación ✅    Pruebas JUnit ✅
      │                │
      └───────┬────────┘
              ▼
     Reporte de estado (verde o rojo)
```

---

## 📦 Entregables finales

| Tipo                      | Archivo                                                                                                                              |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| **Código fuente**         | `/src/main/java`                                                                                                                     |
| **Pruebas unitarias**     | `/src/test/java`                                                                                                                     |
| **Documentación técnica** | `README.md`, `Punto2_ServiciosWeb.md`, `Punto3_IntegracionBasica.md`, `Punto4_IntegracionContinua.md`, `Punto5_PruebasValidacion.md` |
| **Documentación final**   | `Punto6_DocumentacionEntrega.md`                                                                                                     |
| **Scripts**               | `/scripts/install.sh`, `/scripts/test.sh`                                                                                            |

---

## ✅ Resultado final

El sistema **Gestión de Estudiantes** está completamente implementado, probado, automatizado y documentado.
Cumple con todos los requisitos del proyecto: arquitectura modular (MVC), CI/CD en GitHub Actions, validaciones, y documentación integral.
