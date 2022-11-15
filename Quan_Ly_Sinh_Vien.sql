Create database Quan_Ly_Sinh_Vien
go 
use Quan_Ly_Sinh_Vien
go 

create table classs (
	class_id int  IDENTITY(1,1) NOT NULL, 
	class_code nvarchar (200),
	CONSTRAINT [PK_SAMPLE] PRIMARY KEY CLUSTERED (class_id ASC)
)
go 

create table student (
	student_id int  IDENTITY(1,1) NOT NULL, 
	student_name nvarchar (200),
	birthday date,
	class_id int,
	constraint fk foreign key (class_id) references classs(class_id),
	CONSTRAINT [PK_1] PRIMARY KEY CLUSTERED (student_id ASC)
)
go 

create table subject (
	subject_id int  IDENTITY(1,1) NOT NULL , 
	subject_name nvarchar (200),
	sesstioncount int,
	CONSTRAINT [PK_2] PRIMARY KEY CLUSTERED (subject_id ASC)
)
go 

create table result (
	result_id int  IDENTITY(1,1) NOT NULL,
	student_id int,
	subject_id int,
	mark float,
	constraint fk1 foreign key (student_id) references Student(student_id),
	constraint fk2 foreign key (subject_id) references Subject(subject_id),
	CONSTRAINT [PK_3] PRIMARY KEY CLUSTERED (result_id ASC)
)
go

SET IDENTITY_INSERT classs ON 
insert into classs (class_id, class_code ) values (1,N'Lớp E'),
(2,N'Lớp A'),
(3,N'Lớp B'),
(4,N'Lớp C'),
(5,N'Lớp D')
SET IDENTITY_INSERT classs OFF 
go 

select * from classs
delete from classs

SET IDENTITY_INSERT student ON 
insert into student (student_id , student_name  ,birthday ,class_id) values (1,N'Nguyễn Văn Chiến', '2012-03-12',2 ),
(2,N'Nguyễn Thị Hòa', '2012-01-06',2 ),
(3,N'Nguyễn Văn Hoàng', '2012-01-02',3 ),
(4,N'Nguyễn Văn Lý', '2012-06-08',2 ),
(5,N'Trần Văn Áo', '2012-05-10',4 ),
(6,N'Trần Thị Tình', '2012-07-12',5 ),
(7,N'Nguyễn Văn Huy', '2012-03-19',1 ),
(8,N'Nguyễn Thị Mơ', '2012-01-03',4 ),
(9,N'Nguyễn Thị Cảo', '2012-08-09',5 ),
(10,N'Nguyễn Văn Bá', '2012-12-12',1 ),
(11,N'Nguyễn Văn Mơ', '2012-05-08',2 ),
(12,N'Nguyễn Văn Tiến', '2012-01-12',4 ),
(13,N'Nguyễn Văn Chính', '2012-09-01',5 ),
(14,N'Nguyễn Văn Tới', '2012-09-02',1 ),
(15,N'Nguyễn Văn Chính', '2012-01-01',3 ),
(16,N'Nguyễn Thị Bưởi', '2012-01-29',2 ),
(17,N'Đinh Thị Chiến', '2012-10-11',4 ),
(18,N'Nguyễn Hà Vi', '2012-11-12',5 ),
(19,N'Nguyễn Văn Đạt', '2012-12-30',3 ),
(20,N'Nguyễn Văn Linh', '2012-03-10',2 ),
(21,N'Nguyễn Bá Chiên', '2012-05-14',3 ),
(22,N'Nguyễn Văn Ninh', '2012-03-12',4 ),
(23,N'Trần Thiện Thuận', '2012-01-03',1 ),
(24,N'Nguyễn Bá Văn', '2012-08-09',4 ),
(25,N'Trần Huy Hiệu', '2012-12-12',2 ),
(26,N'Nguyễn Thị Thảo', '2012-03-22',3 ),
(27,N'Nguyễn Văn Định', '2012-03-22',1 ),
(28,N'Bùi Đình Huân', '2012-03-22',2 ),
(29,N'Bùi Văn Chiến', '2012-03-22',5 ),
(30,N'Bùi Xuân Huấn', '2012-03-22',5 )
go
SET IDENTITY_INSERT student OFF 

SET IDENTITY_INSERT subject ON 
insert into subject(subject_id , subject_name  ,sesstioncount ) values (1, 'C Programming', 22),
(2, 'Web Design', 18),
(3, 'Database Management', 23)
SET IDENTITY_INSERT subject OFF 


SET IDENTITY_INSERT result ON 
insert into result(result_id ,student_id ,subject_id ,mark) values (1,1,1,6.4),
(2,2,2,6.2),
(3,3,3,6.1),
(4,4,2,9.4),
(5,5,2,7.5),
(6,6,1,7.4),
(7,7,3,7.8),
(8,8,2,8.4),
(9,9,3,8.7),
(10,10,3,8.3),
(11,11,1,8.1),
(12,12,2,8.2),
(13,13,3,6.8),
(14,14,2,8.4),
(15,15,1,7.4),
(16,16,2,9.6),
(17,17,2,7.4),
(18,18,3,5.4),
(19,19,2,2.4),
(20,20,1,9.4),
(21,21,3,5.4),
(22,22,1,8.4),
(23,23,3,6.4),
(24,24,2,8.4),
(25,25,3,9.4),
(26,26,3,6.4),
(27,27,1,8.4),
(28,28,3,7.2),
(29,29,3,7.7),
(30,30,3,9.1)
go
SET IDENTITY_INSERT result OFF 

select  * from classs