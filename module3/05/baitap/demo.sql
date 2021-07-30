create database demo;
create table Products(
Id int,
productCode varchar(45),
productName varchar(45),
productPrice double,
productAmount int,
productDescription varchar(100),
productStatus varchar(45)
);
insert into Products values
(1, '4140', 'IPhone', 30000, 3000, 'hehe', 'hehe'),
(2, '4225', 'SamSung', 1000, 6, 'hehe', 'hehe'),
(3, '4121', 'Oppo', 500, 2, 'hehe', 'hehe');
create unique index idx
on products (productCode);
create index cidx
on products (productName, productPrice);
explain select *
from products
where productCode = '4140' or productName = 'Iphone';
-- câu truy vấn sau khi tạo index sẽ chạy nhanh hơn

create view viewproduct as
select productCode, productName, productPrice, productStatus 
from Products;

create or replace view viewproduct as
select productCode, productName, productPrice
from products;
drop view viewproduct;

delimiter //
create procedure selectAllProducts()
begin
select * from products;
end //
delimiter ;

call selectAllProducts();


delimiter //
create procedure newproduct( 
productCode varchar(45),
productName varchar(45),
productPrice double,
productAmount int,
productDescription varchar(100),
productStatus varchar(45))
begin
insert into products values
(product_Code, product_Name, product_Price, product_Amount, product_Description, product_Status);
end; //
delimiter ;

call newproduct(4, '4122', 'Oppo2', 500, 2, 'hehe', 'hehe');
select * from products;


delimiter //
create procedure edit_product (
in indexx int, 
productCode varchar(45),
productName varchar(45),
productPrice double,
productAmount int,
productDescription varchar(100),
productStatus varchar(45))
begin 
update products
set
productCode = product_Code, productName = product_Name,  
productPrice = product_Price, productAmount = product_Amount,
productDescription = product_Description, productStatus = product_Status
where Id = indexx;
end; //
delimiter ;

delimiter ; //
call edit_product(02, 'ah002', 'Oppo Reno 7', 9.000, 20, 'fivestar', 'New');
select * from products;

delimiter //
create procedure edit_product (
in indx int)
begin 
delete from products
where Id = indx;
end; //
delimiter ;

call edit_product(02);
