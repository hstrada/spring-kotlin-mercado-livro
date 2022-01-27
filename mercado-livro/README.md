Como executar o docker

> docker-compose up

Como executar o logs do container

> docker exec -it containerID mysql -uroot -proot

MySQL Script

```sql
create database mercadolivro;

use mercadolivro;

create table pessoas (
    id int auto_increment primary key
    ,nome varchar(255) not null
    ,email varchar(255) not null unique
);
```