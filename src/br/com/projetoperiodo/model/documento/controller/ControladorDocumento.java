
package br.com.projetoperiodo.model.documento.controller;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface ControladorDocumento {

	EntidadeNegocio criarEntidadeNegocio();

	String getNomeClasseEntidade();

}