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
    id_participante int(11) not null,
     constraint fk_id_participante
        foreign key (id_participante) references participante (id),
    id_sorteio int(11) not null,
     constraint fk_id_sorteio
        foreign key (id_sorteio) references sorteio (id)
);

create table sorteio_participante_resultado
(
    id                   int auto_increment
        primary key,
    id_sorteio           int not null,
    id_participante_de   int not null,
    id_participante_para int not null,
    constraint fk_id_sorteio_resultado
        foreign key (id_sorteio) references sorteio (id),
    constraint fk_id_participante_para
        foreign key (id_participante_para) references participante (id),
    constraint fk_id_participante_de
        foreign key (id_participante_de) references participante (id)
);

create index fk_id_participante_para
    on sorteio_participante_resultado (id_sorteio);


