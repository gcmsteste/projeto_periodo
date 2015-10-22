
package br.com.projetoperiodo.model.instituto.monitor.controller;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;

public interface ControladorMonitor extends ControladorNegocio
{
	final String MONITORIA_CADASTRADA = "MONITORIA_CADASTRADA";
	
	Monitor criarMonitoriaDeAluno(Aluno aluno, Disciplina disciplina, Modalidade modalidade);
	
	List<Monitor> buscarMonitoriasDeAluno(Aluno aluno);
	
	boolean validarCadastroMonitoria(Monitor monitor);
	
	Monitor cadastrarMonitoria(Monitor monitor);
}