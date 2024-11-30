# Rabbit
Implementación y ajuste para realizar una aplicación para la gestión de PQR's con rabbit, con el modelo productor-suscriptor
Para poder ejecutar el proyecto se debe tener con anterioridad el rabbit corriendo en la maquina, en este caso se utilizo docker, los pasos son los siguientes:

- Descargar la imagen de RabbitMQ
  - `docker pull rabbitmq`

- Ejecutar la imagen creando un contenedor en el puerto 15672
  - `docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management`

- Probar conexión
  - Entrar al [http://localhost:15672/](http://localhost:15672/)

proyecto base(plantilla) https://github.com/vinnikam/rabbitMQ/tree/publisher-subscriber. Perteneciente al usuario: vinnikam
