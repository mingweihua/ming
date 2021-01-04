create database ming;
use ming;

create table product(
  id int primary key auto_increment,
  name varchar(20),
  price int
);

insert into product values (null,'手机',3999);
insert into product values (null,'耳机',699);