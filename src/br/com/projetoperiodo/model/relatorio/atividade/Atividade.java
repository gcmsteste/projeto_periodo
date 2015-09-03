package br.com.projetoperiodo.model.relatorio.atividade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import br.com.projetoperiodo.model.relatorio.semana.Semana;

@Entity
@Table(name = "ATIVIDADE")
public class Atividade {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ATIVIDADE_ID")
	private int id;
	@Column( name = "HORARIO_SAIDA", nullable = false)
	private String horario_entrada;
	@Column( name = "HORARIO_ENTRADA", nullable = false)
	private String horario_saida;
	@Column( name = "ATIVIDADE_DATA", nullable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date data;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn( name = "SEMANA_ID", referencedColumnName = "SEMANA_ID" )
	private Semana semana;
	
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

	public Semana getSemana() {

		return semana;
	}

	public void setSemana(Semana semana) {

		this.semana = semana;
	}


}
