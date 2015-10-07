
package br.com.projetoperiodo.model.relatorio.semana.dao;

import java.util.List;

import br.com.projetoperiodo.model.relatorio.semana.Semana;

public interface SemanaDao {

	public void salvar(Semana semana);

	public void remover(Semana semana);

	public void alterar(Semana semana);

	public List<Semana> listar();

	public Semana buscar(long primaryKey);
}
