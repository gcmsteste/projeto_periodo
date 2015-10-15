package br.com.projetoperiodo.model.instituto.periodo.controller;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface ControladorPeriodo extends ControladorNegocio
{

	EntidadeNegocio criarEntidadeNegocio();

	Periodo gerarNovoPeriodoCorrente();

}