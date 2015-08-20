package model;

import java.security.Timestamp;
import java.util.Date;

public class Atividade {
	private Timestamp horario_entrada;
	private Timestamp horario_saida;
	private Date data;
	
	public Date getData() {
		return this.data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public Timestamp getHorarioSaida() {

		return horario_saida;
	}

	public void setHorarioSaida(Timestamp horario_saida) {

		this.horario_saida = horario_saida;
	}

	public Timestamp getHorarioEntrada() {

		return horario_entrada;
	}

	public void setHorarioEntrada(Timestamp horario_entrada) {

		this.horario_entrada = horario_entrada;
	}


}
