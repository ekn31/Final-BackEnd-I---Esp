# MicroServicios

DIGITAL HOUSE
Final de Especializacion Back End I 

Nombre: Elkin Fuentes Rodriguez
Email:  ekn31@hotmail.com

Parcial: Micro servicios de Movies

Entrega:  

        - Config server con configuracion centralizada en git hub.
        - Eureka server con registro de micro servicios de catalog,movie y serie.
        - Gateway para consumo de micro servicio catalog, movie y serie
        - Micro servicio catalog para consumo de api de movie y  puerto dinamico.
        - Micro servicio de movie con test "action"  y  puerto dinamico.
        - Coleccion postman para prueba de consumo.
		- Comunicacion sincronica desde el microservicio catalog hacia microservicio movies.
		- Comunicacion sincronica desde el microservicio catalog hacia microservicio series.
		- Implementacion del circuitbreaker en microservicio catalog hacia movies. Se implemeto un mensaje para identificar que el circuit breaker esta funcional.
        - Implementacion de comunicacion asincronica con rabbitMQ de los microservicio movies y series persistiendo en base de datos del microservicio catalog