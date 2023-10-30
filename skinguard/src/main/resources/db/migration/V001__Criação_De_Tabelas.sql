create table fps(
 id int not null primary key auto_increment,
 fps int not null

);

create table pele(
      id int not null primary key auto_increment,
      tom varchar(8) not null
);

create table clima(
	id int not null primary key auto_increment,
    hora time,
    dia date,
    uvindex int,
    sol1 time,
    sol2 time
);

create table usuario(
    id int not null primary key auto_increment,
    login varchar (50),
    senha varchar(20),
    idfps int not null,
    idpele int not null,
	idclima int not null

);

Alter table usuario add constraint FK_usuario_fps FOREIGN key usuario(idfps) references fps(id);
Alter table usuario add constraint FK_usuario_pele FOREIGN key usuario(idpele) references pele(id);
ALter table usuario add constraint FK_usuario_clima FOREIGN key usuario(idclima) references clima(id);