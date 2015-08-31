package br.com.projetoperiodo.model.relatorio.atividade;

import java.util.List;

public interface AtividadeDao {
	public void salvar(Atividade atividade);
	
	public void remover(Atividade atividade);
	
	public void alterar(Atividade atividade);
	
	public List<Atividade> listar();
}
