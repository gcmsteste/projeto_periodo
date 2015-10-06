
package br.com.projetoperiodo.model.instituto.curso;

import java.util.Collection;
import java.util.Date;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;

public interface Curso {

	Collection<DisciplinaImpl> getDisciplinas();

	void setDisciplinas(Collection<DisciplinaImpl> disciplinas);

	String getDescricao();

	void setDescricao(String descricao);

	Collection<AlunoImpl> getAlunos();

	void setAlunos(Collection<AlunoImpl> alunos);

	Grau getModalidade();

	void setModalidade(Grau modalidade);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

}