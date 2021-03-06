INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_SOBRENOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO)
VALUES('admin', 'admin', 'admin', 'f6fdffe48c908debf4c3bd36c32e72', 'emgs@a.recife.ifpe.edu.br', current_timestamp());

INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_SOBRENOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO)
VALUES('Renata', 'Freire', 'renata', 'f6fdffe48c908debf4c3bd36c32e72', 'renatafreire@recife.ifpe.edu.br', current_timestamp());

INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_SOBRENOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO)
VALUES('Ramide', 'Dantas', 'ramide', 'f6fdffe48c908debf4c3bd36c32e72', 'ramidedantas@recife.ifpe.edu.br', current_timestamp());


INSERT INTO PROJETO_PERIODO.PERIODO (PERIODO_ANO, SEMESTRE)
VALUES (2015, 'SEGUNDO');

INSERT INTO PROJETO_PERIODO.CURSO (GRAU, CURSO_DS)
VALUES ('SUPERIOR', 'Análise de Sistemas');

INSERT INTO PROJETO_PERIODO.ALUNO (ALUNO_ID, ALUNO_MATRICULA, CURSO_ID)
VALUES( (SELECT USUARIO_ID  FROM USUARIO
        WHERE USUARIO_LOGIN LIKE 'admin'), 
        '20141Y6-RC0323', 
        (SELECT CURSO_ID FROM CURSO
         WHERE CURSO_DS LIKE 'Análise de Sistemas') );
         
INSERT INTO PROJETO_PERIODO.PROFESSOR (PROFESSOR_ID)
VALUES( (SELECT USUARIO_ID FROM USUARIO WHERE USUARIO_NOME LIKE 'Ramide'));

INSERT INTO PROJETO_PERIODO.PROFESSOR (PROFESSOR_ID)
VALUES( (SELECT USUARIO_ID FROM USUARIO WHERE USUARIO_NOME LIKE 'Renata'));

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Padrões de Projeto',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 2),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Padrões de Projeto');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Desenvolvimento Web 2',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 3),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Desenvolvimento Web 2');

INSERT INTO PROJETO_PERIODO.DISCIPLINA_ALUNO 
VALUES ( (SELECT ALUNO_ID FROM ALUNO
          WHERE ALUNO_MATRICULA LIKE'20141Y6-RC0323' ),
		 ( SELECT DISCIPLINA_ID FROM DISCIPLINA
		   WHERE DISCIPLINA_DS LIKE 'Padrões de Projeto'), current_timestamp() );
		   
		
INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_SOBRENOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO)
VALUES('Marco', 'Domingues', 'Marco', 'f6fdffe48c908debf4c3bd36c32e72', 'Marco@recife.ifpe.edu.br', current_timestamp());


INSERT INTO PROJETO_PERIODO.PROFESSOR (PROFESSOR_ID)
VALUES( (SELECT USUARIO_ID FROM USUARIO WHERE USUARIO_NOME LIKE 'Marco'));

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Engenharia de Requisitos',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 2),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Engenharia de Requisitos');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Redes de Computadores',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 3),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Redes de Computadores');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Sistemas Operacionais',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 4),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Sistemas Operacionais');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Sistemas Distribuidos',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_ID = 4),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Sistemas Distribuidos');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, CURSO_ID)
SELECT 'Introdução à Programação',
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Introdução à Programação');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, CURSO_ID)
SELECT 'Engenharia de Software',
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Engenharia de Software');