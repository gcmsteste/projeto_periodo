package br.com.projetoperiodo.model.instituto.professor;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;

public interface Professor {

	String getNome();

	void setNome(String nome);

	String getSiape();

	void setSiape(String siape);

	Disciplina getDisciplina(int index);

	void setDisciplina(Disciplina disciplina);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

}