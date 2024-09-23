# rediscache
Redis Cache for Spring boot 3 with MariaDB

1. Clone the repository
2. Run docker Redis  `docker run -d -p 6379:6379 --name redis redis`
3. Run docker MariaDB `docker run -d -p 3306:3306 --name mariadb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=uly24401 mariadb`
4. Run the application

# Swagger UI
http://localhost:9092/demo/swagger-ui/index.html