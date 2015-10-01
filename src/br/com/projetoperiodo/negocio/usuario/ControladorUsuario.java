package br.com.projetoperiodo.negocio.usuario;

import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorUsuario {
	
	public Usuario autenticarUsuario(Usuario usuario) throws NegocioException; 
	
}
