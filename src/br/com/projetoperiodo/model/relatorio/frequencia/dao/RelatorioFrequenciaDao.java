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
	void remover(String condicao);
	List<Situacao> listarSituacaoDosRelatorios(long chave);
	RelatorioFrequencia buscarRelatoriosDeMonitoriaPorMes(long chave, int mes);
	List<RelatorioFrequencia> buscarRelatoriosDeMonitoria(long chave);

}
