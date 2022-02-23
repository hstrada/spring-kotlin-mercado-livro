CREATE TABLE purchases (
    id int auto_increment primary key
    ,customer_id int not null
    ,nfe varchar(255)
    ,price DECIMAL(15,2) not null
    ,created_at DATETIME not null
    ,FOREIGN KEY (customer_id) references customer(id)
)

create table purchases_books (
    purchase_id int not null
    ,book_id int not null
    ,FOREIGN KEY (purchase_id) references purchases(id)
    ,FOREIGN KEY (book_id) references books(id)
    ,primary key (purchase_id, book_id)
)