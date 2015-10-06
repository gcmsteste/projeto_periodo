package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.util.List;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;

public interface RelatorioFrequenciaDao {
	public void salvar(RelatorioFrequencia relatorio);
	public void atualizar(RelatorioFrequencia relatorio);
	public void remover(RelatorioFrequencia relatorio);
	public List<RelatorioFrequencia> listar();
	public RelatorioFrequencia buscar(int primaryKey);
}
