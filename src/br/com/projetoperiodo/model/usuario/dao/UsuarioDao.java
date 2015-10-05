package br.com.projetoperiodo.model.usuario.dao;

import java.util.HashMap;
import java.util.List;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface UsuarioDao {

	public void salvar(Usuario usuario);
	
	public void atualizar(Usuario usuario);
	
	public void remover(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario buscar(long l);
	
	public Usuario buscar(String nome);

	Usuario buscar(HashMap<String, Object> filter) throws NegocioException;
	
}
