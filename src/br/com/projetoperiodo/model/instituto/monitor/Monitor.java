
package br.com.projetoperiodo.model.instituto.monitor;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;

public interface Monitor extends Aluno
{

	Modalidade getModalidade();

	void setModalidade(Modalidade modalidade);

	Disciplina getDisciplina();

	void setDisciplina(Disciplina disciplina);

	RelatorioFrequencia getRelatoriosMensais(int index);

	void setRelatoriosMensais(RelatorioFrequencia relatorio);

	Periodo getPeriodo();
	
	void setPeriodo(Periodo periodo);

}