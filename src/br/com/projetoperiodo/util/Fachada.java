
package br.com.projetoperiodo.util;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.impl.ControladorAlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.impl.ControladorDisciplinaImpl;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.impl.ControladorMonitorImpl;
import br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo;
import br.com.projetoperiodo.model.instituto.periodo.controller.impl.ControladorPeriodoImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.controller.ControladorRelatorio;
import br.com.projetoperiodo.model.relatorio.frequencia.controller.impl.ControladorRelatorioImpl;
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
	
	public ControladorPeriodo getControladorPeriodo() {
		return new ControladorPeriodoImpl();
	}
	
	public ControladorRelatorio getControladorRelatorio() {
		return new ControladorRelatorioImpl();
	}
	public List<RelatorioFrequencia> buscarRelatorios(long chavePrimaria){
		Monitor monitor = (Monitor) this.getControladorMonitor().criarEntidadeNegocio();
		monitor.setChavePrimaria(chavePrimaria);
		ControladorRelatorio controladorRelatorio = this.getControladorRelatorio();
		return controladorRelatorio.buscarRelatoriosDeMonitor(monitor);
	}
	
	public RelatorioFrequencia buscarDetalhamentoRelatorio(long chavePrimaria) {
		return null;
	}
	
	public void preCadastroRelatoriosMonitor(Monitor monitor) {
		ControladorRelatorio controladorRelatorio = this.getControladorRelatorio();
	}
	

	
}
