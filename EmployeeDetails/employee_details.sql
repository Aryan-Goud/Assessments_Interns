create table department(
	dept_id int(2) primary key,
    dept_name varchar(30)
);
create table employee (
	emp_id int(2) primary key,
	emp_name varchar(30),
    emp_email varchar(30) not null, 
    empph_no int(10) not null unique key,
    dept_id int,
    foreign key(dept_id) references department(dept_id)
);
ALTER TABLE employee MODIFY COLUMN empph_no VARCHAR(11);
create table address(
	add_id int(2) primary key, 
    add_name varchar(30),
    emp_id int,
    foreign key(emp_id) references employee(emp_id)
);
insert into department values(1,"Dev");
insert into department values(2,"Tester");
insert into department values(3,"QA");
insert into department values(4,"HRteam");
insert into employee values(1,"Aryan","aryan@gmail.com",8989898899,1);
insert into employee values(2,"jagan","jagan@gmail.com",7923198891,3);
insert into employee values(3,"shivam","shivam@gmail.com",9989563892,4);
insert into employee values(4,"shiva","shiva@gmail.com",8189123896,2);
insert into employee values(5,"Raj","raj@gmail.com",8189188896,1);
insert into address values(1,"Hyderabad",1);
insert into address values(2,"Warangal",2);
insert into address values(3,"Hyderabad",3);
insert into address values(4,"Komaplly",5);
insert into address values(5,"Kukatpally",4);
delete from address where add_id=2;
delete from address where add_id=3;
insert into address values(2,"Warangal",2);
select * from employee;
select * from address left join employee on address.add_id = employee.emp_id;

