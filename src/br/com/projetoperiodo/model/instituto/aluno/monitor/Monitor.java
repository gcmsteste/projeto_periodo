package br.com.projetoperiodo.model.instituto.aluno.monitor;

import java.util.Collection;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.curso.disciplina.Disciplina;
import br.com.projetoperiodo.model.relatorio.RelatorioFrequencia;
import br.com.projetoperiodo.util.constantes.Modalidade;

public class Monitor extends Aluno
{
	private Modalidade modalidade;
	private Disciplina disciplina;
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
