
<h1 align="center">Forohub Challenger</h1>

## Descripcion

El proyecto consiste en una API rest desarrollada en Spring Boot donde los usuarios 
pueden plantear sus inquietudes por medio de topicos que otros usuarios pueden responder.
La aplicacion fue pensada como un foro interactivo, donde interactúan tanto alumnos como maestros respondiendo
sus dudas de distintos cursos atravez de topicos.

## Tecnologias


## Funcionalidades 
La api tiene varias funcionalidades para varios endpoints
permitiendo hacer un CRUD para cada una de las rutas.

### Rutas
**Cosas a tener en cuenta de cada ruta**
- cada ruta se ejecuta en el localmente por predeterminadamente `http://localhost:8080/ruta`
- Utiliza el puerto 8080
- La gran mayoria de las URI están bloqueadas porque requieren autenticacion

#### Users
El endpoint `"\users"` permite
- Registrar un nuevo usuario `userName`,`password` y `email` son obligatorios
- Actualizar un usuario existente require de un id
- Eliminar un usuario elimina un usuario existente mediante el id como parametro `{id}`
- Obtener un usuario por su id 

### Topics 
El endpoint `"\topics"` permite
- Crea un nuevo topico necesita un en el cuerpo del json como obligatorio`title`,`message`,`course`,`user`.
- Modificar un topico requiere {id} como parametro en la URI 
- Elimina un topico requiere del {id} del topico como parametro en la URI
- Obtiene un topico requiero un {id} como parametro en la URI
- Obtiene todos topicos.

### Seguridad
Casi todos los endpoint requieren Autenticacion exceptuando:

 **Endpoint de autenticacion** `"/login"` que permite a los usuarios **registrados** autenticarse requiere `user` y `password` en el cuerpo de la solicitud esto devuelve un token que debe ser incluido en el header de la request
 **Endpoint de registro de usuarios** `"/users"` que nos permite registrar usuarios nuevos.

    

    



