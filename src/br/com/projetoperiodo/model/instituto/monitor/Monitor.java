
package br.com.projetoperiodo.model.instituto.monitor;

import java.util.Collection;
import java.util.Date;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;

public interface Monitor {

	Modalidade getModalidade();

	void setModalidade(Modalidade modalidade);

	Disciplina getDisciplina();

	void setDisciplina(Disciplina disciplina);

	RelatorioFrequencia getRelatoriosMensais(int index);

	void setRelatoriosMensais(RelatorioFrequencia relatorio);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

}