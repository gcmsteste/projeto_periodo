package br.com.projetoperiodo.model.relatorio;

import java.util.Collection;

public interface RelatorioFrequenciaDao {
	public void inserir(Object object);
	public void atualizar(Object object);
	public void remover(Object object);
	public Collection<Object> listar();
	public Object buscar(Object object);
}
