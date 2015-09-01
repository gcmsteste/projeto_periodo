package br.com.projetoperiodo.model.instituto.orientador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
@Entity
@Table( name = "ORIENTADOR")
public class Orientador
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ORIENTADOR_ID")
	private int id;
	@Column(name = "ORIENTADOR_NOME")
	private String nome;
	@Column(name = "ORIENTADOR_SIAPE")
	private String siape;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "DISCIPLINA_ID")
	private Disciplina disciplina;
	
	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getSiape() {

		return siape;
	}

	public void setSiape(String siape) {

		this.siape = siape;
	}

	public Disciplina getDisciplina() {

		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {

		this.disciplina = disciplina;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}
	
}
