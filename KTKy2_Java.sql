create database KTKy2_Java
use KTKy2_Java


create table Employee(
    id nvarchar(30) primary key,
	fullname nvarchar(30) not null,
	birthday nvarchar(30) not null, 
	phone nvarchar(30) not null,
	email nvarchar(30) not null,
    employeeType NVARCHAR(30) not null,
    employeeCount int not null
	
);

insert into Employee(id, fullname, birthday, phone, email, employeeType, employeeCount) values
('12345', 'Tran Kim Quyen', '6/8/2005', '0396765499', 'quyentk23ite@vku.udn.vn','Experience', '1'),
('23456', 'Nguyen Quang Hung', '1/9/2004', '0453465652', 'hungnq23ite@gmail.com ','Fresher', '2'),
('34567', 'Le Thi Bich Tram', '2/10/2003', '0336252869', 'tram2423@gmail.com','Intern', '3')


select * from Employee
