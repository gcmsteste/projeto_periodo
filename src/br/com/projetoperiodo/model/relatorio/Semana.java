package br.com.projetoperiodo.model.relatorio;

import java.util.Collection;

public class Semana {
	private String descricao;
	private String observacoes;
	private Collection<Atividade> atividades;
	
	public Semana() {
		
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

	public Collection<Atividade> getAtividades() {

		return atividades;
	}

	public void setAtividades(Collection<Atividade> atividades) {

		this.atividades = atividades;
	}

}