# rediscache
Redis Cache for Spring boot 3 with MariaDB

1. Clone the repository
2. Run docker Redis  `docker run -d -p 6379:6379 --name redis redis`
3. Run docker MariaDB `docker run -d -p 3306:3306 --name mariadb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=uly24401 mariadb`
4. Run the application

# Swagger UI
http://localhost:9092/demo/swagger-ui/index.html
http://localhost:9093/demo/swagger-ui/index.html

El objetivo de este proyecto es mostrar como se puede implementar una cache level 2 con Redis en Spring Boot 3.
Tecnologías utilizadas:
* Spring Boot 3
* MariaDB
* Redis
* Swagger
* Docker
* Hibernate
* Interceptor, para loggear las peticiones HTTP

# Arrancar 2 instancias de la aplicación
1. Arrancar la primera instancia de la aplicación con el puerto 9092
2. Arrancar la segunda instancia de la aplicación con el puerto 9093, application-9093.properties


# Test simple, get country by code
2024-09-25T09:22:28.860+02:00  INFO 43300 --- [redis] [nio-9093-exec-2] c.e.d.c.interceptor.RequestInterceptor   :
===========================================
requestURL: http://localhost:9093/demo/country/ES
remoteHost: 127.0.0.1
servletPath:/country/ES
method:     GET
status:     200
afterCompletion Execution Time: 398ms
===========================================

2024-09-25T09:22:33.970+02:00  INFO 43300 --- [redis] [nio-9093-exec-3] c.e.d.c.interceptor.RequestInterceptor   :
===========================================
requestURL: http://localhost:9093/demo/country/ES
remoteHost: 127.0.0.1
servletPath:/country/ES
method:     GET
status:     200
afterCompletion Execution Time: 2ms
===========================================
