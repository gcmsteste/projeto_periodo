package br.com.projetoperiodo.model.instituto.periodo.controller.impl;

import java.util.Calendar;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo;
import br.com.projetoperiodo.model.instituto.periodo.impl.PeriodoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;

public class ControladorPeriodoImpl extends ControladorNegocioImpl implements ControladorPeriodo
{

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo#criarEntidadeNegocio()
	 */

	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new PeriodoImpl();
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo#gerarNovoPeriodo()
	 */
	@Override
	public Periodo gerarNovoPeriodoCorrente() {
		Periodo periodo = (Periodo)criarEntidadeNegocio();
		Calendar dataAtual = Calendar.getInstance();
		int anoAtual = dataAtual.get(Calendar.YEAR);
		Calendar inicioSegundoSemestre = Calendar.getInstance();
		inicioSegundoSemestre.set(anoAtual, 7, 1);
		if ( dataAtual.after(inicioSegundoSemestre)) {
			periodo.setSemestre(Semestre.SEGUNDO);
		} else {
			periodo.setSemestre(Semestre.PRIMEIRO);
		}
		periodo.setAno(anoAtual);
		return periodo;
	}
}
