
<h1 align="center">Forohub Challenger</h1>

## 📃 Descripcion

El proyecto consiste en una API rest desarrollada en Spring Boot donde los usuarios 
pueden plantear sus inquietudes por medio de topicos que otros usuarios pueden responder.
La aplicacion fue pensada como un foro interactivo, donde interactúan tanto alumnos como maestros respondiendo
sus dudas de distintos cursos atravez de topicos.

## 🔧 Tecnologias

![Static Badge](https://img.shields.io/badge/Java-17.0.9-orange?style=for-the-badge&link=https%3A%2F%2Fwww.oracle.com%2Fjava%2Ftechnologies%2Fjavase%2Fjdk17-archive-downloads.html)
![Static Badge](https://img.shields.io/badge/Spring-%236DB33F?style=for-the-badge&logo=spring&logoColor=white&labelColor=%236DB33F&link=https%3A%2F%2Fspring.io%2F)
![Static Badge](https://img.shields.io/badge/Spring%20Securiy-6.3.1-black?style=for-the-badge&logo=springsecurity&logoColor=white&labelColor=black&link=https%3A%2F%2Fspring.io%2Fprojects%2Fspring-security)
![Static Badge](https://img.shields.io/badge/Spring_Boot-3.3.1-%236DB33F?style=for-the-badge&logo=springboot&logoColor=white&labelColor=%236DB33F&color=gray&link=https%3A%2F%2Fspring.io%2Fprojects%2Fspring-boot)
![Static Badge](https://img.shields.io/badge/Flyway-10.10.0-%23CC0200?style=for-the-badge&logo=flyway&logoColor=white&labelColor=%23CC0200&color=gray&link=https%3A%2F%2Fflywaydb.org%2F)
![Static Badge](https://img.shields.io/badge/Mysql-white?style=for-the-badge&logo=mysql&labelColor=white&color=blue)
![Static Badge](https://img.shields.io/badge/lombok-1.18.32-gray?style=for-the-badge&labelColor=blue&color=gray)
![Static Badge](https://img.shields.io/badge/Status-Completed-gray?style=for-the-badge&color=purple)
![Static Badge](https://img.shields.io/badge/Realase_Date-July-gray?style=for-the-badge&labelColor=black&color=yellow)

## Insignia del desafió

![Badge-Spring.png](Badge-Spring.png)

## 🔨 Funcionalidades 
La api tiene varias funcionalidades para varios endpoints
permitiendo hacer un **CRUD** para cada una de las rutas.

### Rutas
**Cosas a tener en cuenta de cada ruta**
- cada ruta se ejecuta en el localmente por predeterminadamente `http://localhost:8080/ruta`
- Utiliza el puerto 8080
- La gran mayoria de las URI están bloqueadas porque requieren autenticacion

#### 👨‍💻 Users
El endpoint `"\users"` permite
- Registrar un nuevo usuario `userName`,`password` y `email` son obligatorios
- Actualizar un usuario existente require de un {id} como parametro en la URI
- Eliminar un usuario elimina un usuario existente mediante el id como parametro `{id}`
- Obtener un usuario por su id 

#### 💬 Topics 
El endpoint `"\topics"` permite
- Crea un nuevo topico necesita un en el cuerpo del json como obligatorio`title`,`message`,`course`,`user`.
- Modificar un topico requiere {id} como parametro en la URI 
- Elimina un topico requiere del {id} del topico como parametro en la URI
- Obtiene un topico requiero un {id} como parametro en la URI
- Mostrar todos los Topicos

### 🔒 Seguridad
Para la seguridad se utiliza JWT y como provedor de Authentication se usa la por defecto DAP
Casi todos los endpoint requieren Autenticacion exceptuando:

 **Endpoint de autenticacion** `"/login"` que permite a los usuarios **registrados** autenticarse requiere `user` y `password` en el cuerpo de la solicitud esto devuelve un token que debe ser incluido en el header de la request para acceder a los recursos protegidos.

 **Endpoint de registro de usuarios** `"/users"` que nos permite registrar usuarios nuevos.

## 💽 Demo

## Despliege

## Redes



    

    



