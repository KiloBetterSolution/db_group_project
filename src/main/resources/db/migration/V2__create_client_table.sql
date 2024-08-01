create table Client (
    id int primary key not null auto_increment,
    name varchar(50) not null,
    address varchar(70),
    phone_number varchar(20),
    create_date date not null,
    acquired_by int
);