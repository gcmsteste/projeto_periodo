package br.com.projetoperiodo.model.instituto.orientador;

import java.util.List;

import br.com.projetoperiodo.model.instituto.orientador.Orientador;

public interface OrientadorDao 
{
	public List<Orientador> listar();
	
	public void salvar(Orientador orientador);
	
	public void remover(Orientador orientador) throws Exception;
	
	public void atualizar(Orientador orientador) throws Exception;

	List<Orientador> getList(String condicao) throws Exception;

	Orientador salvar(Long chavePrimaria, String condicao) throws Exception;

}
