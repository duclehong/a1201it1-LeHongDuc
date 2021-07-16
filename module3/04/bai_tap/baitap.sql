create database bai4;
create table bai4.hocvien (
id int ,
ten varchar(255),
tuoi int,
khoahoc varchar(255),
sotien int
);
insert into bai4.hocvien value
(1,"hoang",21,"cntt",400000),
(2,"viet",19,"dtvt",320000),
(3,"thanh",18,"ktdn",450000),
(4,"nhan",19,"ck",500000),
(5,"huong",20,"tcnh",200000),
(5,"huong",20,"tcnh",200000);

select * 
from bai4.hocvien 
where ten = "huong";

select sum(sotien) as tongtien
from bai4.hocvien 
where ten = "huong";

select DISTINCT * 
from bai4.hocvien 