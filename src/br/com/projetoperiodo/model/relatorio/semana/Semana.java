
package br.com.projetoperiodo.model.relatorio.semana;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface Semana extends EntidadeNegocio
{
	
	String getDescricao();

	String getObservacoes();

	void setDescricao(String descricao);

	void setObservacoes(String observacoes);

	Atividade getAtividade(int index);

	void setAtividades(Atividade atividade);

	RelatorioFrequencia getRelatorio();

	void setRelatorio(RelatorioFrequencia relatorio);


}