package br.com.projetoperiodo.model.relatorio.atividade.controller.impl;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.controller.ControladorAtividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public class ControladorAtividadeImpl extends ControladorNegocioImpl implements ControladorAtividade
{

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.controller.ControladorAtividade#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new AtividadeImpl();
	}

	@Override
	public Semana preCadastrarSemanaAtividade(Semana semana) {

		for ( int i = 0; i < Semana.QUANTIDADE_ATIVIDADES_POR_SEMANA; i++ ) {
			semana.setAtividades((Atividade)this.criarEntidadeNegocio());
		}
		return semana;
	}

}
