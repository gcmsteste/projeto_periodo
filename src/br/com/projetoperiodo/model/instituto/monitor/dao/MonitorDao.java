package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;

public interface MonitorDao {

public void salvar(Monitor monitor);
	
	public void atualizar(Monitor monitor);
	
	public void remover(Monitor monitor);
	
	public List<Monitor> listar(); 

	public Monitor buscar(int primaryK);
	
	
	
}
