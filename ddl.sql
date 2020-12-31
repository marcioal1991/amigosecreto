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

create table sorte_participante (
    id int(11) not null primary key  auto_increment,
    id_participante int(11) not null,
     constraint fk_id_participante
        foreign key (id_participante) references participante (id),
    id_sorteio int(11) not null,
     constraint fk_id_sorteio
        foreign key (id_sorteio) references sorteio (id)
);

create table sorte_participante_resultado (
    id int(11) not null primary key  auto_increment,
    id_sorteio int(11) not null,
    constraint fk_id_sorteio_resultado
        foreign key (id_sorteio) references sorteio (id),

    id_participante_de int(11) not null,
    constraint fk_id_participante_de
        foreign key (id_sorteio) references participante (id),
        id_participante_para int(11) not null,
    constraint fk_id_participante_para
        foreign key (id_sorteio) references participante (id)
);
