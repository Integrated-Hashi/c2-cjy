use c2_cjy_test;
#1
create table if not exists cqupt_student
(
    studentid varchar(10),
    name varchar(20),
    sex varchar(2),
    age int,
    Fee decimal(10,2),
    address varchar(50),
    memo varchar(300)
);

#2
create table if not exists CourseAa
(
    Aa1 varchar(20),
    Aa2 int,
    Aa3 decimal(10)
);

#3
create table if not exists ChooseBb
(
    Bb1 varchar(30),
    Bb2 int,
    Bb3 decimal(6)
);

#4
alter table ChooseBb add Bb4 varchar(20) not null default '系统测试值';

#5
alter table ChooseBb add Bb5 varchar(10) primary key;

#6
create view View_Choosebb(View_bb1, View_bb2, View_bb3) as select Bb1, Bb4, Bb5 from ChooseBb;

#7
drop view View_Choosebb;

#8
create index Index_bb2 on ChooseBb (Bb2 ASC);
create index Index_bb4 on ChooseBb (Bb4 desc);

#9
drop index Index_bb2 on ChooseBb;

#10
create table if not exists test(
    Name varchar(20),
    Age int,
    Score numeric(10, 2),
    Address varchar(60)
);

#11
insert into test (Name, Age, Score, Address) VALUES
('赵一', 20, 580.00, '重邮宿舍12-3-5'),
('钱二', 19, 540.00, '南福苑5-2-9'),
('孙三', 21, 555.50, '学生新区21-5-15'),
('李四', 22, 505.00, '重邮宿舍8-6-22'),
('周五', 20, 495.50, '学生新区23-4-8'),
('吴六', 19, 435.00, '南福苑2-5-12');

#12
create table if not exists test_temp(
   Name varchar(20),
   Age int,
   Score numeric(10, 2),
   Address varchar(60)
);

#13
insert into test (Name, Age, Score, Address) VALUES
('郑七', 21, 490.50, '重邮宿舍11-2-1'),
('张八', 20, 560.00, '南福苑3-3-3'),
('王九', 10, 515.50, '学生新区19-7-1');

#14
insert into test select * from test_temp;

#15
update test set Score = Score+5 where Age <= 20;

#16
update test set Age = Age-1 where Address like '%南福苑%';

#17
delete from test where Age >= 21 and Score >= 500;

#18
delete from test where Score <= 550 and Address like '%重邮宿舍%';

#19
create table if not exists Student
(
    SNO varchar(20),
    Name varchar(10),
    Age int,
    College varchar(30)
);

#20
create table if not exists Course(
    CourseID varchar(15),
    CourseName varchar(30),
    CourseBeforeID varchar(15)
);

#21
create table if not exists Choose(
    SNO varchar(20),
    CourseID varchar(30),
    Score decimal(5, 2)
);

#22
insert into Student (SNO, Name, Age, College) VALUES
('S00001', '张三', 20, '计算机学院'),
('S00002', '李四', 19, '通信学院'),
('S00003', '王五', 21, '计算机学院');

#23
insert into Course (CourseID, CourseName, CourseBeforeID) VALUES
('C1', '计算机引论', null),
('C2', 'C语言', 'C1'),
('C3', '数据结构', 'C2');

#24
insert into Choose (SNO, CourseID, Score) VALUES
('S00001', 'C1', 95),
('S00001', 'C2', 80),
('S00001', 'C3', 84),
('S00002', 'C1', 80),
('S00002', 'C2', 85),
('S00003', 'C1', 78),
('S00003', 'C3', 70);

#25
select SNO, Name from Student where College = '计算机学院';

#26
select * from Student where Age between 20 and 23;

#27
select count(*) from Student;

#28
select max(Score) from Choose where CourseID = 'C1';
select min(Score) from Choose where CourseID = 'C1';
select sum(Score) from Choose where CourseID = 'C1';
select avg(Score) from Choose where CourseID = 'C1';

#29
select  CourseID, CourseName from Course where CourseBeforeID is null;

#30
select Student.SNO, Name, CourseName, Score from
Student, Course, Choose
where Student.SNO = Choose.SNO and Choose.CourseID = Course.CourseID
order by Student.SNO;

#31
select * from Student where College=
                            (
                                select College from Student where Name = '张三'
                                );

#32
select SNO, Score from Choose where CourseID = 'C1' and
                                    Score < (select Score from Choose, Student
                                        where Student.SNO = Choose.SNO and Name = '张三' and CourseID = 'C1');

#33
select SNO from Choose where CourseID = 'C1' union select SNO from Choose where CourseID = 'C3';

#34
select distinct SNO from Student where SNO in (select  SNO from Choose where CourseID = 'C1')
union select distinct SNO from Student where SNO in (select  SNO from Choose where CourseID = 'C3');
