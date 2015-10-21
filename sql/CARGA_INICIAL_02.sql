INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO, SENHA_EXPIRADA)
VALUES('admin', 'admin', 'f6fdffe48c908debf4c3bd36c32e72', 'emgs@a.recife.ifpe.edu.br', current_timestamp(), 0  );

INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO, SENHA_EXPIRADA)
VALUES('Douglas', 'douglas', 'f6fdffe48c908debf4c3bd36c32e72', 'das@a.recife.ifpe.edu.br', current_timestamp(), 0  );

INSERT INTO PROJETO_PERIODO.USUARIO (USUARIO_NOME, USUARIO_LOGIN, USUARIO_SENHA, USUARIO_EMAIL, ULTIMA_ALTERACAO, SENHA_EXPIRADA)
VALUES('Laura', 'laura', 'f6fdffe48c908debf4c3bd36c32e72', 'lrmo@a.recife.ifpe.edu.br', current_timestamp(), 0  );


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
         
INSERT INTO PROJETO_PERIODO.PROFESSOR (PROFESSOR_ID, PROFESSOR_SIAPE)
VALUES( (SELECT USUARIO_ID FROM USUARIO WHERE USUARIO_NOME LIKE 'Douglas'), '1428475');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Padrões de Projeto',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_SIAPE LIKE '1428475'),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Padrões de Projeto');

INSERT INTO PROJETO_PERIODO.DISCIPLINA (DISCIPLINA_DS, PROFESSOR_ID, CURSO_ID)
SELECT 'Desenvolvimento Web 2',
(SELECT PROFESSOR_ID FROM PROFESSOR WHERE PROFESSOR_SIAPE LIKE '1428475'),
(SELECT CURSO_ID FROM CURSO WHERE CURSO_DS LIKE 'Análise de Sistemas') 
FROM DUAL
WHERE NOT EXISTS (SELECT * FROM DISCIPLINA
WHERE DISCIPLINA_DS = 'Desenvolvimento Web 2');

INSERT INTO PROJETO_PERIODO.DISCIPLINA_ALUNO 
VALUES ( (SELECT ALUNO_ID FROM ALUNO
          WHERE ALUNO_MATRICULA LIKE'20141Y6-RC0323' ),
		 ( SELECT DISCIPLINA_ID FROM DISCIPLINA
		   WHERE DISCIPLINA_DS LIKE 'Padrões de Projeto'), current_timestamp() );
		   

INSERT INTO PROJETO_PERIODO.MONITOR (MONITOR_ID, MODALIDADE, PERIODO_ID, DISCIPLINA_ID, HABILITADO)
VALUES( (SELECT DS.ALUNO_ID FROM DISCIPLINA_ALUNO AS DS, ALUNO AS A 
        WHERE A.ALUNO_MATRICULA LIKE '20141Y6-RC0323' ), 
       'BOLSISTA', 
       (SELECT PERIODO_ID FROM PERIODO
       WHERE PERIODO_ANO = 2015 AND SEMESTRE LIKE 'SEGUNDO'),
      (SELECT DA.DISCIPLINA_ID FROM DISCIPLINA_ALUNO AS DA, DISCIPLINA AS D
       WHERE D.DISCIPLINA_DS LIKE 'Padrões de Projeto') , true);
 INSERT INTO PROJETO_PERIODO.ATIVIDADE 
 
