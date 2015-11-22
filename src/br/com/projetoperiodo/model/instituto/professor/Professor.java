
package br.com.projetoperiodo.model.instituto.professor;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface Professor extends Usuario {

	final String PAPEL_PROFESSOR = "PROFESSOR";
	
	Disciplina getDisciplina(int index);

	void setDisciplina(Disciplina disciplina);

}