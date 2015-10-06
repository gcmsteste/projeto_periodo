
package br.com.projetoperiodo.model.relatorio.frequencia;

import java.util.Date;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface RelatorioFrequencia {

	int getMes();

	void setMes(int mes);

	int getAno();

	void setAno(int ano);

	int getCargaHorariaMensal();

	void setCargaHorariaMensal(int cargaHorariaMensal);

	String getEdital();

	void setEdital(String edital);

	Professor getOrientador();

	void setOrientador(Professor professor);

	Monitor getMonitor();

	void setMonitor(MonitorImpl monitor);

	Date getDataEntregaRelatorio();

	void setDataEntregaRelatorio(Date dataEntregaRelatorio);

	Semana getSemanas(int index);

	void setSemanas(Semana semana);
	
	void setProfessor(Professor professor);
	
	Professor getProfessor();

	long getChavePrimaria();

	void setChavePrimaria(long chavePrimaria);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

}