package br.com.projetoperiodo.model.relatorio.semana;

import java.util.List;

public interface SemanaDao {
public void salvar(Semana semana);
	
	public void remover(Semana semana);
	
	public void alterar(Semana semana);
	
	public List<Semana> listar();
}
