package br.com.projetoperiodo.model.relatorio.semana;

import java.util.ArrayList;
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

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
@Entity
@Table(name = "SEMANA")
public class Semana {
	@Id
	@GeneratedValue(  strategy = GenerationType.IDENTITY )
	@Column(name = "SEMANA_ID")
	private int id;
	@Column(name = "SEMANA_DESCRICAO")
	private String descricao;
	@Column( name = "SEMANA_OBS")
	private String observacoes;
	@OneToMany(mappedBy="semana",
			   cascade = CascadeType.ALL,
			   fetch = FetchType.EAGER)
	private List<Atividade> atividades;
	@ManyToOne( fetch = FetchType.LAZY, optional = true)
	@JoinColumn( name = "RELATORIO_ID", referencedColumnName = "RELATORIO_ID")
	private RelatorioFrequencia relatorio;
	
	public Semana() {
		atividades = new ArrayList<Atividade>();
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getObservacoes() {
		return this.observacoes;
	}
	
	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}
	
	public void setObservacoes( String observacoes ) {
		this.observacoes = observacoes;
	}

	public Atividade getAtividades(int index) {

		return atividades.get(index);
	}

	public void setAtividades(Atividade atividade) {

		this.atividades.add(atividade);
	}

	public RelatorioFrequencia getRelatorio() {

		return relatorio;
	}

	public void setRelatorio(RelatorioFrequencia relatorio) {

		this.relatorio = relatorio;
	}
	private void setId( int id ) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
