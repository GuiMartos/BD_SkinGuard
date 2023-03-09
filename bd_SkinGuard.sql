create database SkinGuard;
use SkinGuard;

create table usuario(
 id_usuario int not null primary key,
 email varchar(50) not null,
 senha varchar(8) not null
);

create table tompele(
id_pele int not null primary key,
tom varchar(18)
);

create table fps(
id_fps int not null primary key,
fps int not null
);