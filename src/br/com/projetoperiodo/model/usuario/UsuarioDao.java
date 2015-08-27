package br.com.projetoperiodo.model.usuario;

import java.util.List;

public interface UsuarioDao {

	public void insert(Usuario usuario);
	
	public void atualizar(Usuario usuario);
	
	public void remover(Usuario usuario);
	
	public List<Usuario> listar();
	
}
