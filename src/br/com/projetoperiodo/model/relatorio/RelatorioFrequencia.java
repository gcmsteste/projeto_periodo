package br.com.projetoperiodo.model.relatorio;

import java.util.Collection;
import java.util.Date;

import br.com.projetoperiodo.model.instituto.aluno.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.funcionario.Funcionario;
import br.com.projetoperiodo.model.instituto.orientador.Orientador;

public class RelatorioFrequencia {
	
	private int chavePrimaria;
	private int mes;
	private int ano;
	private int cargaHorariaMensal;
	private String edital;
	private Monitor monitor;
	private Date dataEntregaRelatorio;
	private Orientador orientador;
	private Funcionario funcionario;
	private Collection<Semana> semanas;
	
	public int getMes() {

		return mes;
	}
	public void setMes(int mes) {

		this.mes = mes;
	}
	public int getAno() {

		return ano;
	}
	public void setAno(int ano) {

		this.ano = ano;
	}
	public int getCargaHorariaMensal() {

		return cargaHorariaMensal;
	}
	public void setCargaHorariaMensal(int cargaHorariaMensal) {

		this.cargaHorariaMensal = cargaHorariaMensal;
	}
	public String getEdital() {

		return edital;
	}
	public void setEdital(String edital) {

		this.edital = edital;
	}
	
	public Orientador getOrientador() {

		return orientador;
	}
	public void setOrientador(Orientador orientador) {

		this.orientador = orientador;
	}
	
	public Monitor getMonitor() {

		return monitor;
	}
	public void setMonitor(Monitor monitor) {

		this.monitor = monitor;
	}
	public Date getDataEntregaRelatorio() {

		return dataEntregaRelatorio;
	}
	public void setDataEntregaRelatorio(Date dataEntregaRelatorio) {

		this.dataEntregaRelatorio = dataEntregaRelatorio;
	}
	public Funcionario getFuncionario() {

		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {

		this.funcionario = funcionario;
	}
	public Collection<Semana> getSemanas() {

		return semanas;
	}
	public void setSemanas(Collection<Semana> semanas) {

		this.semanas = semanas;
	}
	public int getChavePrimaria() {

		return chavePrimaria;
	}
	public void setChavePrimaria(int chavePrimaria) {

		this.chavePrimaria = chavePrimaria;
	}
}
