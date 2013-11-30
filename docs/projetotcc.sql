CREATE DATABASE projetotcc;
USE projetotcc;

#drop database projetotcc;


CREATE TABLE produto(
idproduto INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(15) NOT NULL, 
estoque INT NOT NULL,
preco DOUBLE NOT NULL,

PRIMARY KEY(idproduto)
);

CREATE TABLE vendedor(
idvendedor INT NOT NULL AUTO_INCREMENT,
senha VARCHAR(15) NOT NULL,
login VARCHAR(10)NOT NULL,
nome VARCHAR(20),

PRIMARY KEY(idvendedor)
);

CREATE TABLE venda(
idvenda INT NOT NULL AUTO_INCREMENT,
idvendedor INT NOT NULL,
datacompra VARCHAR(20) NOT NULL,
numerofiscal INT NOT NULL,

PRIMARY KEY(idvenda),
FOREIGN KEY(idvendedor) REFERENCES vendedor(idvendedor) ON DELETE CASCADE
);

CREATE TABLE relvendaproduto(
idrelavendprod INT NOT NULL AUTO_INCREMENT,
idproduto INT NOT NULL,
idvenda INT NOT NULL,
quantidade INT NOT NULL,

PRIMARY KEY(idrelavendprod),
FOREIGN KEY(idproduto) REFERENCES produto(idproduto) ON DELETE CASCADE,
FOREIGN KEY(idvenda) REFERENCES venda(idvenda) ON DELETE CASCADE
);

INSERT INTO produto(nome,estoque,preco)
VALUES('Porca',30,2.10);
INSERT INTO produto(nome, estoque, preco)
VALUES('Pneu',50,500);
INSERT INTO produto(nome,estoque, preco)
VALUES('Para-choque',20,100);

INSERT INTO vendedor(nome,login,senha)
VALUES('Robinho','robboy','çobinha');
INSERT INTO vendedor(nome,login,senha)
VALUES('Junior','dono','ochefe');
INSERT INTO vendedor(nome,login,senha)
VALUES('Vendedor1','vendedor1','12345');

INSERT INTO venda(idvenda,idvendedor, datacompra, numerofiscal)
VALUES(1,1,'20/12/1999 10:0:20', '0001');

INSERT INTO venda(idvenda,idvendedor, datacompra, numerofiscal)
VALUES(2,2,'20/12/1900 10:00:20', '0002');

INSERT INTO venda(idvenda,idvendedor, datacompra, numerofiscal)
VALUES(3,3,'20/12/1900 10:00:20', '0003');

INSERT INTO relvendaproduto (idrelavendprod,idproduto, idvenda,quantidade)
VALUES(1,1,1,'10');

INSERT INTO relvendaproduto (idrelavendprod,idproduto, idvenda,quantidade)
VALUES(2,2,1,'15');

INSERT INTO relvendaproduto (idrelavendprod,idproduto, idvenda,quantidade)
VALUES(3,3,2,'5');

select* from venda;
select* from produto;
select* from vendedor;
SELECT* FROM relvendaproduto;