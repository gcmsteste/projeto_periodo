package br.com.projetoperiodo.model.instituto.departamento;


public class Departamento {
	private int id;
	private String descricao;
	private String descricaoAbreviada;
	
	public String getDescricaoAbreviada() {

		return descricaoAbreviada;
	}
	public void setDescricaoAbreviada(String descricaoAbreviada) {

		this.descricaoAbreviada = descricaoAbreviada;
	}
	public String getDescricao() {

		return descricao;
	}
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}
	public int getId() {

		return id;
	}
	private void setId(int id) {

		this.id = id;
	}
}
