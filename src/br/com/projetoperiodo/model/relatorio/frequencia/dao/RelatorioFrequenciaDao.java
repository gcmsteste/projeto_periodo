package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.util.List;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;

public interface RelatorioFrequenciaDao {
	public RelatorioFrequencia salvar(RelatorioFrequencia relatorio);
	public RelatorioFrequencia atualizar(RelatorioFrequencia relatorio);
	public void remover(RelatorioFrequencia relatorio);
	public List<RelatorioFrequencia> listar(String condicao);
	public RelatorioFrequencia buscar(long primaryKey);
	public List<Situacao> listarSituacaoDosRelatorios(String condicao);
	void remover(String condicao);
}
