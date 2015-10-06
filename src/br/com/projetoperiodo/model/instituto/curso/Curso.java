
package br.com.projetoperiodo.model.instituto.curso;

import java.util.Date;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;

public interface Curso {

	Disciplina getDisciplinas(int index);

	void setDisciplinas(Disciplina disciplina);

	String getDescricao();

	void setDescricao(String descricao);

	Aluno getAlunos(int index);

	void setAlunos(Aluno aluno);

	Grau getModalidade();

	void setModalidade(Grau modalidade);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

}