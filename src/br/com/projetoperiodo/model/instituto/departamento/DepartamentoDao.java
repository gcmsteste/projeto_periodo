package br.com.projetoperiodo.model.instituto.departamento;

import java.util.List;

public interface DepartamentoDao {
	public List<Departamento> listar();
	
	public void salvar(Departamento departamento);
	
	public void remover(Departamento departamento);
	
	public void atualizar(Departamento departamento);
	
	public Departamento buscar(int primaryKey);
	
}
