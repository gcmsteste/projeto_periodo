package model;

import java.util.Collection;

import util.Modalidade;

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
