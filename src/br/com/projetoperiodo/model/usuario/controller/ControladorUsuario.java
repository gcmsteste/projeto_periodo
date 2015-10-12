package br.com.projetoperiodo.model.usuario.controller;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorUsuario extends ControladorNegocio
{
	
	final String EMAIL_NAO_CADASTRADO = "EMAIL_NAO_CADASTRADO";
	
	Usuario autenticarUsuario(Usuario usuario) throws NegocioException; 
	
	void envioEmailSenha(Usuario usuario) throws NegocioException;
	
	void alterarSenhaUsuario(Usuario usuario) throws NegocioException;
	
	boolean validarLogon(Usuario usuario);
	
	Usuario cadastrarUsuario(Usuario usuario);
}
