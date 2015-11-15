
package br.com.projetoperiodo.model.negocio.controlador;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;

public abstract class ControladorNegocioImpl implements ControladorNegocio {


	public ControladorNegocioImpl() {
		
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio#criarEntidadeNegocio()
	 */
	@Override
	public abstract EntidadeNegocio criarEntidadeNegocio();
	
	@Override
	public abstract String getNomeClasseEntidade();

	public Usuario alterarSenha(Usuario usuario, String senhaAntiga, String senhaNova) {
		// TODO Auto-generated method stub
		return null;
	}

}
