
package br.com.projetoperiodo.model.relatorio.frequencia;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface RelatorioFrequencia extends EntidadeNegocio
{
	final int QUANTIDADE_SEMANAS_POR_RELATORIO = 5;
	
	int getMes();

	void setMes(int mes);

	int getCargaHorariaMensal();

	void setCargaHorariaMensal(int cargaHorariaMensal);

	Monitor getMonitor();

	void setMonitor(Monitor monitor);

	Semana getSemanas(int index);

	void setSemanas(Semana semana);
	
	void setProfessor(Professor professor);
	
	Professor getProfessor();

}