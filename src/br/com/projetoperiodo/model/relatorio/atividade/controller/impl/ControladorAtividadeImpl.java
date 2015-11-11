package br.com.projetoperiodo.model.relatorio.atividade.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.controller.ControladorAtividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;

public class ControladorAtividadeImpl extends ControladorNegocioImpl implements ControladorAtividade
{
	
	
	
	public ControladorAtividadeImpl() {
		
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.controller.ControladorAtividade#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new AtividadeImpl();
	}

	@Override
	public void cadastrarAtividadesComSemanaDeRelatorio(Semana semana) {

		Atividade atividade;
		for ( int i = 0; i < Semana.QUANTIDADE_ATIVIDADES_POR_SEMANA; i++ ) {
			atividade = (Atividade)this.criarEntidadeNegocio();
			atividade.setSemana(semana);
			CreatorFabrica.getFabricaDAO().criarAtividadeDAO().salvar(atividade);
		
		}
	}
	
	@Override
	public List<Atividade> buscarAtividadeDeSemana(Semana semana) {

		StringBuilder builder = new StringBuilder();
		builder.append(" from ");
		builder.append( this.getNomeClasseEntidade() );
		builder.append(" a ");
		builder.append(" where a.semana.chavePrimaria = ");
		builder.append(semana.getChavePrimaria());
		return 	CreatorFabrica.getFabricaDAO().criarAtividadeDAO().listar(builder.toString());
	}
	@Override
	public void removerAtividade(Atividade atividade) {
		CreatorFabrica.getFabricaDAO().criarAtividadeDAO().remover(atividade);
	}

	@Override
	public String getNomeClasseEntidade() {
		
		return AtividadeImpl.class.getSimpleName();
	}
}
