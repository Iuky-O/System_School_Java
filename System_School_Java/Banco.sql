-----------------------------------
--	  IUMY PIMENTEL FARIAS       --
--    BES2022  / TARDE           --
-----------------------------------


-----------------------------
--	  BANCO DE DADOS       --
-----------------------------


CREATE DATABASE JAVA_DATABASE


-----------------------------
--		 TABELAS		   --
-----------------------------


CREATE TABLE CADASTROS(
	id int identity(1,1),
	nome varchar (60) NOT NULL,
	endereco varchar (60) NOT NULL,
	sexo char(1),
	telefone char(15),
	num_cpf char(14),
	tipo_sangue char(2),
	fator_rh char (1),
	curso varchar(30),
	nome_emerg varchar(60),
	tel_emerg char (15)
)
------------------------------
CREATE TABLE LOGIN(
	id_L int PRIMARY KEY identity(1,1),
	email varchar(60) NOT NULL,
	senha varchar(60) NOT NULL
)



---------------------------------
--	  INSERÇÕES/SELEÇÕES       --
---------------------------------


INSERT INTO CADASTROS (nome, endereco, sexo, telefone, num_cpf, tipo_sangue, fator_rh, curso, nome_emerg, tel_emerg) VALUES ('Iumy', 'Tauá', 'F', '111111', '123.123.123-22', 'O', '+', 'eng. software', 'mamãe', '000000000000000');

INSERT INTO LOGIN (email, senha) VALUES ('Iumy', '123');



SELECT * FROM CADASTROS

SELECT * FROM LOGIN


--DROP TABLE CADASTROS
--DROP TABLE LOGIN

