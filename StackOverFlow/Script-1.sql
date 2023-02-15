create database stackoverflow;
use stackoverflow;
create table user (
user_id int(2) primary key,
username varchar(30),
reputation bigint(10) not null,
votesup int(3),
votesdown int(3),
views int(3),
create_date date
);
insert into user values(1,"aryan",1000,20,2,13,'2022-02-11');
insert into user values(2,"ramesh",800,14,1,09,'2021-04-01');
insert into user values(3,"kushi",400,10,10,23,'2019-03-12');
insert into user values(4,"ravi",999,17,6,19,'2018-11-16');
insert into user values(5,"hari",1400,22,4,20,'2020-10-14');
create table post (
post_id int(2) primary key,
user_id int(3),
posttype_id int(2),
title varchar(30),
body varchar(30),
commentcount int(3) not null,
votescount int(3),
create_date date,
last_updated date,
foreign key(user_id) references user(user_id)
);
alter  table post drop column posttype_id;
insert into post values(1,2,"hi","what is string",13,2,'2023-01-12','2023-02-01');
insert into post values(2,1,"hello","what is int",11,3,'2023-01-13','2023-02-02');
insert into post values(3,1,"hello","what is interface",3,1,'2023-02-12','2023-02-01');
insert into post values(4,3,"hi","how string works",12,2,'2022-08-16','2022-09-11');
insert into post values(5,4,"hi","what is string",9,4,'2023-01-12','2023-02-01');
create table votes(
vote_id int(3)primary key,
votetype_id int(3), ////voteup then 1 else 0
create_on date,
amount bigint(10),
user_id int(3),
post_id int(3),
foreign key(user_id) references user(user_id),
foreign key(post_id) references post(post_id)
);
insert into votes values(1,1,'2023-01-12',50,1,2);
insert into votes values(2,0,'2023-01-12',100,2,1);
insert into votes values(3,1,'2022-08-16',50,3,4);
insert into votes values(4,1,'2023-02-12',50,4,5);

create table comments(
comment_id int(3)primary key,
texting varchar(30),
create_on date,
updated_on date,
user_id int(3),
post_id int(3),
foreign key(user_id) references user(user_id),
foreign key(post_id) references post(post_id)
);
insert into comments  values(1,"good",'2023-01-12','2023-02-01',2,1);
insert into comments values(2,"ans",'2023-01-13','2023-02-02',1,2);
insert into comments values(3,"text",'2023-02-12','2023-02-01',3,4);
insert into comments values(4,"img",'2023-01-12','2023-02-01',4,5);

create table pending(
pend_id int(3)primary key,
pendtype_id int(3),
reason varchar(30),
duplicate int(2),
post_id int(3),
foreign key(post_id) references post(post_id)
);
insert into pending values(1,1,"not proper",0,3);
create table tags(
tags_id int(3)primary key,
tagname varchar(30),
create_on date
);
insert into tags values(1,"#hi",'2023-02-12');
create table tagcon(
taging_id int(3)primary key,
tags_id int(3),
post_id int(3),
foreign key(tags_id) references tags(tags_id),
foreign key(post_id) references post(post_id)
);
insert into tagcon values(1,1,2);
show tables;
drop table tagcon;

