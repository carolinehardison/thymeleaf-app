DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         id int(11) NOT NULL,
                         department varchar(255) DEFAULT NULL,
                         name varchar(255) DEFAULT NULL,
                         updated_by varchar(255) DEFAULT NULL,
                         updated_on varchar(255) DEFAULT NULL,
                         PRIMARY KEY (id)
);

insert into student (id, department, name, updated_by, updated_on) values (12, 'Music', 'Joe Jonas', 'Code Queen', '2019-10-14');
insert into student (id, department, name, updated_by, updated_on) values (5, 'Risk Management', 'Anja Fomin', 'Code Queen', '2019-10-10');
insert into student (id, department, name, updated_by, updated_on) values (10, 'Computer Science', 'Caroline Hardison', 'Code Queen', '2019-10-10');
