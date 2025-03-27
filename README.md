AGSR тестовое

Запуск:
1)mvn clean package
2)docker compose up --build

В тестовой 2 in memory юзера
Перед проверкой стандартных endpoint'ов авторизовать их по /api/login
1)
Role: Administrator
login:admin
password:admin
2)
Role: Viewer
login:user
password:user

По базе:
Всего 3 простейших скрипта(юзал flyway)
