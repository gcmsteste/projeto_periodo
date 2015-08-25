package dao;

import java.util.Collection;

import model.Funcionario;

public interface FuncionarioDao
{
	public void salvar(Funcionario funcionario);

	public Collection<Funcionario> listar();
	
	public void remover(Funcionario funcionario);
	
	public void atualizar(Funcionario funcionario);
}
