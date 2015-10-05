package br.com.projetoperiodo.model.instituto.professor.impl;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
/*
@Entity
@Table(name = "PROFESSOR")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverrides({ @AttributeOverride(name = "chavePrimaria", column = @Column(name = "PROFESSOR_ID") ), }) */
public class ProfessorImpl extends EntidadeNegocioImpl implements Professor {

	private String nome;

	private String siape;

	private List<Disciplina> disciplinas;

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#getNome()
	 */
	@Override
	public String getNome() {

		return nome;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {

		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#getSiape()
	 */
	@Override
	public String getSiape() {

		return siape;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#setSiape(java.lang.String)
	 */
	@Override
	public void setSiape(String siape) {

		this.siape = siape;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#getDisciplina(int)
	 */
	@Override
	public Disciplina getDisciplina(int index) {
		return disciplinas.get(index);
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#setDisciplina(br.com.projetoperiodo.model.instituto.disciplina.Disciplina)
	 */
	@Override
	public void setDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#getChavePrimaria()
	 */

	@Override
	public long getChavePrimaria() {
		
		return super.getChavePrimaria();
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.professor.Professor#setChavePrimaria(long)
	 */
	
	@Override
	public void setChavePrimaria(long chavePrimaria) {
		
		super.setChavePrimaria(chavePrimaria);
	}

}
