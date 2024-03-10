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

### Construido con

  * Maven
  * Git
  * Java
  * Html
  * JavaScript
  * Docker

### Desplegado en 

  * AWS
