# farm

Gradle, Spring MVC e Hibernate

* Gradle
	- En el fichero build.gradle se referencian todas las dependencias del proyecto.

* Spring MVC
	- xxxxxxxxxxxxxxxxxx. 

* Hibernate
	- Basado en anotaciones JPA.
	- Existe un DAO genérico que al extender de él ya tendríamos las operaciones básicas. En caso de necesitar consultas específicas se añadirian en el DAO de la propia entidad.

* Lombok
	- Implementa mediante anotaciones de esta librería las funciones _accessors_ y los contructores, lo que ahorra líneas de código.

* Ejecución
	- java -Dspring.profiles.active=local -jar farm.jar
	- Servicio REST accesible en localhost:8080.




