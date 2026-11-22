# AdminConjunto-BDD

Pruebas funcionales automatizadas con BDD para **AdminConjunto**, un sistema web de administración de conjuntos residenciales desarrollado en Laravel.

Las pruebas se escriben en Gherkin y se automatizan con Cucumber, Serenity BDD y el patrón Screenplay. Simulan el uso real de la aplicación en un navegador Chrome.

Proyecto académico de la asignatura **Calidad de Software**, Universidad de Envigado.

## Tecnologías

- Java
- Gradle (Kotlin DSL)
- Cucumber 7.15.0 (Gherkin)
- Serenity BDD con patrón Screenplay
- Selenium 4.21.0 (Chrome)
- JUnit 4
- JaCoCo y SonarQube (análisis de calidad)
- Laravel y MySQL (aplicación bajo prueba)

## Procesos funcionales cubiertos

**Gestión de inmuebles (5 escenarios)**
- Registrar un inmueble
- Consultar los inmuebles registrados
- Buscar un inmueble por número de apartamento
- Validar que no se guarde un formulario vacío
- Asignar un propietario a un inmueble

**Gestión de usuarios (5 escenarios activos)**
- Crear un usuario propietario
- Crear un usuario arrendatario
- Crear un usuario administrador
- Rechazar un documento duplicado
- Verificar que un residente no accede al módulo de usuarios

**Gestión de pagos (3 escenarios activos)**
- Consultar cuotas pendientes
- Registrar un pago completo
- Consultar cuotas pagadas

Los escenarios marcados con `@pendiente` describen funcionalidades que aún no están implementadas en la aplicación. Se excluyen de la ejecución con `tags = "not @pendiente"`.

## Estructura del proyecto

```
src/
├── main/java/
│   ├── interaction/      Acciones reutilizables (por ejemplo, navegar a una pantalla)
│   ├── models/           Datos de prueba (DatosInmueble, DatosUsuario)
│   ├── question/         Consultas sobre el estado de la pantalla
│   ├── task/             Tareas de negocio (iniciar sesión, registrar inmueble, etc.)
│   └── userInterface/    Localizadores de los elementos de cada pantalla
└── test/
    ├── java/
    │   ├── runners/          Ejecutores de cada módulo
    │   └── stepsDefinitions/ Definición de los pasos de Gherkin
    └── resources/
        └── features/         Archivos .feature con los escenarios
```

## Requisitos

- JDK instalado (verifica con `java -version`)
- Google Chrome actualizado
- Aplicación AdminConjunto en ejecución (por ejemplo, con XAMPP o `php artisan serve`)
- MySQL con una base de datos de pruebas llamada `adminconjunto_bdd`

## Cómo ejecutar las pruebas

1. **Preparar la base de datos de pruebas.** En el proyecto Laravel, configura el `.env` para que apunte a `adminconjunto_bdd` y siembra los datos:

   ```
   php artisan migrate:fresh --seed --seeder=PruebasBddSeeder
   ```

   El seeder aborta si el nombre de la base de datos no contiene "bdd", para proteger los datos reales. Repite este paso antes de cada ejecución, porque los escenarios dependen de datos fijos.

2. **Levantar la aplicación** en la URL configurada en `serenity.conf`.

3. **Ejecutar las pruebas y generar el reporte:**

   ```
   .\gradlew clean test aggregate
   ```

4. **Abrir el reporte de Serenity:**

   ```
   target\site\serenity\index.html
   ```

## Cobertura y análisis de calidad

Generar el reporte de cobertura con JaCoCo:

```
.\gradlew jacocoTestReport
```

Enviar el análisis a SonarQube (el token se pasa como variable de entorno y nunca se guarda en el repositorio):

```
sonar-scanner
```

## Resultados

- Escenarios automatizados: 13
- Escenarios aprobados: _completar con el reporte de Serenity_
- Tiempo total de ejecución: _completar con el reporte de Serenity_
- Cobertura y Quality Gate: _completar con SonarQube_

## Buenas prácticas aplicadas

- Escenarios escritos en lenguaje de negocio, entendibles sin conocimientos técnicos.
- Patrón Screenplay: separación entre tareas, interacciones, preguntas e interfaz.
- Nombres de métodos en camelCase y localizadores en MAYÚSCULAS con prefijo (`INP_`, `BTN_`, `LBL_`, `SEL_`).
- Base de datos de pruebas aislada de la de desarrollo.
- Esperas explícitas en lugar de pausas fijas.

## Seguridad

Este repositorio no contiene archivos `.env`, tokens ni contraseñas reales. Las credenciales de los usuarios de prueba pertenecen únicamente a la base de datos `adminconjunto_bdd`.

## Autoras

- Natalia Vélez Gutiérrez
- Laura Vásquez Jiménez

Docente: Martha Ligia Murillo Díaz
