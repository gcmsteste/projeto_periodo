package br.com.projetoperiodo.model.instituto.departamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "DEPARTAMENTO_ID")
	private int id;
	@Column(name = "DEPARTAMENTO_DS")
	private String descricao;
	@Column(name = "DEPARTAMENTO_DS_ABREV")
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
