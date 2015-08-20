package model;

import java.util.Date;

public class RelatorioFrequencia {
	private int mes;
	private int ano;
	private int cargaHorariaMensal;
	private String edital;
	private Monitor monitor;
	private Date dataEntregaRelatorio;
	private Orientador orientador;
	private Funcionario funcionario;
	
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
}
