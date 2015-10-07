
package br.com.projetoperiodo.model.instituto.professor;

import org.junit.Assert;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.professor.dao.ProfessorDao;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;

public class TesteProfessorDao {

	

	private ProfessorDao dao = CreatorFabrica.
					createFactory(CreatorFabrica.FABRICA_JPA).criarProfessorDao();

	

	private Professor montarObjetoProfessor() {
		 Professor professor = new ProfessorImpl();
		 professor.setNome("Roberto");
		 return professor;
		
	 }

}
