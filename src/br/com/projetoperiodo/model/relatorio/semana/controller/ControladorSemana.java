
package br.com.projetoperiodo.model.relatorio.semana.controller;

import java.util.List;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface ControladorSemana extends ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();

	void cadastrarSemanasComRelatorio(RelatorioFrequencia relatorio);

	List<Semana> buscarSemanasDeRelatorio(RelatorioFrequencia relatorio);


	void removerSemana(Semana semana);

}