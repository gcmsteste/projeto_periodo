package br.com.projetoperiodo.model.instituto.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.usuario.Usuario;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn( name = "USUARIO_ID" )
public class Aluno extends Usuario
{
	@Column( name = "ALUNO_MATRICULA", nullable = false)
	private String matricula;
	
	private Curso curso;
	
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
}
