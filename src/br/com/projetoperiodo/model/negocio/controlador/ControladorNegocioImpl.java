
package br.com.projetoperiodo.model.negocio.controlador;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;
import br.com.projetoperiodo.util.persistencia.dao.FabricaDAO;

public abstract class ControladorNegocioImpl implements ControladorNegocio {

	protected FabricaDAO fabrica;

	public ControladorNegocioImpl() {
		fabrica = CreatorFabrica.createFactory(CreatorFabrica.FABRICA_JPA);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio#criarEntidadeNegocio()
	 */
	@Override
	public abstract EntidadeNegocio criarEntidadeNegocio();
	
	

}
