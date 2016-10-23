drop table if exists stock;

create table stock(
	stock_id int,
	company_name varchar(50),
	symbol varchar(10),
	price decimal(10, 2)
);

insert into stock values (1, 'Google', 'GL', 20.03);
insert into stock values (2, 'Facebook', 'FB', 50.03);
insert into stock values (3, 'Tesla', 'TS', 20.03);
insert into stock values (4, 'Apple', 'APP', 10.03);