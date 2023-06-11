insert into 
	testes(tipo, descricao)
values 
	('Alizarol', 'Verificar estabilidade térmica e acidez do leite. O resultado é obtido em porcentagem com mínimo de 72%');

insert into 
	testes(tipo, descricao)
values 
	('Dornic', 'Quantificar grau de acidez do leite. O resultado é expresso em graus Dronic ou porcentagem de ácido lático');

insert into 
	testes(tipo, descricao)
values 
	('Teste da gordura', 'Verificar se a porcentagem de gordura está dentro dos padrões necessários');

insert into 
	testes(tipo, descricao)
values 
	('Teste da densidade', 'Verificar adulterações na matéria-prima (adição de água ou outros componentes). O resultado é obtido em g/ml');

insert into 
	testes(tipo, descricao)
values 
	('EST', 'Concentração dos componentes secos do leite.');

insert into 
	testes(tipo, descricao)
values 
	('ESD', 'Concentração dos componentes do leite sem água e gordura');

insert into 
	testes(tipo, descricao)
values 
	('Crioscopia', 'Temperatura de congelamento do leite. Visa indicar fraudes pela adição de água.');

insert into 
	lote_materia_prima (data_recebimento, qtde) 
values 
	('2022-11-29', 11873);

insert into 
	lote_materia_prima(data_recebimento, qtde) 
values 
	('2022-12-1', 10534);

insert into 
	telefones(ddd, numero) 
values 
	('75', '993914300');

insert into 
	telefones(ddd, numero) 
values 
	('75', '995289083');

insert into 
	telefones(ddd, numero) 
values 
	('71', '971827832');

insert into 
	telefones(ddd, numero) 
values 
	('71', '978252705');

insert into 
	enderecos(numero, logradouro) 
values 
	('75', 'Barra, R. Orlando Marinho de Oliveira');
	
insert into 
	enderecos(numero, logradouro) 
values 
	('93', 'Barra do Vento, R. J.J. Seabra');

insert into 
	enderecos(numero, logradouro) 
values 
	('236', 'R. João José Rescala, Imbuí');

insert into 
	enderecos(numero, logradouro) 
values 
	('485', 'R. Dr. Sábino Silva, Centro');

insert into
  tipo_queijo(descricao)
values
   ('Mussarela');

insert into
   tipo_queijo(descricao)
values
   ('Coalho');

insert into
  tipo_queijo(descricao)
values
   ('Lanche');

insert into
  tipo_queijo(descricao)
values
   ('Especial');
   
-- Resultados dos testes realizados na matéria-prima
insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 74, 1, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 16, 2, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 54, 3, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 1.03, 4, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 13, 5, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', 11, 6, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-11-29', -0.523, 7, 'A', 1);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 74, 1, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 16, 2, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 54, 3, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 1.03, 4, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 13, 5, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', 11, 6, 'A', 2);

insert into 
	resultados_testes(data_teste, nota, id_teste, aprovacao, id_lote_mp) 
values 
	('2022-12-01', -0.523, 7, 'A', 2);

insert into 
	funcionarios(nome, cpf, nit, setor, id_telefone, id_endereco) 
values 
	('Reginaldo', '58543702217', '72480027501', 'PRODUCAO', 1, 1);

insert into 
	funcionarios(nome, cpf, nit, setor, id_telefone, id_endereco) 
values 
	('Maria Luciene', '64670126312', '4209179179', 'ADMINISTRACAO', 2, 2);

select * from funcionarios;
select * from lote_materia_prima;

-- Producao
insert into 
    producao(data_prod, qtde, id_lote_mp, id_funcionario) 
values 
    ('2022-12-02', 11873, 1, 1);
    
insert into 
    producao(data_prod, qtde, id_lote_mp, id_funcionario) 
values 
    ('2022-12-03', 10173, 2, 1);

-- Tipo de queijo fabricado por cada produção
insert into
	producao_tipo_queijo(id_tpq, id_producao)
values
	(3, 1);

insert into
	producao_tipo_queijo(id_tpq, id_producao)
values
	(2, 2);

insert into
	producao_tipo_queijo(id_tpq, id_prod)
values
	(4, 2);

insert into
	producao_tipo_queijo(id_tpq, id_prod)
values
	(2, 1);

-- Estoque
insert into
   estoque(qtde, lote, id_prod_tpq)
values
   (1000, 445, 1);

insert into
   estoque(qtde, lote, id_prod_tpq)
values
   (1200, 357, 2);

insert into
   estoque(qtde, lote, id_prod_tpq)
values
   (1050, 159, 1);

insert into
   estoque(qtde, lote, id_prod_tpq)
values
   (1020, 355, 2);

-- Clientes
insert into
   clientes(id_tel, id_end)
values
   (3, 4);

insert into
   clientes(id_tel, id_end)
values
   (4, 3);
   
-- Compras
insert into
	compras(data_compra, forma_pgto, id_cliente)
values
	('01/12/2022', 'Pix', 1);

insert into
	compras(data_compra, forma_pgto, id_cliente)
values
	('17/12/2022', 'Transferencia', 2);

insert into
	compras(data_compra, forma_pgto, id_cliente)
values
	('23/09/2022', 'Especie', 1);

insert into
	compras(data_compra, forma_pgto, id_cliente)
values
	('15/08/2022', 'Pix', 2);

insert into
	compras(data_compra, forma_pgto, id_cliente)
values
	('22/06/2022', 'Pix', 2);

-- Vendas
insert into
   vendas(qtde, valor, id_estoque, id_compra)
values
   (2, 80, 2, 1);

insert into
   vendas(qtde, valor, id_estoque, id_compra)
values
   (200, 8000, 3, 2);

insert into
   vendas(qtde, valor, id_estoque, id_compra)
values
   (4, 160, 4, 3);
   
insert into
   vendas(qtde, valor, id_estoque, id_compra)
values
   (375, 1600, 2, 4);

insert into
   vendas(qtde, valor, id_estoque, id_compra)
values
   (250, 1350, 1, 5);

-- Clientes pessoa física
insert into
   pessoa_fisica(nome, cpf,id_cliente)
values
   ('Bruno Sales', '46074494121', 1);
 
-- Clientes pessoa jurídica
insert into
	pessoa_juridica(razao_social, cnpj, id_cliente)
values
	('Divino Sabor', '45997418000153', 2);
