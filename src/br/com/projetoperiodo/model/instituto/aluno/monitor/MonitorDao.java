package br.com.projetoperiodo.model.instituto.aluno.monitor;

import java.util.List;

public interface MonitorDao {

public void salvar(Monitor monitor);
	
	public void atualizar(Monitor monitor);
	
	public void remover(Monitor monitor);
	
	public List<Monitor> listar(); 

	public Monitor buscar(int primaryK);
	
	
	
}
