markdown

# Система управления библиотекой

Это простая система управления библиотекой, созданная с использованием Spring Boot.

## Начало работы

Эти инструкции помогут настроить и запустить проект на вашем локальном компьютере.

### Предварительные требования

- Java 17
- MySQL 8
- Git

### Установка

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/LighterEugene/Library.REST.API.git
1. Перейдите в директорию проекта:

bash

cd library-management


2. Создайте базу данных MySQL с именем library_db.

3. Обновите файл src/main/resources/application.properties с вашими учетными данными MySQL:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=your-username
spring.datasource.password=your-password

4. Соберите и запустите приложение:

bash

./gradlew bootRun
Приложение должно быть доступно по адресу http://localhost:8080.

Зависимости
Spring Boot
Spring Data JPA
Spring Web
MySQL Connector Java
Использование
Документация API: Swagger UI
HAL Explorer: HAL Explorer




Не забудьте заменить `yourusername`, `your-username` и `your-password` на свои 