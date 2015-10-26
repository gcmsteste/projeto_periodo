package br.com.projetoperiodo.model.relatorio.semana.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
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
	public void cadastrarSemanasComRelatorio(RelatorioFrequencia relatorio) {

		ControladorAtividade controladorAtividade = Fachada.getInstance().getControladorAtividade();
		for ( int i = 0; i < RelatorioFrequencia.QUANTIDADE_SEMANAS_POR_RELATORIO; i++) {
			Semana semana = (Semana)this.criarEntidadeNegocio();
			semana.setRelatorio(relatorio);
			dao.salvar(semana);
			controladorAtividade.cadastrarAtividadesComSemanaDeRelatorio(semana);
			
		}
	}
	@Override
	public List<Semana> buscarSemanasDeRelatorio(RelatorioFrequencia relatorio) {

		StringBuilder builder = new StringBuilder();
		builder.append(" from SemanaImpl s ");
		builder.append(" where s.relatorio.chavePrimaria = ");
		builder.append(relatorio.getChavePrimaria());
		return dao.listar(builder.toString());
	}
	@Override
	public void removerSemana(Semana semana) {
		dao.remover(semana);
	}
	

}
