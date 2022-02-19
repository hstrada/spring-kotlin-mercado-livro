### Como executar o docker

> docker-compose up

### Como executar o logs do container

> docker exec -it containerID mysql -uroot -proot

### Documentation

> http://localhost:8080/swagger-ui/index.html

### MySQL Script

```sql
create database mercadolivro;

use mercadolivro;

create table customers (
    id int auto_increment primary key
    ,name varchar(255) not null
    ,email varchar(255) not null unique
);
```