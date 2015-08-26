package br.com.projetoperiodo.model.instituto.aluno;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.usuario.Usuario;

public class Aluno extends Usuario
{
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
