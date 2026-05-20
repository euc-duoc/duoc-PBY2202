# Proyecto ejemplo Spring Security

Este proyecto avanza gradualmente en aspectos de seguridad de Backend, utilizando el módulo de Spring Security.

Trabaja con una BD MySQL que puede ser montada con docker (ver archivo [docker-compose.yml](/docker-compose.yml)).

## Proyecto base (commit "Repositorio base")

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

## Configuración de seguridad básica (commit E03)

A continuación, se puede incorporar seguridad básica en algún endpoint de la siguiente forma:

1. Generando una clase de configuración. Para este ejemplo, se construye la clase [ConfigSpringScurity](/src/main/java/duoc/inf/pby2202/ejemplo/config/ConfigSpringScurity.java). En la siguiente línea se habilita el acceso SOLO al endpoint GET http://localhost:8080/api/vehiculos/ :

```java
    .requestMatchers(HttpMethod.GET, "api/vehiculos").permitAll()
```
2. Configurando las credenciales para el acceso básico en [application.properties](/src/main/resources/application.properties), por ejemplo:

```properties
spring.security.user.name=user
spring.security.user.password=1234
```

Es posible probar con Postman que, al acceder a GET http://localhost:8080/api/vehiculos/ usando [Basic Auth](https://learning.postman.com/docs/sending-requests/authorization/authorization-types#basic-auth) y con las credenciales configuradas antes, el acceso se habilita. No así en POST http://localhost:8080/api/vehiculos/.