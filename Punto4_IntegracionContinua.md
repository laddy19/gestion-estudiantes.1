# ⚙️ Punto 4: Implementar Integración Continua (CI)

## 🚀 Objetivo

Configurar un flujo automatizado de **Integración Continua (CI)** que:

* Ejecute las pruebas del proyecto automáticamente con **cada commit o push** al repositorio.
* Analice la calidad del código.
* Prepare el entorno para despliegues futuros.

---

## 🧩 Herramienta utilizada

Se implementó la CI utilizando **GitHub Actions**, que permite automatizar tareas directamente desde el repositorio sin configuraciones externas.

---

## 🏗️ Configuración del pipeline

Dentro del repositorio, se creó la carpeta:

```
.github/workflows/
```

Y dentro de ella, el archivo:

```
ci.yml
```

### Contenido del archivo `ci.yml`:

```yaml
name: CI - Gestión de Estudiantes

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: 📥 Checkout del código
      uses: actions/checkout@v4

    - name: ☕ Configurar JDK 17
      uses: actions/setup-java@v4
      with:
        distribution: 'temurin'
        java-version: '17'

    - name: ⚙️ Instalar dependencias y compilar
      run: mvn clean install -DskipTests

    - name: 🧪 Ejecutar pruebas
      run: mvn test
```

---

## 🧠 Explicación del pipeline

| Etapa          | Descripción                                                                       |
| -------------- | --------------------------------------------------------------------------------- |
| **Checkout**   | Descarga el código del repositorio para que el workflow lo use.                   |
| **Setup Java** | Configura el entorno con Java 17 usando Temurin (versión estable).                |
| **Build**      | Compila el proyecto con Maven y verifica dependencias.                            |
| **Test**       | Ejecuta automáticamente las pruebas unitarias y muestra los resultados en GitHub. |

---

## 🧾 Ejecución automática

Cada vez que se realiza un **push** o una **pull request** hacia la rama principal (`main`), GitHub ejecuta automáticamente este pipeline y muestra los resultados en la pestaña **Actions** del repositorio.

---

## ✅ Resultado

* Se logró una integración continua funcional.
* El pipeline verifica la calidad del código antes de integrar cambios.
* El flujo es totalmente automático y no requiere intervención manual.