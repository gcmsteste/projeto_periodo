package br.com.projetoperiodo.model.instituto.professor.impl;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;

@Entity
@Table(name = "PROFESSOR")
@PrimaryKeyJoinColumn( name = "PROFESSOR_ID" )
@AttributeOverrides({ @AttributeOverride(name = "chavePrimaria", column = @Column(name = "PROFESSOR_ID") )}) 
public class ProfessorImpl extends UsuarioImpl implements Professor {

	@Column(name = "PROFESSOR_NOME", nullable = false)
	private String nome;
	@Column(name = "PROFESSOR_SIAPE", nullable = false)
	private String siape;
	@OneToMany(mappedBy="professor",
					   cascade = CascadeType.ALL,
					   fetch = FetchType.EAGER)
	private List<DisciplinaImpl> disciplinas;

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
	public void setDisciplina(DisciplinaImpl disciplina) {
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
