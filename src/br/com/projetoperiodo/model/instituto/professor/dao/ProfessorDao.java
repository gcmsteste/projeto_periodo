package br.com.projetoperiodo.model.instituto.professor.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.professor.Professor;

public interface ProfessorDao 
{

	Professor salvar(Professor professor);

	void atualizar(Professor professor);

	void remover(Professor professor);

	List<Professor> listar();

	Professor buscar(long primaryKey);
	
}
