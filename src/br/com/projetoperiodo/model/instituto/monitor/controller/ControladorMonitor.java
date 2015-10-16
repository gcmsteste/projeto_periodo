
package br.com.projetoperiodo.model.instituto.monitor.controller;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorMonitor extends ControladorNegocio
{
	final String MONITORIA_CADASTRADA = "MONITORIA_CADASTRADA";
	
	Monitor criarMonitoriaDeAluno(Aluno aluno, Disciplina disciplina, Modalidade modalidade);
	
	Monitor buscarMonitoriasDeAluno(Aluno aluno) throws NegocioException;
	
	boolean validarCadastroMonitoria(Monitor monitor);
	
	Monitor cadastrarMonitoria(Monitor monitor);
}