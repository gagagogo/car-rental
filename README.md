# car-rental

![app-diagram](https://raw.githubusercontent.com/gagagogo/car-rental/master/docs/img/app-diagram.png "Application component diagramm")

Приложение car-rental преднозначено для развертывания на docker swarm кластере. Состоит из следующих компонент:
1. Nginx - реверс прокси. Принимает входящие от клиентов запросы и транслирует их на приложения внутири docker кластера. Маршрутизация выполняется на основе пути входящего http запроса. Конфигурация сервера генерируется на основе шаблона nginx/nginx.tmpl при добавлении очередного контейнера в кластер. Для этого используется Docker Engine API обвёрнутое в проект jwilder/docker-gen. В конфигурациию попадают контейнеры, в переменных окружения которых, заданы переменные VIRTUAL_HOST и VIRTUAL_HOST_LOCATION. VIRTUAL_HOST задаёт логическую группу хостов, а VIRTUAL_HOST_LOCATION регулярное выражение для http запроса соответствующее группе хостов.
2. car-rental-web-ui - spring boot + Angular JS приложение. Интерфейс администратора системы аренды авто. Использует redis для хранения сессий. Mysql, как хранилище. Хронология изменения сущностей реализована через компонент envers hibernate.
3. car-rental-tracking компонент предназначеный для сохраниения маршрута движения авто. Принимает через rest api точку и записывает её в БД. Так как ожидается, что этот компонент будет самым высоко нагруженом, для обработки http запросов  применяется фреймворк spring web flux, который обрабатывает запросы в неблокирующем режиме. Полученый запрос (с координатами точки) rest api направляет в точку обмена брокеру сообщений rabbitmq. Брокер сообщений направляет сообщение в очередь, на которую пока, что подписана единственная группа подписчиков записывающая точки в БД. Такая реализация записи точек выбрана для того, что бы http запрос не ожидал записи в базу, которая может быть долгой, в добавок это позволяет добавлять группы подписчиков для дополнительной обработки поступающих данных (например ведения какой либо статистики).
4. db - база данных MySQL. Содержит 2 базы. car_rental - хранилище данных клиентского приложения и car_rental_tracking. Таблица car_rental_tracking.VEHICLE_TRACK_POINT содержит поле CREATION_DATE. По нему предполагается сделать фрагментирование таблицы.
5. redis - используется для хранение сессий car-rental-web-ui.
6. rabbitmq
7. ci - jenkins. CI сервер клонирует данные из SCM git, проводит сборку, в случае успеха, упаковывает сборку в docker контейнер и обновляет сервис в docker swarm кластере.

Для развёртывания и запуска приложения на docker swarm кластере запустите ./run.sh
Интерфейс администратора системы аренды авто доступен по адресу 127.0.0.0 на 80-м порту.
По адресу 127.0.0.0/tracker/index.html находится страничка симулирующая работу трекера. Используя HTML5 Geolocation API раз в 10 сек шлёт текущие координаты на запись в car-rental-tracking.
