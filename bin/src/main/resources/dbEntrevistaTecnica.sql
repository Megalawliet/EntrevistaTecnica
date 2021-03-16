drop database if exists entrevistaTecnica;
create database entrevistaTecnica;
use entrevistaTecnica;

create table companyUser (
id bigint primary key auto_increment,
username varchar(250),
pwd varchar(250),
userRole varchar(250)
);

create table positions (
id bigint primary key auto_increment,
title varchar(250) not null,
dateCreation DATETIME,
descriptionPosition varchar(250)
);

create table candidate(
id bigint primary key auto_increment,
username varchar(250),
pwd varchar(250),
nameCandidate varchar(250),
surname varchar(250)
);

CREATE TABLE skill(
 id bigint primary key auto_increment,
 skillName varchar(255)
);

create table candidateSkill(
id bigint primary key auto_increment,
idCandidate bigint,
idSkill bigint,
notes varchar(250),
skillValue float,
foreign key(idCandidate)
references candidate(id)
on delete cascade
on update cascade,
foreign key (idSkill)
references skill(id)
on delete cascade
on update cascade
);

CREATE TABLE candidatePosition (
  id bigint auto_increment primary key,
  idCandidate bigint,
  idPosition bigint,
  registryDate datetime,
  testDate datetime,
  completionDate datetime,
  result float,
  foreign key(idCandidate) 
  references candidate(id)
  on delete cascade
  on update cascade,
  foreign key(idPosition) 
  references positions(id)
  on delete cascade
  on update cascade
);

-- dumping data

insert into positions (title, dateCreation, descriptionPosition)values
('Programador Java Junior', now(), 'Puesto estable!!!'),
('Programador JavaScript Junior', now(), 'Puesto estable!!!'),
('Programador Java Mid', now(), 'Puesto estable!!!'),
('Programador Python Junior', now(), 'Puesto estable!!!'),
('Programador C# Junior', now(), 'Puesto estable!!!');

insert into skill(skillName)values
('SQL'),
('JAVA'),
('PHP'),
('HTML'),
('CSS');

insert into companyUser(username, pwd, userRole) values
('neo', '123asdasjd', 'expert'),
('trinity', '123ajsdasd', 'HR user'),
('morpheo', '123jjasdasd', 'expert'),
('agent smith', '123asdasjjd', 'expert'),
('architect', '123assddasd', 'HR user');

insert into candidate (username, pwd, nameCandidate, surname) values
("sisco", "589746", "Paco", "Casanova"),
("maricarmen", "45454ds", "Rogelio", "Valls"),
("slav", "545854", "Tom", "Monich"),
("jose", "589746", "Maria", "Jesus"),
("rintintin", "10550", "Pepe@", "Chateau");

insert into candidatePosition(idCandidate, idPosition, registryDate, testDate, completionDate, result) values
(2, 1, now(), (now() + interval 2 hour), (now() + interval 3 hour), 9.4),
(2, 3, now(), (now() + interval 2 hour), (now() + interval 3 hour), 4.4),
(2, 2, now(), (now() + interval 2 hour), (now() + interval 3 hour), 5.4),
(1, 4, now(), (now() + interval 2 hour), (now() + interval 3 hour), 3.4),
(3, 3, now(), (now() + interval 2 hour), (now() + interval 3 hour), 7.4);


insert into candidateSkill(idCandidate, idSkill, notes, skillValue) values
(4, 2, 'high skill', 7.7),
(2, 2, 'mid skill', 4.7),
(2, 1, 'high skill', 3.7),
(1, 5, 'high skill', 7.7),
(4, 5, 'over skill', 9.7);







