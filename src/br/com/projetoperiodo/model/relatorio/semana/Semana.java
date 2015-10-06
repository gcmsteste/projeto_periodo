
package br.com.projetoperiodo.model.relatorio.semana;

import java.util.Collection;
import java.util.Date;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface Semana {

	String getDescricao();

	String getObservacoes();

	void setDescricao(String descricao);

	void setObservacoes(String observacoes);

	Atividade getAtividades(int index);

	Collection<AtividadeImpl> getAtividades();

	void setAtividades(AtividadeImpl atividade);

	RelatorioFrequencia getRelatorio();

	void setRelatorio(RelatorioFrequencia relatorio);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

}