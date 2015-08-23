package dao;

import java.util.Collection;

public interface DAO {
	public void inserir(Object object);
	public void atualizar(Object object);
	public void remover(Object object);
	public Collection<Object> listar();
	public Object buscar(Object object);
}
