package br.com.projetoperiodo.model.instituto.curso.controller.impl;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.controller.ControladorCurso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.fachada.Persistencia;

public class ControladorCursoImpl extends ControladorNegocioImpl implements ControladorCurso
{
	
	
	public ControladorCursoImpl() {
	
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.controller.ControladorCurso#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new CursoImpl();
	}

	@Override
	public Curso buscarCursoPadrao() {

		return (Curso) Persistencia.getInstance().buscarCurso(1L);
	}
	@Override
	public String getNomeClasseEntidade() {
		
		return CursoImpl.class.getSimpleName();
	}

}
