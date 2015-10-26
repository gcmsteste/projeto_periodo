
package br.com.projetoperiodo.model.relatorio.atividade.controller;

import java.util.List;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface ControladorAtividade extends ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();

	void cadastrarAtividadesComSemanaDeRelatorio(Semana semana);

	List<Atividade> buscarAtividadeDeSemana(Semana semana);

	void removerAtividade(Atividade atividade);

}