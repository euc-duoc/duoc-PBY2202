# Proyecto ejemplo Spring Security

Este proyecto avanza gradualmente en aspectos de seguridad de Backend, utilizando el módulo de Spring Security.

Trabaja con una BD MySQL que puede ser montada con docker (ver archivo [docker-compose.yml](/docker-compose.yml)).

## Proyecto base (commit inicial)

Disponible en el primer commit del repositorio (8300e0c3). Contiene un proyecto sin incorporar seguridad, pero con el plugin comentado en el [pom.xml](/pom.xml).

Define dos endpoints simples:
* GET http://localhost:8080/api/vehiculos/ - Obtener todos los vehículos.
* POST http://localhost:8080/api/vehiculos/ - Guardar un nuevo vehículo.

Es posible observar que, en este punto del proyecto, los endpoints están abiertos y se puede acceder sin ningún tipo de control.

## Incorporación de seguridad básica (commit E02)

Al incorporar el plugin de Security en el [pom.xml](/pom.xml), automáticamente se vuelven inaccesibles todos los endpoints, para eso, se debe agregar:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```