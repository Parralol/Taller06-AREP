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

      mvn install

  Luego se ejecuta

      docker pull parralol/taller06_arep

      docker-compose up -d

  y obtendras la siguiente generacion de imagenes:

  ![image](https://github.com/Parralol/Taller06-AREP/assets/110953563/e0087cd2-d024-4598-8d9d-01dc50157671)

  

## Ejecucion Tests

    mvn test-compile
    
## Resumen del proyecto

  Se tiene un servidor cliente que distribuye las cargas por medio del round robin, un algoritmo de balanceo de cargas que usara 3 url's distintas, normalmente los querys entraran por http://localhost:8087 el cual nos recibira con la siguiente pagina.

  ![image](https://github.com/Parralol/Taller06-AREP/assets/110953563/23992d8b-22c8-4a77-a576-98de070ccba0)

  A la hora de escribir algo y presionar "submit" se enviara un query al estilo http://localhost:3500x/log?val= siendo x un numero del 1 al 3, y la comunicacion con docker se realiza por el puerto 6001, quedando el query como http://restx:6001/log?val= siendo x un numero cualquiera del 1 al 3, el query se procesa y se envia a la base de datos mongo para luego retornar los datos de la misma.
  
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

#### Respecto al despliegue

  se tuvo que instalar docker, git, maven y docker-compose
  
## Autor
  *  Santiago parra
