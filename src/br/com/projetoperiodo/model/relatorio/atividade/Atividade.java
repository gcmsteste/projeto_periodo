package br.com.projetoperiodo.model.relatorio.atividade;

import java.security.Timestamp;
import java.util.Date;

public class Atividade {
	private int id;
	private String horario_entrada;
	private String horario_saida;
	private Date data;
	
	public Date getData() {
		return this.data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public String getHorarioEntrada() {

		return horario_entrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {

		this.horario_entrada = horarioEntrada;
	}

	public String getHorarioSaida() {

		return horario_saida;
	}

	public void setHorarioSaida(String horarioSaida) {

		this.horario_saida = horarioSaida;
	}

	public int getId() {

		return id;
	}

	private void setId(int id) {

		this.id = id;
	}


}
