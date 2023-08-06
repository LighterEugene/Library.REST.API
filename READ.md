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

Описание предметной области и композиции:

Приложение связано с библиотечной системой, где есть книги и библиотеки. Каждая книга имеет свои характеристики, такие как id, title, author, publicationYear, genre, и isbn. Книги также связаны с библиотеками через отношение многие-к-одному, где одна библиотека может содержать множество книг.

Каждая библиотека имеет свои характеристики, такие как id, name, address, workingHours, staffCount, и foundationYear.

Описание функциональности:

GET /books: Получение списка всех книг в библиотеке.

GET /books/{id}: Получение информации о книге по её id.

POST /books: Добавление новой книги в библиотеку.

PUT /books/{id}: Обновление информации о книге.

PATCH /books/{id}: Частичное обновление информации о книге.

DELETE /books/{id}: Удаление книги.

GET /libraries: Получение списка всех библиотек.

GET /libraries/{id}: Получение информации о библиотеке по её id.

POST /libraries: Добавление новой библиотеки.

PUT /libraries/{id}: Обновление информации о библиотеке.

PATCH /libraries/{id}: Частичное обновление информации о библиотеке.

DELETE /libraries/{id}: Удаление библиотеки.

Описание интерфейса API:

GET /books: Получение списка всех книг.

GET /books/{id}: Получение информации о книге по id.

POST /books: Добавление новой книги (требуется JSON с полями libraryId, title, author, publicationYear, genre, isbn).

PUT /books/{id}: Обновление информации о книге по id (требуется JSON с аналогичными полями).

PATCH /books/{id}: Частичное обновление информации о книге по id (требуется JSON с полями для обновления).

DELETE /books/{id}: Удаление книги по id.

GET /libraries: Получение списка всех библиотек.

GET /libraries/{id}: Получение информации о библиотеке по id.

POST /libraries: Добавление новой библиотеки (требуется JSON с полями name, address, workingHours, staffCount, foundationYear).

PUT /libraries/{id}: Обновление информации о библиотеке по id (требуется JSON с аналогичными полями).

PATCH /libraries/{id}: Частичное обновление информации о библиотеке по id (требуется JSON с полями для обновления).

DELETE /libraries/{id}: Удаление библиотеки по id.

Ожидаемые результаты операций:

GET /books: Список всех книг в формате JSON.

GET /books/{id}: Информация о книге в формате JSON или статус 404 Not Found.

POST /books: Созданная книга в формате JSON или статус 404 Not Found (если библиотека не найдена).

PUT /books/{id}: Обновленная информация о книге в формате JSON или статус 404 Not Found.

PATCH /books/{id}: Обновленная информация о книге в формате JSON или статус 404 Not Found.

DELETE /books/{id}: Статус 204 No Content (успешное удаление) или статус 404 Not Found.

GET /libraries: Список всех библиотек в формате JSON.

GET /libraries/{id}: Информация о библиотеке в формате JSON или статус 404 Not Found.

POST /libraries: Созданная библиотека в формате JSON.

PUT /libraries/{id}: Обновленная информация о библиотеке в формате JSON или статус 404 Not Found.

PATCH /libraries/{id}: Обновленная информация о библиотеке в формате JSON или статус 404 Not Found.

DELETE /libraries/{id}: Статус 204 No Content (успешное удаление).