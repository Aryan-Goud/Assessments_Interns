create database health_insurance;
use health_insurance;
create table role_name(roles_id int(3) primary key,role_name varchar(10));
insert into role_name values(1,"EMP");
update role_name set role_name="EMP" where role_name="DEV";
insert into role_name values(2,"HR");
create table user (
user_id int(3) primary key,
name varchar(10) not null,
email varchar(30),
phno int(11) unique key,
DOB date,
roles_id int(3),
foreign key(roles_id) references role_name(roles_id)
);
alter table user add marital_status boolean;
select * from user;
alter table user modify phno bigint(11);
insert into user values(1,"Aryan","aryan@gmail.com",9090909090,'2002-04-11',1);
delete from user  where user_id=1;
update user set marital_status=true where marital_status is null ;
insert into user values(2,"Raju","raju@gmail.com",9090778090,'1991-03-01',2,true);
insert into user values(3,"Ramesh","Ramesh@gmail.com",8960909090,'1994-02-11',1,false);
insert into user values(4,"Suresh","suresh@gmail.com",9091119090,'1989-03-13',2,true);
insert into user values(5,"Rajesh","rajesh@gmail.com",9011909033,'2000-11-21',1,true);
insert into user values(6,"Vani","Vani@gmail.com",9011556633,'1990-12-26',1,false);
create table parents(
p_id int(3) primary key,
name varchar(10) ,
phno int(11) ,
DOB date,
user_id int(3),
foreign key(user_id) references user(user_id)
);
alter table parents modify phno bigint(11);
delete from parents where p_id=1;
select * from parents;
insert into parents values(1,"Srinivas",9090908880,'1970-07-12',1);
insert into parents values(2,"Hari",9092228880,'1960-01-11',2);
create table spouse(
s_id int(3) primary key,
name varchar(10) ,
phno bigint(11) ,
DOB date,
user_id int(3),
foreign key(user_id) references user(user_id)
);
insert into spouse values(1,"rani",9113656112,'2004-03-22',1);
insert into spouse values(2,"sowmya",9095651212,'1996-09-12',2);
insert into spouse values(3,"vani",9095656112,'1999-08-25',4);
insert into spouse values(4,"kavya",9095633312,'1998-05-21',5);

create table child(
c_id int(3) primary key,
name varchar(10) ,
phno bigint(11) ,
DOB date,
user_id int(3),
foreign key(user_id) references user(user_id)
);
select * from child;
insert into child values(1,"",9090908880,'2009-08-09',1);
update child set name="ayaan" where name is null; 
insert into child values(1,"kanna",9090142880,'2009-08-09',1);
insert into child values(2,"divya",9092213880,'2003-02-21',2);
insert into child values(3,"sunitha",9111208880,'2002-01-09',5);
create table gpad(
gpad_id int(3) primary key,
amount bigint(10)
);
select * from gpad;
insert into gpad values(1,100000); 
insert into gpad values(2,110000,2);
insert into gpad values(3,200000,3);
insert into gpad values(4,123000,5);
insert into gpad values(5,111000,4);
create table top_ups(
top_id int(3) primary key,
amount bigint(9)
);
alter table top_ups add monthly_dec bigint(9);
select * from gpad;
alter table gpad add user_id int(3);
alter table gpad add foreign key(user_id) references user(user_id);
insert into top_ups values(1,100000);
insert into top_ups values(2,200000,2000);
insert into top_ups values(3,300000,3000);
insert into top_ups values(4,400000,4000);
insert into top_ups values(5,500000,5000);
update top_ups set monthly_dec=1000 where top_id=1;
update gpad set user_id=1 where gpad_id=1;
create table comapany(
cmp_id int(3) primary key,
cmp_name varchar(20),
cmp_addr varchar(20)
);
drop table company;
insert into comapany values(1,"tata health","HYD");
ALTER TABLE comapany RENAME company;
select * from company;
create table cycles(
cycle_id int(3) primary key,
intial int(5),
ending int(5),
cmp_id int(3),
top_id int(3),
foreign key(cmp_id) references company(cmp_id),
foreign key(top_id) references top_ups(top_id)
);
select * from cycles;
ALTER TABLE cycles
ADD CONSTRAINT uni UNIQUE (intial,ending); 
alter table cycles drop foreign key cmp_id;
alter table cycles modify intial year;
alter table cycles modify ending year;
insert into cycles values(2,2001,2002,1);
insert into cycles values(3,2003,2005,3);
insert into cycles values(4,2005,2006,2);
insert into cycles values(5,2007,2008,1);
create table usercycle(
usercycle_id int(3) primary key,
user_id int(3),
cycle_id int(3),
foreign key(user_id) references user(user_id),
foreign key(cycle_id) references cycles(cycle_id)
);
select * from usercycle;
insert into usercycle values(1,2,3);
insert into usercycle values(2,2,3);
insert into usercycle values(3,6,1);
insert into usercycle values(4,5,4);
create table cycle_topups(
ct_id int(3) primary key,
cycle_id int(3),
top_id int(3),
foreign key(cycle_id) references cycles(cycle_id),
foreign key(top_id) references top_ups(top_id)
);
insert into cycle_topups values(1,1,1);
insert into cycle_topups values(2,2,3);
insert into cycle_topups values(3,4,2);
insert into cycle_topups values(4,5,4);
ALTER TABLE top_ups
ADD CONSTRAINT uni UNIQUE (amount); 
select * from cycle_topups;
show tables;