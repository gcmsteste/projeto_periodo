
package br.com.projetoperiodo.model.relatorio.atividade.dao;

import java.util.List;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;

public interface AtividadeDao {

	public void salvar(Atividade atividade);

	public void remover(Atividade atividade);

	public void alterar(Atividade atividade);

	public List<Atividade> listar();

	public Atividade buscar(long primaryKey);
}
