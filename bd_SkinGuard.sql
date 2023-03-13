create database SkinGuard;
use SkinGuard;

create table usuario(
 id_usuario int not null primary key,
 email varchar(50) not null,
 senha varchar(8) not null
);

create table dev(
 id_dev int not null primary key,
 email varchar(50) not null,
 senha varchar(8) not null
);

create table tom_pele(
id_pele int not null primary key,
tom varchar(18)
);

create table fps(
id_fps int not null primary key,
fps int not null
);

create table uv_indice(
id_uv int not null primary key,
indice int not null,
_update timestamp not null
);