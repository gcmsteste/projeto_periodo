package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;

public interface MonitorDao{

	void salvar(Monitor monitor);

	void atualizar(Monitor monitor);

	void remover(Monitor monitor);

	Monitor buscar(long l);

	List<Monitor> listar(String condicao);
	

}
