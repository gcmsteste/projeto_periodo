
package br.com.projetoperiodo.model.instituto.disciplina;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface Disciplina extends EntidadeNegocio {

	final String ATRIBUTO_DESCRICAO = "descricao";
	
	String getDescricao();

	void setDescricao(String descricao);

	Aluno getPagantes(int index);

	void setPagantes(Aluno aluno);

	Curso getCurso();

	void setCurso(Curso curso);

	Professor getProfessor();

	void setProfessor(Professor professor);

}