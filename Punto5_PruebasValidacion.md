## 🧩 Punto 5: Pruebas y Validación

### 🧪 Objetivo

Verificar que las funcionalidades del sistema de gestión de estudiantes operen correctamente mediante pruebas unitarias e integradas, asegurando la calidad del software antes del despliegue.

---

### 🧠 Herramienta utilizada

Se utilizó **JUnit 5**, el framework estándar para pruebas en Java.
Se agregaron las dependencias correspondientes en el archivo `pom.xml` (si no las tienes, puedes añadir esto):

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
```

---

### 🧩 Ejemplo de prueba unitaria

Archivo: `src/test/java/EstudianteTest.java`

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EstudianteTest {

    @Test
    public void testCalcularPromedio() {
        Estudiante e = new Estudiante("Mafe", 4.5, 3.5, 5.0);
        double promedioEsperado = (4.5 + 3.5 + 5.0) / 3;
        Assertions.assertEquals(promedioEsperado, e.calcularPromedio());
    }

    @Test
    public void testNombreNoVacio() {
        Estudiante e = new Estudiante("Mafe", 4.5, 3.5, 5.0);
        Assertions.assertNotNull(e.getNombre());
        Assertions.assertFalse(e.getNombre().isEmpty());
    }
}
```

---

### 🔍 Ejemplo de prueba de integración

Archivo: `src/test/java/ServicioEstudianteTest.java`

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioEstudianteTest {

    @Test
    public void testRegistrarYObtenerEstudiante() {
        ServicioEstudiante servicio = new ServicioEstudiante();
        Estudiante nuevo = new Estudiante("Juan", 4.0, 3.8, 4.5);

        servicio.registrarEstudiante(nuevo);
        Estudiante obtenido = servicio.buscarPorNombre("Juan");

        Assertions.assertNotNull(obtenido);
        Assertions.assertEquals("Juan", obtenido.getNombre());
    }
}
```

---

### 🧾 Ejecución automática de pruebas

En el **pipeline de CI (GitHub Actions)** configurado previamente, las pruebas se ejecutan automáticamente con el comando:

```bash
mvn test
```

Cada vez que haces un *commit* o *push* al repositorio.

---

### ✅ Resultado esperado

* Todas las pruebas deben ejecutarse sin errores.
* GitHub mostrará los resultados en la pestaña **Actions**.
* En caso de fallar alguna prueba, el pipeline se marca en rojo y no continúa la integración.
