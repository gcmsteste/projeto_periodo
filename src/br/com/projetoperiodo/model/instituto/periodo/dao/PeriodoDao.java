package br.com.projetoperiodo.model.instituto.periodo.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;

public interface PeriodoDao {
	void salvar(Periodo periodo);

	void atualizar(Periodo periodo);

	void remover(Periodo periodo);

	Periodo buscar(long l);

	List<Periodo> listar(String condicao);
}
