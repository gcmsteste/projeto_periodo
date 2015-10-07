
package br.com.projetoperiodo.model.instituto.monitor.impl;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;

@Entity
@Table(name = "MONITOR")
@PrimaryKeyJoinColumn(name = "MONITOR_ID")
@AttributeOverrides({@AttributeOverride(name = "chavePrimaria", column = @Column(name = "MONITOR_ID") )})
public class MonitorImpl extends AlunoImpl implements Monitor {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('BOLSISTA', 'VOLUNTARIO')")
	private Modalidade modalidade;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity=DisciplinaImpl.class)
	@JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "DISCIPLINA_ID")
	private Disciplina disciplina;

	@OneToMany(mappedBy = "monitor", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=RelatorioFrequenciaImpl.class)
	private List<RelatorioFrequencia> relatoriosMensais;

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#getModalidade()
	 */
	
	public Modalidade getModalidade() {

		return modalidade;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#setModalidade(br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade)
	 */
	
	public void setModalidade(Modalidade modalidade) {

		this.modalidade = modalidade;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#getDisciplina()
	 */
	
	public Disciplina getDisciplina() {

		return disciplina;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#setDisciplina(br.com.projetoperiodo.model.instituto.disciplina.Disciplina)
	 */
	
	public void setDisciplina(Disciplina disciplina) {

		this.disciplina = disciplina;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#getRelatoriosMensais()
	 */
	@Override
	public RelatorioFrequencia getRelatoriosMensais(int index) {

		return relatoriosMensais.get(index);
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#setRelatoriosMensais(java.util.Collection)
	 */
	@Override
	public void setRelatoriosMensais(RelatorioFrequencia relatorio) {

		this.relatoriosMensais.add(relatorio);
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.impl.Monitor#getUltimaAlteracao()
	 */

	

	
}
