# 🧩 Punto 3: Configuración de Integración Básica

## ⚙️ Preparación del entorno
Se configuró un entorno de desarrollo basado en **Java y Spring Boot**, con gestión de dependencias a través de **Maven**.  
El proyecto se encuentra alojado en un repositorio de **GitHub**, lo que permite control de versiones, colaboración y despliegue continuo.

**Repositorio:**  
🔗 *[https://github.com/tu_usuario/gestion-estudiantes](https://github.com/tu_usuario/gestion-estudiantes)*  
*(sustituye con tu enlace real)*

---

## 🗂️ Estructura del repositorio
El proyecto sigue una estructura organizada conforme a las buenas prácticas de desarrollo:

```
gestion-estudiantes/
├── src/                    # Código fuente del proyecto (controladores, modelos, vistas)
│   ├── main/java/...       
│   └── test/java/...       # Pruebas unitarias
├── scripts/                # Scripts de instalación y pruebas automáticas
│   ├── install.sh
│   └── test.sh
├── pom.xml                 # Archivo de dependencias Maven
├── README.md               # Documentación principal
└── Punto2_ServiciosWeb.md  # Documentación de endpoints REST
```

---

## 🧠 Convenciones aplicadas
- Se utilizó la convención de nombres **camelCase** para clases, variables y métodos.  
- Los commits en Git siguen la estructura:
  ```
  tipo: descripción breve
  ```
  Ejemplo:
  ```
  feat: agregar endpoint para registrar estudiantes
  fix: corregir validación de notas negativas
  ```

---

## 🧰 Scripts de instalación y pruebas
Para estandarizar la ejecución en distintos entornos, se crearon scripts en la carpeta `/scripts`:

**`install.sh`**
```bash
#!/bin/bash
echo "Instalando dependencias..."
mvn clean install
```

**`test.sh`**
```bash
#!/bin/bash
echo "Ejecutando pruebas..."
mvn test
```

---

## ✅ Resultado
- El repositorio está correctamente versionado y estructurado.  
- Se agregaron scripts automáticos para instalación y pruebas.  
- El entorno está listo para la configuración de **Integración Continua (CI)** en GitHub Actions.
