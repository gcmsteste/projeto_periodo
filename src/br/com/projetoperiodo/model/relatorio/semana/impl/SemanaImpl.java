package br.com.projetoperiodo.model.relatorio.semana.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
@Entity
@Table(name = "SEMANA")
@AttributeOverrides({ @AttributeOverride(name = "chavePrimaria", column = @Column(name = "SEMANA_ID") )}) 
public class SemanaImpl extends EntidadeNegocioImpl implements Semana
{
	
	@Column(name = "SEMANA_DESCRICAO")
	private String descricao;
	@Column( name = "SEMANA_OBS")
	private String observacoes;
	@OneToMany(mappedBy="semana",
			   cascade = CascadeType.ALL,	
			   fetch = FetchType.EAGER, targetEntity = AtividadeImpl.class)
	private List<Atividade> atividades;
	@ManyToOne( fetch = FetchType.LAZY, optional = true, targetEntity = RelatorioFrequenciaImpl.class)
	@JoinColumn( name = "RELATORIO_ID", referencedColumnName = "RELATORIO_ID")
	private RelatorioFrequencia relatorio;
	
	public SemanaImpl() {
		atividades = new ArrayList<Atividade>();
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#getDescricao()
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#getObservacoes()
	 */
	public String getObservacoes() {
		return this.observacoes;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#setDescricao(java.lang.String)
	 */
	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#setObservacoes(java.lang.String)
	 */
	public void setObservacoes( String observacoes ) {
		this.observacoes = observacoes;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#getAtividades(int)
	 */
	public Atividade getAtividades(int index) {

		return atividades.get(index);
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#setAtividades(br.com.projetoperiodo.model.relatorio.atividade.Atividade)
	 */
	public void setAtividades(Atividade atividade) {

		this.atividades.add(atividade);
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#getRelatorio()
	 */
	public RelatorioFrequencia getRelatorio() {

		return relatorio;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.relatorio.semana.impl.Semana#setRelatorio(br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia)
	 */
	public void setRelatorio(RelatorioFrequencia relatorio) {

		this.relatorio = relatorio;
	}
	
}
