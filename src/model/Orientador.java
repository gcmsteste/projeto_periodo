package model;


public class Orientador
{
	private String nome;
	private String siape;
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
	
}
