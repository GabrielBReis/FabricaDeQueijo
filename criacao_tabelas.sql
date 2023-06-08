create table testes (
   id_teste int not null auto_increment,
   tipo varchar(40) not null,
   descricao varchar(140),
   primary key (id_teste)
);

create table lote_materia_prima (
   id_lote_mp int not null auto_increment,
   data_recebimento date not null,
   qtde float not null,
   primary key (id_lote_mp)
);

create table resultados_testes (
   id_resultados int not null auto_increment,
   data_teste date not null, 
   nota float not null,
   id_teste int not null,
   aprovacao char(1) not null,
   id_lote_mp int not null,
   primary key (id_resultados),
   foreign key (id_teste) references testes (id_teste),
   foreign key (id_lote_mp) references lote_materia_prima (id_lote_mp),
   constraint check_aprovacao check (aprovacao in ('A', 'R'))
);

create table telefones (
   id_telefone int not null auto_increment,
   ddd char(2) not null,
   numero char(9) not null,
   primary key (id_telefone)
);

create table enderecos (
   id_endereco int not null auto_increment,
   numero varchar(6),
   logradouro varchar(100) not null,
   primary key (id_endereco)
);

create table funcionarios (
   id_funcionario int not null auto_increment,
   nome varchar(50) not null,
   cpf char(11) not null unique,
   nit char(11) not null unique,
   setor varchar(20),
   id_telefone int not null,
   id_endereco int not null,
   primary key (id_funcionario),
   foreign key (id_telefone) references telefones (id_telefone),
   foreign key (id_endereco) references enderecos (id_endereco)
);

create table producao (
   id_producao int not null auto_increment,
   data_prod date not null,
   qtde float not null,
   id_lote_mp int not null,
   id_funcionario int not null,
   primary key (id_producao),
   foreign key (id_lote_mp) references lote_materia_prima (id_lote_mp),
   foreign key (id_funcionario) references funcionarios (id_funcionario)
);

create table tipo_queijo (
   id_tpq int not null auto_increment,
   descricao varchar(15) not null,
   primary key (id_tpq),
   constraint check_descricao check (descricao in ('COALHO', 'MUSSARELA', 'LANCHE', 'ESPECIAL'))
);

create table producao_tipo_queijo (
   id_prod_tpq int not null auto_increment,
   id_tpq int not null,
   id_producao int not null,
   primary key (id_prod_tpq),
   foreign key (id_tpq) references tipo_queijo (id_tpq),
   foreign key (id_producao) references producao (id_producao)
);

create table estoque (
   id_estoque int not null auto_increment,
   qtde float not null,
   lote int not null,
   id_prod_tpq int not null,
   primary key (id_estoque),
   foreign key (id_prod_tpq) references producao_tipo_queijo (id_prod_tpq)
);

create table clientes (
   id_cliente int not null auto_increment,
   id_telefone int not null,
   id_endereco int not null,
   primary key (id_cliente),
   foreign key (id_telefone) references telefones (id_telefone),
   foreign key (id_endereco) references enderecos (id_endereco)
);

create table pessoa_fisica (
   id_pf int not null auto_increment,
   nome varchar(50) not null,
   cpf char(11) unique,
   id_cliente int not null unique,
   primary key (id_pf),
   foreign key (id_cliente) references clientes (id_cliente)
);

create table pessoa_juridica (
   id_pj int not null auto_increment,
   razao_social varchar(50) not null,
   cnpj char(14) not null unique,
   id_cliente int not null unique,
   primary key (id_pj),
   foreign key (id_cliente) references clientes (id_cliente)
);

create table compras (
   id_compra int not null auto_increment,
   data_compra date not null,
   forma_pgto varchar(15) not null,
   id_cliente int not null,
   primary key (id_compra),
   foreign key (id_cliente) references clientes (id_cliente),
   constraint check_forma_pgto check (forma_pgto in ('CREDITO', 'DEBITO', 'PIX', 'TRANSFERENCIA', 'ESPECIE'))
);

create table vendas (
   id_venda int not null auto_increment,
   qtde float not null,
   valor float not null,
   id_estoque int not null,
   id_compra int not null,
   primary key (id_venda),
   foreign key (id_estoque) references estoque (id_estoque),
   foreign key (id_compra) references compras (id_compra)
);