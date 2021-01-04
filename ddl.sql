create schema amigosecreto;
use amigosecreto;

create table participante (
    id int(11) not null primary key auto_increment,
    nome varchar(200) not null,
    email varchar(200) not null
);

create table sorteio (
    id int(11) not null primary key auto_increment,
    nome varchar(200) not null
);

create table sorteio_participante (
    id int(11) not null primary key  auto_increment,
    id_participante int(11) not null
);

create table sorteio_participante_resultado
(
    id                   int auto_increment
        primary key,
    id_sorteio           int not null,
    id_participante_de   int not null,
    id_participante_para int not null
);


INSERT INTO amigosecreto.participante (id, nome, email) VALUES (1, 'Marcio', 'marcio1991@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (2, 'ERica', 'erica@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (3, 'Diogo', 'diogo@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (4, 'Karine', 'karine@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (5, 'Valeria', 'valeria@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (6, 'Roger', 'roger@gmail.com');
INSERT INTO amigosecreto.participante (id, nome, email) VALUES (7, 'Alan', 'alan@gmail.com');



INSERT INTO amigosecreto.sorteio (id, nome) VALUES (1, 'Marcio');
INSERT INTO amigosecreto.sorteio (id, nome) VALUES (2, 'fdsfdsfds');
INSERT INTO amigosecreto.sorteio (id, nome) VALUES (3, 'dsadsadas');
INSERT INTO amigosecreto.sorteio (id, nome) VALUES (4, 'dsadsadsa');

insert into sorteio_participante (id_participante, id_sorteio)
select participante.id, sorteio.id from participante, sorteio
