package br.com.projetoperiodo.model.instituto.aluno;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;

public interface Aluno {

	String getMatricula();

	void setMatricula(String matricula);

	Curso getCurso();

	void setCurso(Curso curso);

	Disciplina getDisciplinas(int index);

	void setDisciplinas(DisciplinaImpl disciplina);

}