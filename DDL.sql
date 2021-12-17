create schema biblioteca;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on biblioteca.* to user@'localhost';

use biblioteca;

create table liv_livro (
    liv_id bigint unsigned not null auto_increment,
    liv_titulo varchar(100) not null,
    liv_isbn bigint not null,
    liv_editora varchar(50),
    primary key (liv_id),
    unique key uni_livro_titulo (liv_titulo),
    unique key uni_livro_isbn (liv_isbn)
);

create table aur_autor (
    aur_id bigint unsigned not null auto_increment,
    aur_nome varchar(100) not null,
    aur_bio varchar(300),
    aur_pais varchar(10),
    primary key (aur_id)
);

create table lau_livro_autor (
    liv_id bigint unsigned not null,
    aur_id bigint unsigned not null,
    primary key (liv_id, aur_id),
    foreign key lau_liv_fk (liv_id)
        references liv_livro (liv_id)
        on delete restrict on update cascade,
    foreign key lau_aur_fk (aur_id)
        references aur_autor (aur_id)
        on delete restrict on update cascade
);

create table vol_volume (
    vol_id bigint unsigned not null auto_increment,
    vol_data_aquisicao datetime not null,
    vol_observacao varchar(200),
    vol_situacao varchar(10) not null,
    liv_id bigint unsigned not null,
    primary key (vol_id),
    foreign key vol_liv_fk (liv_id)
        references liv_livro (liv_id)
        on delete restrict on update cascade
);

create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_email varchar(100) not null,
    usr_senha varchar(100) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome),
    unique key uni_usuario_email (usr_email)
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key uau_usr_fk (usr_id)
        references usr_usuario (usr_id)
        on delete restrict on update cascade,
    foreign key uau_aut_fk (aut_id)
        references aut_autorizacao (aut_id)
        on delete restrict on update cascade
);


insert into usr_usuario (usr_nome,usr_email ,usr_senha)
    values ('admin','admin@email.com' ,'$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao values (1, 1);