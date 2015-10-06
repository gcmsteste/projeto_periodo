package br.com.projetoperiodo.model.relatorio.atividade.impl;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;

@Entity
@Table(name = "ATIVIDADE")
@AttributeOverrides({ @AttributeOverride(name = "chavePrimaria", column = @Column(name = "ATIVIDADE_ID") )}) 
public class AtividadeImpl extends EntidadeNegocioImpl implements Atividade
{
	
	@Column( name = "HORARIO_SAIDA", nullable = false)
	private String horario_entrada;
	@Column( name = "HORARIO_ENTRADA", nullable = false)
	private String horario_saida;
	@Column( name = "ATIVIDADE_DATA", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date data;
	@ManyToOne(fetch = FetchType.EAGER, optional = true, targetEntity= SemanaImpl.class)
	@JoinColumn( name = "SEMANA_ID", referencedColumnName = "SEMANA_ID" )
	private Semana semana;
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getData()
	 */
	public Date getData() {
		return this.data;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setData(java.util.Date)
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getHorarioEntrada()
	 */
	public String getHorarioEntrada() {

		return horario_entrada;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setHorarioEntrada(java.lang.String)
	 */
	public void setHorarioEntrada(String horarioEntrada) {

		this.horario_entrada = horarioEntrada;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getHorarioSaida()
	 */
	public String getHorarioSaida() {

		return horario_saida;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setHorarioSaida(java.lang.String)
	 */
	public void setHorarioSaida(String horarioSaida) {

		this.horario_saida = horarioSaida;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getSemana()
	 */
	public Semana getSemana() {

		return semana;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setSemana(br.com.projetoperiodo.model.relatorio.semana.Semana)
	 */
	public void setSemana(Semana semana) {

		this.semana = semana;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getChavePrimaria()
	 */
	@Override
	public long getChavePrimaria() {
	
		// TODO Auto-generated method stub
		return super.getChavePrimaria();
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setChavePrimaria(long)
	 */
	@Override
	public void setChavePrimaria(long chavePrimaria) {
	
		// TODO Auto-generated method stub
		super.setChavePrimaria(chavePrimaria);
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#getUltimaAlteracao()
	 */
	@Override
	public Date getUltimaAlteracao() {
	
		// TODO Auto-generated method stub
		return super.getUltimaAlteracao();
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.atividade.impl.Atividade#setUltimaAlteracao(java.util.Date)
	 */
	@Override
	public void setUltimaAlteracao(Date ultimaAlteracao) {
	
		// TODO Auto-generated method stub
		super.setUltimaAlteracao(ultimaAlteracao);
	}
}
