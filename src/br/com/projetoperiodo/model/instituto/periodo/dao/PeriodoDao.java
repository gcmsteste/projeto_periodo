package br.com.projetoperiodo.model.instituto.periodo.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;

public interface PeriodoDao {
	Periodo salvar(Periodo periodo);

	void atualizar(Periodo periodo);

	void remover(Periodo periodo);

	Periodo buscar(long l);

	List<Periodo> listar();

	List<Periodo> buscarPeriodoPorAnoEsemestre(int ano, Semestre semestre);
}
