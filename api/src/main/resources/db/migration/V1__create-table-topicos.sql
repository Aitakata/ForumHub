-- criaçao da tabela topicos
-- sempre PARE a execução da aplicação antes de executar uma migration
--
create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(500) not null unique,
    dataCriacao datetime not null,
    statusMsg tinyint not null unique,
    autor varchar(100) not null,
    curso varchar(100) not null,
    respostas varchar(100),

    primary key(id)
);
