package br.com.projetoperiodo.model.instituto.funcionario;

import java.util.List;

public interface FuncionarioDao {

	public List<Funcionario> listar();
	
	public void salvar(Funcionario funcionario);
	
	public void remover(Funcionario funcionario);
	
	public void atualizar(Funcionario funcionario);
	
	public Funcionario buscar(int primaryK);
}
