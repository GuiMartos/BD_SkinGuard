-- Tabela do FPS do filtro solar
create table fps(

 id int not null primary key auto_increment,
 fps int not null

);

insert into fps values(30);
insert into fps values(50);
insert into fps values(60);
insert into fps values(70);
insert into fps values(80);
insert into fps values(90);
insert into fps values(99);

-- Tabela do dispositivo medidor
create table eps(
  id int not null primary key auto_increment,
  esp int not null
);


-- Tabela do tipo de pele
create table pele(
      id int not null primary key auto_increment,
      tom int not null
);
insert into pele values("Tipo 1");
insert into pele values("Tipo 2");
insert into pele values("Tipo 3");
insert into pele values("Tipo 4");
insert into pele values("Tipo 5");
insert into pele values("Tipo 6");
insert into pele values("Tipo 7");

-- Tabela do Usuario
create table usuario(
    id int not null primary key auto_increment,
    login varchar (50),
    senha varchar(20),
    idfps int not null,
    idpele int not null,
    idesp int

);

Alter table usuario add constraint FK_usuario_fps FOREIGN key usuario(idfps) references fps(id);
Alter table usuario add constraint FK_usuario_pele FOREIGN key usuario(idpele) references pele(id);
Alter table usuario add constraint Fk_usuario_esp FOREIGN key usuario(idesp) references esp(id);

