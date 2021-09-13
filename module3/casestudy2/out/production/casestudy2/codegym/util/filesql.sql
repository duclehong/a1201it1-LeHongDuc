create database case_study3;
use case_study3;

create table service_type(
	service_type_id int primary key,
    service_type_name varchar(50)
);
create table rent_type(
	rent_type_id int primary key,
    rent_type_name varchar(50),
    rent_type_cost double
);
create table services(
	service_id int primary key auto_increment,
    service_name varchar(50),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    foreign key(rent_type_id) references rent_type(rent_type_id),
    service_type_id int,
    foreign key(service_type_id) references service_type(service_type_id),
    standard_room varchar(50),
    des_other_convenient varchar(50),
    pool_area double,
    number_of_floors int
);
create table customer_type(
	customer_type_id int primary key,
    customer_type_name varchar(50)
);
create table customers(
	customer_id int primary key auto_increment,
    customer_type_id int,
    foreign key(customer_type_id) references customer_type(customer_type_id),
    customer_name varchar(50),
    customer_birthday date,
    customer_gender varchar(50),
    customer_id_card varchar(50),
    customer_phone varchar(50),
    customer_email varchar(50),
    customer_address varchar(50)
);

create table education(
	education_id int primary key,
    education_name varchar(50)
);
create table `position`(
	position_id int primary key,
    position_name varchar(50)
);
create table division(
	division_id int primary key,
    division_name varchar(50)
);
create table `role`(
	role_id int primary key,
    role_name varchar(50)
);
create table users(
	userName varchar(50) primary key,
    passsword varchar(50)
);
create table user_role(
	role_id int ,
    userName varchar(50),
    primary key(role_id,userName),
    foreign key(role_id) references `role`(role_id),
    foreign key(userName) references users(userName)
);
create table employees(
	employee_id int primary key auto_increment,
    employee_name varchar(50),
    employee_birthday date,
    employee_id_card varchar(50),
    employee_salary double,
    employee_phone varchar(50),
    employee_email varchar(50),
    employee_address varchar(50),
    position_id int,
    foreign key(position_id) references `position`(position_id),
    education_id int,
    foreign key(education_id) references education(education_id),
    division_id int,
    foreign key(division_id) references division(division_id)
--     userName varchar(50),
--     foreign key(userName) references users(userName)
);
create table contract(
	contract_id int primary key auto_increment,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    foreign key(employee_id) references employees(employee_id),
    customer_id int,
    foreign key(customer_id) references customers(customer_id),
    service_id int,
    foreign key(service_id) references services(service_id)
);
create table attach_service(
	attach_service_id int primary key,
    attach_service_name varchar(50),
	attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(50)
);
create table contract_detail(
	contract_detail_id int primary key auto_increment,
    contract_id int,
    foreign key(contract_id) references contract(contract_id),
    attach_service_id int,
    foreign key(attach_service_id) references attach_service(attach_service_id),
    quanlity int
);
insert into `position`
values
(1,'Le Tan'),
(2,'Phuc Vu'),
(3,'Chuyen Vien'),
(4,'Giam Sat'),
(5,'Quan Ly'),
(6,'Giam Doc');
insert into education
values
(1,'Trung Cap'),
(2,'Cao Dang'),
(3,'Dai hoc'),
(4,'Sau Dai Hoc');
insert into division
values
(1,'Sale-Marketing'),
(2,'Hanh Chinh'),
(3,'Phuc Vu'),
(4,'Quan Ly');
insert into employees
values
(1,'Nguyen Van A','2001-01-01','C1',10000,'0974405695','a@gmail.com','a street',1,1,1),
(2,'Nguyen Van B','2002-02-02','C2',20000,'0854475125','b@gmail.com','b street',2,2,2),
(3,'Nguyen Van C','2003-03-03','C3',30000,'0365221421','c@gmail.com','c street',3,3,3),
(4,'Nguyen Van D','2004-04-04','C4',40000,'0544412549','d@gmail.com','d street',4,4,4);
insert into service_type
values
(1,'Villa'),
(2,'House'),
(3,'Room');
insert into rent_type
values
(1,'Nam',120),
(2,'Thang',60),
(3,'Ngay',40),
(4,'Gio',30);
insert into services
values
(1,'Dich Vu 1',10,10,10,1,1,'AAA','AAa',10,10),
(2,'Dich Vu 2',20,20,20,2,2,'BBB','BBb',20,20),
(3,'Dich Vu 3',30,30,30,3,3,'CCC','CCc',30,30);
insert into customer_type
values
(1,'Diamond'),
(2,'Gold'),
(3,'Member'),
(4,'Silver');

insert into contract
values
(1,'2011-01-01','2021-01-01',100,1000,1,1,1),
(2,'2012-02-02','2022-02-02',200,2000,2,2,2),
(3,'2013-03-03','2023-03-03',300,3000,3,3,3),
(4,'2001-01-01','1991-01-01',100,1000,1,1,1);

insert into customers
values
(1, 1 ,'Kudo', '2001-01-01', 'Nam', 'A1' , '065522124', 'a@gmail.com', 'a street');
delete from customers where customer_id = 2;
insert into customers
value
(1, 1, 'Kudo', '2001-01-01', 'Nam', 'A1' , '065522124', 'a@gmail.com', 'a street'),
(2, 2, 'Nicha', '2002-02-02', 'Nam', 'B2' , '015224258', 'b@gmail.com', 'b street'),
(3, 3, 'Katanaa', '2003-03-03', 'Nu', 'C3' , '0966325214', 'c@gmail.com', 'c street'),
(4, 4, 'Mono', '2004-04-04', 'Nam', 'D4' , '4444', 'd@gmail.com', 'd street');

-- user vs roleuser vs contractdetail vs attach_service vs role