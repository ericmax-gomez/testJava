1 -Descargar JDK 17 , lo hice con jdk 17 ya que si usaba una version anterior no era compatible con dependencias de springboot, por eso el JDK deberia ser 17 o superior
https://www.oracle.com/ar/java/technologies/downloads/
2 - Descargar IDE Netbeans 
https://netbeans.apache.org/front/main/download/
3 - Descargar spring boot netbeans plugin para que podamos crear el proyecto de spring boot en netbeans( la version actual necesita JDK 17 o superior)
https://plugins.netbeans.apache.org/catalogue/?id=4
4 - En caso de querer crear el proyecto con spring y poder ir a la siguiente página
https://start.spring.io/
5 - Descargar MySQL Community Server
https://dev.mysql.com/downloads/mysql/
6 - Instalar server de MySQL y MySQL Worbrench, en la instalación le pedirán usuario y contraseña, como usuario dejen root que viene por defecto y en contraseña ingresen admin(todo en minúscula).
Si cambian el usuario o contraseña deberán modificar en el proyecto en la ruta Other Sources/src/main/resources/defaultPackage/application.properties
en los campos:
spring.datasource.username
spring.datasource.password
ahí también encontrarán otras configiraciones que pueden modificar o agregar
7 - Descargar SQL conector en caso de que no le funcione o desean descargarlo nuevamente y descargar plataforma independiente
https://dev.mysql.com/downloads/connector/j/
8 - clonar o descargar el proyecto y correrlo
9 -dejo link para ver las imágenes de los test
https://drive.google.com/drive/folders/1LhtYcmqc7d1R3XAtIdIIzfYPIs5PqZ03?usp=sharing
10 - en la carpeta db se encuentra el script para la creación de la base de datos
