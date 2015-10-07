
package br.com.projetoperiodo.util;

import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.controller.impl.ControladorUsuarioImpl;

public class Fachada {

	private static Fachada fachada = null;
	private Fachada() { }
	public static Fachada getInstance() {

		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public ControladorUsuario getControladorUsuario() {
		return new ControladorUsuarioImpl();
	}
	

	
}
