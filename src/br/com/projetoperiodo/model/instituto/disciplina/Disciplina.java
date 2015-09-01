package br.com.projetoperiodo.model.instituto.disciplina;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.curso.Curso;
@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {
	@Id
	@Column( name = "DISCIPLINA_ID")
	@GeneratedValue(  strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name = "DISCIPLINA_DS")
	private String descricao;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="DISCIPLINA_ALUNO",
	           joinColumns = @JoinColumn( name = "DISCIPLINA_ID"),
	           inverseJoinColumns = @JoinColumn(name = "ALUNO_ID"))
	private Collection<Aluno> pagantes;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn( name = "CURSO_ID", referencedColumnName = "CURSO_ID") 
	private Curso curso;
	
	public String getDescricao() {

		return descricao;
	}
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}
	public Collection<Aluno> getPagantes() {

		return pagantes;
	}
	public void setPagantes(Collection<Aluno> pagantes) {

		this.pagantes = pagantes;
	}
	public int getId() {

		return id;
	}
	public void setId(int id) {

		this.id = id;
	}
	public Curso getCurso() {

		return curso;
	}
	public void setCurso(Curso curso) {

		this.curso = curso;
	}

	
	
}
