<h2><b> Weather service </b></h2>

<h3> Task: </h3>

Write a REST service with a single endpoint /weather.

When called, this service must query a database for today's weather (temperature) in the table "weather_history". If no record is found in the database for the current date, then it must read the current temperature value from page "yandex.ru". After reading temperature, it must insert a new record in "weather_history". In the end, it must return the temperature value back to the user.

<h3> Used technologies: </h3>
<ul>
<li> Spring Boot </li>
<li> Hibernate </li>
<li> PostgreSQL </li>
<li> JUnit5 </li></ul>
<img src="https://github.com/moskalenko9381/weather_service/blob/master/base.png" alt="Created Database">

All results are saved in database "weather", current temperature the user may see at http://localhost:8080/weather .
