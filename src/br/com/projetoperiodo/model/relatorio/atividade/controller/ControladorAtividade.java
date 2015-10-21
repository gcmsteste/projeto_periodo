
package br.com.projetoperiodo.model.relatorio.atividade.controller;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface ControladorAtividade extends ControladorNegocio
{

	EntidadeNegocio criarEntidadeNegocio();
	
	Semana preCadastrarSemanaAtividade(Semana semana);

}