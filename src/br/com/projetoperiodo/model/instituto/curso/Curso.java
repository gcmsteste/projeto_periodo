package br.com.projetoperiodo.model.instituto.curso;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;
@Entity
@Table( name = "CURSO")
public class Curso {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "CURSO_ID")
	private int id;
	@Column(name = "CURSO_DS")
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('TECNICO', 'SUPERIOR')")
	private Grau grau;
	@OneToMany(mappedBy = "curso", 
					   cascade = CascadeType.ALL,
					   fetch = FetchType.EAGER)
	private Collection<Disciplina> disciplinas;
	@OneToMany(mappedBy = "curso", 
			   cascade = CascadeType.ALL,
			   fetch = FetchType.EAGER)
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

		return grau;
	}
	public void setModalidade(Grau modalidade) {

		this.grau = modalidade;
	}
	public int getId() {

		return id;
	}
	public void setId(int id) {

		this.id = id;
	}
	
}
