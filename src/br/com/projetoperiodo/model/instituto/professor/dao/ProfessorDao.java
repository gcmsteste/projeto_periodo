package br.com.projetoperiodo.model.instituto.professor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.professor.Professor;

public interface ProfessorDao 
{
	public List<Professor> listar();
	
	public void salvar(Professor professor);
	
	public void remover(Professor professor);
	
	public void atualizar(Professor professor);

	


}
