-- Tabela do FPS do filtro solar
create table fps(
 id int not null primary key auto_increment,
 fps int not null

);


-- Tabela do tipo de pele
create table pele(
      id int not null primary key auto_increment,
      tom varchar(8) not null
);

-- Tabela do Usuario
create table usuario(
    id int not null primary key auto_increment,
    login varchar (50),
    senha varchar(20),
    idfps int not null,
    idpele int not null,


);

Alter table usuario add constraint FK_usuario_fps FOREIGN key usuario(idfps) references fps(id);
Alter table usuario add constraint FK_usuario_pele FOREIGN key usuario(idpele) references pele(id);


-- Inserts tabela fps
insert into fps(fps) values(30);
insert into fps(fps) values(50);
insert into fps(fps) values(60);
insert into fps(fps) values(70);
insert into fps(fps) values(80);
insert into fps(fps) values(90);
insert into fps(fps) values(99);

-- Insets tabela pele
insert into pele(tom) values("Tom 1");
insert into pele(tom) values("Tom 2");
insert into pele(tom) values("Tom 3");
insert into pele(tom) values("Tom 4");
insert into pele(tom) values("Tom 5");
insert into pele(tom) values("Tom 6");
insert into pele(tom) values("Tom 7");