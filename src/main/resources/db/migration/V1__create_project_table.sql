create table Project (
    id int primary key auto_increment not null,
    name varchar(100) not null,
    `value` decimal(10,2),
    status enum('TODO', 'INPROGRESS', 'COMPLETED'),
    client_id int,
    techlead_id int
);