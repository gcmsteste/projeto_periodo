
package br.com.projetoperiodo.model.instituto.curso.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;

@Entity
@Table(name = "CURSO")
@AttributeOverrides({@AttributeOverride(name = "chavePrimaria", column = @Column(name = "CURSO_ID") )})
public class CursoImpl extends EntidadeNegocioImpl implements Curso {

	@Column(name = "CURSO_DS")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('TECNICO', 'SUPERIOR')")
	private Grau grau;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = DisciplinaImpl.class)
	private List<Disciplina> disciplinas;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = AlunoImpl.class)
	private List<Aluno> alunos;

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getDisciplinas()
	 */
	public Disciplina getDisciplinas(int index) {

		return disciplinas.get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setDisciplinas(java.util.Collection)
	 */
	public void setDisciplinas(Disciplina disciplina) {

		this.disciplinas.add(disciplina);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getDescricao()
	 */
	public String getDescricao() {

		return descricao;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setDescricao(java.lang.String)
	 */
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getAlunos()
	 */
	public Aluno getAlunos(int index) {

		return alunos.get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setAlunos(java.util.Collection)
	 */
	public void setAlunos(Aluno aluno) {

		this.alunos.add(aluno);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getModalidade()
	 */
	public Grau getModalidade() {

		return grau;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setModalidade(br.com.projetoperiodo.util.constantes.enumeracoes.Grau)
	 */
	public void setModalidade(Grau modalidade) {

		this.grau = modalidade;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getChavePrimaria()
	 */
	@Override
	public long getChavePrimaria() {

		return super.getChavePrimaria();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setChavePrimaria(long)
	 */
	@Override
	public void setChavePrimaria(long chavePrimaria) {

		super.setChavePrimaria(chavePrimaria);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#getUltimaAlteracao()
	 */
	@Override
	public Date getUltimaAlteracao() {

		return super.getUltimaAlteracao();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.impl.Curso#setUltimaAlteracao(java.util.Date)
	 */
	@Override
	public void setUltimaAlteracao(Date ultimaAlteracao) {

		super.setUltimaAlteracao(ultimaAlteracao);
	}


}
