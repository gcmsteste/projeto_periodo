package br.com.projetoperiodo.model.instituto.aluno;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface Aluno extends Usuario
{
	final String PAPEL_ALUNO = "ALUNO";
	
	String getMatricula();

	void setMatricula(String matricula);

	Curso getCurso();

	void setCurso(Curso curso);

	Disciplina getDisciplinas(int index);

	void setDisciplinas(Disciplina disciplina);

}