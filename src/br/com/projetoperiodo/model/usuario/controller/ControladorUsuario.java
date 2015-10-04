package br.com.projetoperiodo.model.usuario.controller;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorUsuario {
	
	Usuario autenticarUsuario(Usuario usuario) throws NegocioException; 
	
	void envioEmailSenha(Usuario usuario) throws NegocioException;
	
	void alterarSenhaUsuario(Usuario usuario);
	
	void validarLogon(Usuario usuario);
}
