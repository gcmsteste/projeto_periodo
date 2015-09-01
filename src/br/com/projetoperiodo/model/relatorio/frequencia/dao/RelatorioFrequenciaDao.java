package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.util.Collection;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface RelatorioFrequenciaDao {
	public void salvar(RelatorioFrequencia relatorio);
	public void atualizar(RelatorioFrequencia relatorio);
	public void remover(RelatorioFrequencia relatorio);
	public Collection<RelatorioFrequencia> listar();
	public RelatorioFrequencia buscar(int primaryKey);
}
