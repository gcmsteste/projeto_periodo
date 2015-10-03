package br.com.projetoperiodo.model.usuario.controller;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorUsuario {
	
	public Usuario autenticarUsuario(Usuario usuario) throws NegocioException; 
	
}
