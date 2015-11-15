package br.com.projetoperiodo.model.instituto.professor.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.instituto.professor.controller.ControladorProfessor;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;

public class ControladorProfessorImpl extends ControladorNegocioImpl implements ControladorProfessor{

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.controller.ControladorProfessor#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new ProfessorImpl();
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.controller.ControladorProfessor#getNomeClasseEntidade()
	 */
	@Override
	public String getNomeClasseEntidade() {

		return ProfessorImpl.class.getSimpleName();
	}
	
	@Override
	public boolean verificarPapelDeProfessorDoUsuario(Usuario usuario) {
		boolean isProfessor = Boolean.TRUE;
		StringBuilder builder = new StringBuilder();
		builder.append(" select count(*) ");
		builder.append(" from ");
		builder.append(this.getNomeClasseEntidade());
		builder.append(" a ");
		builder.append(" where a.chavePrimaria = ");
		builder.append(usuario.getChavePrimaria());
		List<Professor> lista = CreatorFabrica.getFabricaDAO().criarProfessorDao().listar(builder.toString());
		if ( lista.isEmpty() ) {
			isProfessor = Boolean.FALSE;
		}
		return isProfessor;
	}

}
