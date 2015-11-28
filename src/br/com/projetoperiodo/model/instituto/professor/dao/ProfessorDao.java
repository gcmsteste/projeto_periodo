package br.com.projetoperiodo.model.instituto.professor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.professor.Professor;

public interface ProfessorDao 
{
	public List<Professor> listar(String condicao);
	
	public Professor salvar(Professor professor);
	
	public void remover(Professor professor);
	
	public void atualizar(Professor professor);

	


}
