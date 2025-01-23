## RMJ - Basic Ecommerce Hexagonal  

Este proyecto sigue una arquitectura hexagonal para un sistema básico de ecommerce. A continuación se describe la estructura del proyecto:

## **Application** (Capa de Aplicación)

Contiene la lógica de la aplicación y la implementación de los casos de uso.

port/in/: Puertos de entrada (casos de uso)
port/out/: Puertos de salida (interfaces para persistencia)
service/: Implementaciones de los casos de uso

## **Domain** (Capa de Dominio)

Aquí reside el núcleo del negocio, con los modelos y reglas de negocio.

- **Modelos de dominio**: Representaciones de las entidades del negocio.
- **Excepciones de dominio**: Excepciones específicas del dominio.
- **Lógica de negocio pura**: Reglas y operaciones centrales del negocio.

## **Infra** (Capa de Infraestructura)

Implementaciones concretas de las interfaces definidas en la capa de aplicación.

### **Persistence** (Persistencia)

- **entity/**: Entidades JPA
- **mapper/**: Conversores entidad-dominio
- **repo/**: Repositorios Spring Data JPA


### **Web** (API REST)

- **dto**: Objetos de transferencia de datos
- **mapper**: Conversores dominio-dto

## **Resources**

- Configuración de la aplicación 
- Scripts SQL para inicialización de la base de datos.


## **Test**

Pruebas para garantizar la calidad del código.

- **Tests unitarios**: Pruebas de unidades individuales de código.
- **Tests de integración**: Pruebas que verifican la integración entre componentes.

<p style="margin-bottom: 2em;"></p> <!-- Espacio adicional -->

# Ejecución de una Aplicación Spring Boot y sus Tests

A continuación se describen los pasos para ejecutar una aplicación Spring Boot y sus tests.


## **Ejecutar la Aplicación Spring Boot**

Para ejecutar la aplicación Spring Boot, sigue estos pasos:

1. **Asegúrate de tener Maven instalado**:
   - Verifica que Maven esté instalado ejecutando en la terminal:
     ```bash
     mvn -v
     ```
   - Si no lo tienes, instálalo siguiendo la [guía oficial de Maven](https://maven.apache.org/install.html).

2. **Navega al directorio del proyecto**:
   - Abre una terminal y dirígete a la carpeta raíz del proyecto (donde se encuentra el archivo `pom.xml`).

3. **Compila y ejecuta la aplicación**:
   - Ejecuta el siguiente comando para compilar y arrancar la aplicación:
     ```bash
     mvn spring-boot:run
     ```
   - Esto iniciará la aplicación y podrás acceder a ella en `http://localhost:8080` (o en el puerto configurado en `application.properties`).

4. **Otra opción: Ejecutar desde un IDE**:
   - Si estás usando un IDE como IntelliJ IDEA o Eclipse, puedes ejecutar la aplicación directamente desde la clase principal (anotada con `@SpringBootApplication`).

---

## **Ejecutar los Tests**

Para ejecutar los tests de la aplicación, sigue estos pasos:

1. **Ejecutar todos los tests**:
   - En la terminal, ejecuta el siguiente comando:
     ```bash
     mvn test
     ```
   - Esto ejecutará todos los tests unitarios y de integración definidos en el proyecto.

2. **Ejecutar tests específicos**:
   - Si deseas ejecutar un test específico, puedes usar el siguiente comando:
     ```bash
     mvn -Dtest=NombreDeLaClaseDeTest test
     ```
   - Por ejemplo:
     ```bash
     mvn -Dtest=UserServiceTest test
     ```

3. **Ejecutar tests desde un IDE**:
   - En IntelliJ IDEA o Eclipse, puedes ejecutar los tests directamente desde la vista de tests del IDE. Simplemente haz clic derecho sobre la clase de test y selecciona "Run".

---

## **Comandos útiles adicionales**

- **Limpiar y compilar el proyecto**:
  ```bash
  mvn clean install