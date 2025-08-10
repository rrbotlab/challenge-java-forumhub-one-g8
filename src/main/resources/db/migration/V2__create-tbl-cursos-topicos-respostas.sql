-- tabela cursos
create table if not exists cursos (
    id bigint auto_increment primary key,
    nome varchar(100) not null unique,
    categoria varchar(100) not null,
    ativo tinyint not null default 1
);

-- tabela tópicos
create table if not exists topicos (
    id bigint auto_increment primary key,
    titulo varchar(255) unique not null,
    mensagem varchar(255) unique not null,
    data_criacao datetime not null default current_timestamp,
    status varchar(20) not null,
    autor_id bigint not null,
    curso_id bigint not null,
    ativo tinyint not null default 1,
    foreign key (autor_id) references usuarios(id),
    foreign key (curso_id) references cursos(id)
);

-- tabela respostas
create table if not exists respostas (
    id bigint auto_increment primary key,
    mensagem varchar(255) unique not null,
    topico_id bigint not null,
    data_criacao datetime not null default current_timestamp,
    autor_id bigint not null,
    solucao boolean default false,
    ativo tinyint not null default 1,
    foreign key (topico_id) references topicos(id),
    foreign key (autor_id) references usuarios(id)
);

