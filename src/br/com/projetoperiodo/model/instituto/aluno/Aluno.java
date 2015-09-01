package br.com.projetoperiodo.model.instituto.aluno;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.usuario.Usuario;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn( name = "ALUNO_ID" )
public class Aluno extends Usuario
{
	@Column( name = "ALUNO_MATRICULA", nullable = false)
	private String matricula;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CURSO_ID", referencedColumnName = "CURSO_ID")
	private Curso curso;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="DISCIPLINA_ALUNO",
	           joinColumns = @JoinColumn( name = "ALUNO_ID"),
	           inverseJoinColumns = @JoinColumn(name = "DISCIPLINA_ID"))
	private Collection<Disciplina> disciplinas;
	
	public String getMatricula() {

		return matricula;
	}
	public void setMatricula(String matricula) {

		this.matricula = matricula;
	}

	public Curso getCurso() {

		return curso;
	}
	public void setCurso(Curso curso) {

		this.curso = curso;
	}
	public Collection<Disciplina> getDisciplinas() {

		return disciplinas;
	}
	public void setDisciplinas(Collection<Disciplina> disciplinas) {

		this.disciplinas = disciplinas;
	}
}
