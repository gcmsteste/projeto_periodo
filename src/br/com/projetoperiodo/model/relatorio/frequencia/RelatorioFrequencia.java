package br.com.projetoperiodo.model.relatorio.frequencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import br.com.projetoperiodo.model.instituto.funcionario.Funcionario;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.orientador.Orientador;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
@Entity
@Table(name = "RELATORIO_FREQUENCIA")
public class RelatorioFrequencia {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column( name = "RELATORIO_ID")
	private int id;
	@Column( name = "RELATORIO_MES", nullable = false)
	private int mes;
	@Column( name = "RELATORIO_ANO", nullable = false)
	private int ano;
	@Column( name = "RELATORIO_CARGA_HORARIA", nullable = false)
	private int cargaHorariaMensal;
	@Column( name = "RELATORIO_EDITAL", nullable = false)
	private String edital;
	@ManyToOne( fetch = FetchType.LAZY, optional = true)
	@JoinColumn( name = "MONITOR_ID", referencedColumnName = "MONITOR_ID")
	private Monitor monitor;
	@Column( name = "DATA_ENTREGA", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataEntregaRelatorio;
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "ORIENTADOR_ID", referencedColumnName = "ORIENTADOR_ID")
	private Orientador orientador;
	@ManyToOne( fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "FUNCIONARIO_ID", referencedColumnName = "FUNCIONARIO_ID")
	private Funcionario funcionario;
	@OneToMany(mappedBy="relatorio",
			   cascade = CascadeType.ALL,
			   fetch = FetchType.EAGER)
	private List<Semana> semanas;
	
	public RelatorioFrequencia() {
		semanas = new ArrayList<Semana>();
	}
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
	public Semana getSemanas(int index) {

		return semanas.get(index);
	}
	public void setSemanas(Semana semana) {

		this.semanas.add(semana);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
