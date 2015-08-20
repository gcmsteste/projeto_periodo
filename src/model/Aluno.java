package model;


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
