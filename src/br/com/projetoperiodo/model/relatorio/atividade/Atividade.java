
package br.com.projetoperiodo.model.relatorio.atividade;

import java.util.Date;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface Atividade extends EntidadeNegocio
{

	Date getData();

	void setData(Date data);

	String getHorarioEntrada();

	void setHorarioEntrada(String horarioEntrada);

	String getHorarioSaida();

	void setHorarioSaida(String horarioSaida);

	Semana getSemana();

	void setSemana(Semana semana);

	long getDuracaoEmMinutosDaAtividade();



}