package br.com.projetoperiodo.model.instituto.periodo.controller;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorPeriodo extends ControladorNegocio
{

	EntidadeNegocio criarEntidadeNegocio();

	Periodo gerarNovoPeriodoCorrente();
	
	Periodo cadastrarPeriodo(Periodo periodo);
	
	Periodo buscarPeriodo(int ano, Semestre semestre) throws NegocioException;

}