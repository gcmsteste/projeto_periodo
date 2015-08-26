package br.com.projetoperiodo.model.instituto.curso;

import java.util.Collection;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.curso.disciplina.Disciplina;
import br.com.projetoperiodo.util.constantes.Grau;

public class Curso {
	private String descricao;
	private Grau modalidade;
	private Collection<Disciplina> disciplinas;
	private Collection<Aluno> alunos;
	
	public Collection<Disciplina> getDisciplinas() {

		return disciplinas;
	}
	public void setDisciplinas(Collection<Disciplina> disciplinas) {

		this.disciplinas = disciplinas;
	}
	public String getDescricao() {

		return descricao;
	}
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}
	public Collection<Aluno> getAlunos() {

		return alunos;
	}
	public void setAlunos(Collection<Aluno> alunos) {

		this.alunos = alunos;
	}
	public Grau getModalidade() {

		return modalidade;
	}
	public void setModalidade(Grau modalidade) {

		this.modalidade = modalidade;
	}
	
}
