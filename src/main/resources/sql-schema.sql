create database if not exists ims;
create table if not exists ims.customers(customer_ID int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(Item_ID int primary key auto_increment, Name varchar(40), Price int);
