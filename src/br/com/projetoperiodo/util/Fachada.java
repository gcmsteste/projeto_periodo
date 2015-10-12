
package br.com.projetoperiodo.util;

import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.impl.ControladorAlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.impl.ControladorDisciplinaImpl;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.impl.ControladorMonitorImpl;
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
	
	public ControladorMonitor getControladorMonitor() {
		return new ControladorMonitorImpl();
	}
	
	public ControladorAluno getControladorAluno() {
		return new ControladorAlunoImpl();
	}
	
	public ControladorDisciplina getControladorDisciplina() {
		return new ControladorDisciplinaImpl();
	}
	

	
}
