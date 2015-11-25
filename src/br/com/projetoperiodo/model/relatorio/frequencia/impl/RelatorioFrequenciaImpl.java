
package br.com.projetoperiodo.model.relatorio.frequencia.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;

@Entity
@Table(name = "RELATORIO_FREQUENCIA")
@AttributeOverrides({@AttributeOverride(name = "chavePrimaria", column = @Column(name = "RELATORIO_ID") )})
public class RelatorioFrequenciaImpl extends EntidadeNegocioImpl implements RelatorioFrequencia {

	@Column(name = "RELATORIO_MES", nullable = false)
	private int mes;

	@Column(name = "RELATORIO_CARGA_HORARIA", nullable = false)
	private int cargaHorariaMensal;

	@ManyToOne(fetch = FetchType.EAGER, optional = true, targetEntity = MonitorImpl.class)
	@JoinColumn(name = "MONITOR_ID", referencedColumnName = "MONITOR_ID")
	private Monitor monitor;

	@Enumerated(EnumType.STRING)
	@Column(name = "SITUACAO_RELATORIO", columnDefinition = "ENUM('ESPERA', 'APROVADO')")
	private Situacao situacao;
	
	@OneToMany(mappedBy = "relatorio", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SemanaImpl.class)
	private List<Semana> semanas;

	
	public RelatorioFrequenciaImpl() {
		semanas = new ArrayList<Semana>();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#getMes()
	 */
	public int getMes() {

		return mes;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#setMes(int)
	 */
	public void setMes(int mes) {

		this.mes = mes;
	}


	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#getCargaHorariaMensal()
	 */
	public int getCargaHorariaMensal() {

		return cargaHorariaMensal;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#setCargaHorariaMensal(int)
	 */
	public void setCargaHorariaMensal(int cargaHorariaMensal) {

		this.cargaHorariaMensal = cargaHorariaMensal;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#getMonitor()
	 */
	public Monitor getMonitor() {

		return monitor;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#setMonitor(br.com.projetoperiodo.model.instituto.monitor.impl.
	 * MonitorImpl)
	 */
	public void setMonitor(Monitor monitor) {

		this.monitor = monitor;
	}

	

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#getSemanas(int)
	 */
	public Semana getSemana(int index) {

		return semanas.get(index);
	}
	
	public List<Semana> getSemanas() {
		return semanas;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequencia#setSemanas(br.com.projetoperiodo.model.relatorio.semana.Semana)
	 */
	public void setSemanas(Semana semana) {

		this.semanas.add(semana);
	}
	@Override
	public Situacao getSituacao() {
		return situacao;
	}
	@Override
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	@Override
	public long getCargaHorariaEmMinutos() {
		long cargaHoraria = 0L;
		for ( Semana semana : semanas ) {
			cargaHoraria = semana.getCargaHorariaParcial();
		}
		return cargaHoraria;
	}

}
