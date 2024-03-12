# Taller06-AREP
## Prerequisitos

  Para poder usar este proyecto se requiere lo siguiente:

  * Maven: Gestiona el ciclo de vida del software
  * Git: Sistema de control de versiones del software
  * Docker: Permite el despliegue del software dentro de contendores virtuales.
  * Java: Lenguaje en el cual esta escrito el programa

No hace falta aclarar que tambien se uso AWS para el despliegue del programa.

## Intalacion:

  Para la instalacion clonamos el repositorio

      Git clone

  Despues (dentro de la carpeta clonada) construimos el proyecto

      mvn package

## Ejecucion programa

  Ejecutamos los siguientes comandos

      mvn clean package install
      
  Seguido de

      mvn clean install

## Ejecucion Tests

    mvn test-compile

## Arquitectura del programa

  Esta basado en 3 capas principales, el grupo de seguridad, la capa de AWS-EC2, el contenedor docker, que estara ejecutando el programa y el programa que se basa en el servidor cliente, el servidor REST que estara conectado a una db Mongo

![image](https://github.com/Parralol/Taller06-AREP/assets/110953563/0cf1b942-ab6d-4d01-a438-9a916596aa8d)

Posee un servidor el cual ejecutara el RoundRobin para distribuir las cargas en 3 servidores web, de los cuales uno y cada uno se comunicara hacia la db de mongo.


## Funcionamiento

![image](https://github.com/Parralol/Taller06-AREP/assets/110953563/e22cf783-3f3f-4f04-a794-570a0fb7bb21)



https://github.com/Parralol/Taller06-AREP/assets/110953563/51c9f290-c654-488e-9b78-0ac864e53db4



### Construido con

  * Maven
  * Git
  * Java
  * Html
  * JavaScript
  * Docker

### Desplegado en 

  * AWS
