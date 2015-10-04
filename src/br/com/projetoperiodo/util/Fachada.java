
package br.com.projetoperiodo.util;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;

public class Fachada {

	private static Fachada fachada = null;
	private Fachada() { }
	public static Fachada getInstance() {

		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public Usuario criarUsuario() {
		return new UsuarioImpl();
	}
	

	
}
