create database gamedoanso;
use gamedoanso;
create table users(
	id int auto_increment,
    username varchar(20),
    password varchar(20),
    hoten varchar(20),
    age int,
    created_time timestamp default now(),
    
    primary key(id)
);

create table diemso(
	id int auto_increment,
    id_user int,
    diem int,
    created_time timestamp default now(),
    
    primary key(id),
    foreign key(id_user) references users(id)
);
use gamedoanso;
select * from users;
select * from diemso;
insert into users(username,password,hoten,age) values('tien','123','Nguyen Dinh Tien',3);
select * from users u where u.username='tien' and u.password='123';
insert into diemso(id_user,diem) values(1,200);

select u.hoten,d.diem,d.created_time from users u, diemso d where u.id=d.id_user order by d.diem ASC limit 7;

select d.diem,d.created_time from users u, diemso d where  u.id= 2 and u.id=d.id_user order by d.diem ASC
