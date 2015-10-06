package br.com.projetoperiodo.model.instituto.aluno.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;

@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn( name = "ALUNO_ID" )
@AttributeOverrides({ @AttributeOverride(name = "chavePrimaria", column = @Column(name = "ALUNO_ID") )}) 
public class AlunoImpl extends UsuarioImpl implements Aluno
{
	@Column( name = "ALUNO_MATRICULA", nullable = false)
	private String matricula;
	@ManyToOne(fetch = FetchType.LAZY, optional = true, targetEntity= CursoImpl.class)
	@JoinColumn(name = "CURSO_ID", referencedColumnName = "CURSO_ID")
	private Curso curso;
	
	@ManyToMany()
	@JoinTable(name="DISCIPLINA_ALUNO",
	           joinColumns = @JoinColumn( name = "ALUNO_ID"),
	           inverseJoinColumns = @JoinColumn(name = "DISCIPLINA_ID"))
	private List<DisciplinaImpl> disciplinas = new ArrayList<DisciplinaImpl>();
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#getMatricula()
	 */
	@Override
	public String getMatricula() {

		return matricula;
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#setMatricula(java.lang.String)
	 */
	@Override
	public void setMatricula(String matricula) {

		this.matricula = matricula;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#getCurso()
	 */
	
	public Curso getCurso() {

		return curso;
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#setCurso(br.com.projetoperiodo.model.instituto.curso.Curso)
	 */
	
	public void setCurso(Curso curso) {

		this.curso = curso;
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#getDisciplinas(int)
	 */
	
	public Disciplina getDisciplinas(int index) {

		return disciplinas.get(index);
	}
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.aluno.impl.Aluno#setDisciplinas(br.com.projetoperiodo.model.instituto.disciplina.Disciplina)
	 */
	
	public void setDisciplinas(DisciplinaImpl disciplina) {

		this.disciplinas.add(disciplina);
	}
	
	
}
