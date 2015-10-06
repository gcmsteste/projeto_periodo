package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;

public interface MonitorDao {

public void salvar(Monitor monitor);
	
	public void atualizar(MonitorImpl monitor);
	
	public void remover(MonitorImpl monitor);
	
	public List<MonitorImpl> listar(); 

	public Monitor buscar(int primaryK);
	
	
	
}
