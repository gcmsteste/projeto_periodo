
package br.com.projetoperiodo.model.relatorio.semana;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface Semana extends EntidadeNegocio
{

	final int QUANTIDADE_ATIVIDADES_POR_SEMANA = 5;
	
	String getDescricao();

	String getObservacoes();

	void setDescricao(String descricao);

	void setObservacoes(String observacoes);

	Atividade getAtividades(int index);

	void setAtividades(Atividade atividade);

	RelatorioFrequencia getRelatorio();

	void setRelatorio(RelatorioFrequencia relatorio);

}