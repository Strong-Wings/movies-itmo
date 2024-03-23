Крыжанков Степан Сергеевич

Сервис создания и получения фильмов и директоров

Эндпоинты для фильмов:

- GET /api/movies
 
- Получение всех фильмов
  ![img.png](img/img.png)

- GET /api/movies/{id}
  
  Получение фильма по id
  ![img_1.png](img/img_1.png)

- POST /api/movies
  
  Создание фильма
  ![img_2.png](img/img_2.png)

- PATCH /api/movies/{id}

  Обновление фильма
  ![img_3.png](img/img_3.png)

- DELETE /api/movies/{id}

  Удаление фильма
  ![img_4.png](img/img_4.png)


Аналогичные эндпоинты для директоров:
- GET /api/director
- GET /api/director/{id}
- POST /api/director
- PATCH /api/director/{id}
- DELETE /api/director/{id}


Обработка ошибок и хэндлинг исключений:
- Пример 400
![img_5.png](img/img_5.png)
Причем все ошибки конкатенируются и видны все неправильно заполненные поля
- Пример 404
![img_6.png](img/img_6.png)


Конфигурация в файле пропертей:
- Порт приложения

  server.port=8080
- БД

  spring.datasource.url=jdbc:postgresql://localhost:5432/movies
  spring.datasource.username=postgres
  spring.datasource.password=postgres

Тесты на весь функционал:
- com/itmo/movies/controller/DirectorControllerTest.java
- com/itmo/movies/controller/MovieControllerTest.java

![tests.png](img/tests.png)