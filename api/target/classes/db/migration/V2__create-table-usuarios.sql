-- criaçao da tabela usuarios
-- sempre PARE a execução da aplicação antes de executar uma migration
--
create table usuarios(
    id bigint not null auto_increment,
    usuario varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)
);
