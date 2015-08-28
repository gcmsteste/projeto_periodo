package br.com.projetoperiodo.model.instituto.curso;

import java.util.List;


public interface CursoDao 
{

	public List<Curso> listar();
	
	public void salvar(Curso curso);
	
	public void remover(Curso curso) throws Exception;
	
	public void atualizar(Curso curso) throws Exception;

	Curso salvar(String descricao, String condicao) throws Exception;

}
