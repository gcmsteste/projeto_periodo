package br.com.projetoperiodo.model.instituto.professor.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;

@Entity
@Table(name = "PROFESSOR")
@PrimaryKeyJoinColumn( name = "PROFESSOR_ID" )
@Polymorphism(type= PolymorphismType.EXPLICIT)
public class ProfessorImpl extends UsuarioImpl implements Professor {

	@OneToMany(mappedBy="professor", fetch = FetchType.LAZY, targetEntity=DisciplinaImpl.class)
	private List<Disciplina> disciplinas =  new ArrayList<Disciplina>();;
	
	@Transient
	private final String PAPEL_PROFESSOR = "PROFESSOR";
	
	public ProfessorImpl() {
		PAPEL = PAPEL_PROFESSOR;
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
		this.disciplinas.add(disciplina);
	}
	@Override
	public int getQuantidadeDisciplinasDoProfessor() {
		return disciplinas.size();
	}
	

}
