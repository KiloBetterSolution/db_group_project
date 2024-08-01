create table Employee (
    id int primary key not null auto_increment,
    name varchar(50) not null,
    salary decimal(6,2) not null,
    bank_account_number varchar(28) not null,
    national_insurance_number varchar(30) not null
);