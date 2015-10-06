
package br.com.projetoperiodo.model.instituto.disciplina;

import java.util.Collection;
import java.util.Date;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.professor.Professor;

public interface Disciplina {

	String getDescricao();

	void setDescricao(String descricao);

	Collection<AlunoImpl> getPagantes();

	void setPagantes(Collection<AlunoImpl> pagantes);

	Curso getCurso();

	void setCurso(Curso curso);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

	void setUltimaAlteracao(Date ultimaAlteracao);

	Date getUltimaAlteracao();
	
	Professor getProfessor();
	
	void setProfessor(Professor professor);

}