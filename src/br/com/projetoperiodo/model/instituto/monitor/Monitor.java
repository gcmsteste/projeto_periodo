package br.com.projetoperiodo.model.instituto.monitor;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;
@Entity
@Table(name = "MONITOR")
@PrimaryKeyJoinColumn( name = "MONITOR_ID")
public class Monitor extends AlunoImpl
{
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('BOLSISTA', 'VOLUNTARIO')")
	private Modalidade modalidade;
	
	@ManyToOne(fetch = FetchType.EAGER, optional= false, cascade = CascadeType.PERSIST)
	@JoinColumn(name="DISCIPLINA_ID", referencedColumnName="DISCIPLINA_ID")
	private Disciplina disciplina;
	
	@OneToMany(mappedBy="monitor",
			   cascade=CascadeType.ALL,
			   fetch=FetchType.EAGER)	
	private Collection<RelatorioFrequencia> relatoriosMensais;
	
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {

		this.modalidade = modalidade;
	}
	
	public Disciplina getDisciplina() {

		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {

		this.disciplina = disciplina;
	} 
	public Collection<RelatorioFrequencia> getRelatoriosMensais() {

		return relatoriosMensais;
	}
	public void setRelatoriosMensais(Collection<RelatorioFrequencia> relatoriosMensais) {

		this.relatoriosMensais = relatoriosMensais;
	}
}
