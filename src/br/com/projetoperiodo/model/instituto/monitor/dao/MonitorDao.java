package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.HashMap;
import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface MonitorDao{

	void salvar(Monitor monitor);

	void atualizar(Monitor monitor);

	void remover(Monitor monitor);

	List<Monitor> listar();

	Monitor buscar(long l);
	
	List<Monitor> buscar(HashMap<String, Object> filter) throws NegocioException;

}
