package model;

import java.util.Date;

public class ComprovanteRelatorio {
	private Date dataEntrega;
	private Disciplina disciplina;
	private Monitor monitor;
	private Funcionario funcionario;
	
	public Monitor getMonitor() {

		return monitor;
	}
	public void setMonitor(Monitor monitor) {

		this.monitor = monitor;
	}
	public Funcionario getFuncionario() {

		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {

		this.funcionario = funcionario;
	}
	public Disciplina getDisciplina() {

		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {

		this.disciplina = disciplina;
	}
	public Date getDataEntrega() {

		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {

		this.dataEntrega = dataEntrega;
	}
}
