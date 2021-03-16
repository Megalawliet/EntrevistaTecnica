drop database if exists entrevistaTecnica;
create database entrevistaTecnica;
use entrevistaTecnica;

create table companyuser (
id bigint primary key auto_increment,
username varchar(250),
pwd varchar(250),
userrole varchar(250)
);

create table positions (
id bigint primary key auto_increment,
title varchar(250) not null,
datecreation DATETIME,
descriptionposition varchar(250)
);

create table candidate(
id bigint primary key auto_increment,
username varchar(250),
pwd varchar(250),
namecandidate varchar(250),
surname varchar(250)
);

CREATE TABLE skill(
 id bigint primary key auto_increment,
 skillname varchar(255)
);

create table candidateskill(
id bigint primary key auto_increment,
idcandidate bigint,
idskill bigint,
notes varchar(250),
skillvalue float,
foreign key(idCandidate)
references candidate(id)
on delete cascade
on update cascade,
foreign key (idskill)
references skill(id)
on delete cascade
on update cascade
);

CREATE TABLE candidateposition (
  id bigint auto_increment primary key,
  idcandidate bigint,
  idposition bigint,
  registrydate datetime,
  testdate datetime,
  completiondate datetime,
  result float,
  foreign key(idcandidate) 
  references candidate(id)
  on delete cascade
  on update cascade,
  foreign key(idposition) 
  references positions(id)
  on delete cascade
  on update cascade
);

-- dumping data

insert into positions (title, datecreation, descriptionposition)values
('Programador Java Junior', now(), 'Puesto estable!!!'),
('Programador JavaScript Junior', now(), 'Puesto estable!!!'),
('Programador Java Mid', now(), 'Puesto estable!!!'),
('Programador Python Junior', now(), 'Puesto estable!!!'),
('Programador C# Junior', now(), 'Puesto estable!!!');

insert into skill(skillname)values
('SQL'),
('JAVA'),
('PHP'),
('HTML'),
('CSS');

insert into companyuser(username, pwd, userrole) values
('neo', '123asdasjd', 'expert'),
('trinity', '123ajsdasd', 'HR user'),
('morpheo', '123jjasdasd', 'expert'),
('agent smith', '123asdasjjd', 'expert'),
('architect', '123assddasd', 'HR user');

insert into candidate (username, pwd, namecandidate, surname) values
("sisco", "589746", "Paco", "Casanova"),
("maricarmen", "45454ds", "Rogelio", "Valls"),
("slav", "545854", "Tom", "Monich"),
("jose", "589746", "Maria", "Jesus"),
("rintintin", "10550", "Pepe@", "Chateau");

insert into candidateposition(idcandidate, idposition, registrydate, testdate, completiondate, result) values
(2, 1, now(), (now() + interval 2 hour), (now() + interval 3 hour), 9.4),
(2, 3, now(), (now() + interval 2 hour), (now() + interval 3 hour), 4.4),
(2, 2, now(), (now() + interval 2 hour), (now() + interval 3 hour), 5.4),
(1, 4, now(), (now() + interval 2 hour), (now() + interval 3 hour), 3.4),
(3, 3, now(), (now() + interval 2 hour), (now() + interval 3 hour), 7.4);


insert into candidateskill(idcandidate, idskill, notes, skillvalue) values
(4, 2, 'high skill', 7.7),
(2, 2, 'mid skill', 4.7),
(2, 1, 'high skill', 3.7),
(1, 5, 'high skill', 7.7),
(4, 5, 'over skill', 9.7);







