# Taller Aplicacion Segura ! David Leon
## Objetivos
- Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
- Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
- Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.
![image](https://user-images.githubusercontent.com/98216838/227750433-5337bf4d-24eb-4a36-b1ac-bb03db602e78.png)
## Herramientas a utilizar
 - Maven
 - Java 
 - Git 
 - Spark
 - AWS
 - KeyTool
 
## Desarrollo
- Creamos los dos servidores seguros de spark
 
![image](https://user-images.githubusercontent.com/98216838/227748285-14c09c76-3b44-40f1-8c1c-56947cc196aa.png)
- Creamos el par de llaves para cada uno: 
  - keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650 
  
![image](https://user-images.githubusercontent.com/98216838/227748291-9e3e2186-69ce-4f36-904c-2bbd50d773f6.png)
## Pruebas Locales
![image](https://user-images.githubusercontent.com/98216838/227748455-a201809f-5506-4291-a97a-4788148519df.png)
![image](https://user-images.githubusercontent.com/98216838/227748463-a7bc361f-16ba-4b9c-901b-2d27d645b432.png)
## AWS
- Creamos las dos instancias que utilizaremos 
![image](https://user-images.githubusercontent.com/98216838/227748773-be7bb5e0-21e0-4bd8-af62-1f2fad3b12b9.png)
- Configuramos los grupos de seguridad para cada una de las instancias
![image](https://user-images.githubusercontent.com/98216838/227749005-efd92923-321b-4e0c-8053-12a05da37427.png)
- Instalamos java en cada una de estas
![image](https://user-images.githubusercontent.com/98216838/227749141-1368123f-afef-467b-89e3-6e1e3e8ca344.png)
- Clonamos y ejecutamos en cada instancia
![image](https://user-images.githubusercontent.com/98216838/227749289-ded4525e-fb8b-474d-9026-892f61b96c11.png)
![image](https://user-images.githubusercontent.com/98216838/227749562-420a1933-524b-4e1d-8ed5-a87340dc5b71.png)
- Realizamos las pruebas
![image](https://user-images.githubusercontent.com/98216838/227750404-10c27068-9bc8-47bd-aab8-cf04a6998bd1.png)
![image](https://user-images.githubusercontent.com/98216838/227750412-d7d79430-535b-4e62-abff-c586b4a9d547.png)
## Video
- https://youtu.be/_xBrFIwAshw

## Documentacion

Para crear la documentación del proyecto se hace con el siguiente comando:
    
    mvn javadoc:javadoc
    

## Autor

* **David Leon**
