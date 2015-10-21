package br.com.projetoperiodo.model.relatorio.semana.controller.impl;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.controller.ControladorAtividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.controller.ControladorSemana;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.Fachada;

public class ControladorSemanaImpl extends ControladorNegocioImpl implements ControladorSemana{

	private SemanaDao dao;
	
	public ControladorSemanaImpl() {
		dao = fabrica.criarSemanaDAO();
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.controller.ControladorSemana#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {
		return new SemanaImpl();
	}
	
	@Override
	public RelatorioFrequencia preCadastrarSemanaDeRelatorio(RelatorioFrequencia relatorio) {

		ControladorAtividade controladorAtividade = Fachada.getInstance().getControladorAtividade();
		for ( int i = 0; i < RelatorioFrequencia.QUANTIDADE_SEMANAS_POR_RELATORIO; i++) {
			Semana semana = (Semana)this.criarEntidadeNegocio();
			semana = controladorAtividade.preCadastrarSemanaAtividade(semana);
			relatorio.setSemanas(semana);
		}
		return relatorio;
	}

}
