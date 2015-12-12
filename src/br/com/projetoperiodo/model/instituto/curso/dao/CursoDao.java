
package br.com.projetoperiodo.model.instituto.curso.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.curso.Curso;

public interface CursoDao {

	public void salvar(Curso curso);

	public void remover(Curso curso);

	public void atualizar(Curso curso);

	Curso buscar(long primaryKey);

	List<Curso> listar();

}
