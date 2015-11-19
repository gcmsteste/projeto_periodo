
package br.com.projetoperiodo.model.negocio.controlador;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();

	String getNomeClasseEntidade();

	Usuario alterarSenha(Usuario usuario, String senhaAntiga, String novaSenha);

	
}