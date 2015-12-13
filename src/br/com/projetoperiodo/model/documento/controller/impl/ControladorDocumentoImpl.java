package br.com.projetoperiodo.model.documento.controller.impl;

import br.com.projetoperiodo.model.documento.controller.ControladorDocumento;
import br.com.projetoperiodo.model.documento.impl.DocumentoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public class ControladorDocumentoImpl extends ControladorNegocioImpl implements ControladorDocumento {

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.controller.ControladorDocumento#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new DocumentoImpl();
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.controller.ControladorDocumento#getNomeClasseEntidade()
	 */
	@Override
	public String getNomeClasseEntidade() {
		return DocumentoImpl.class.getSimpleName();
	}

}
