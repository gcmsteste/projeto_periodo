package br.com.projetoperiodo.model.instituto.aluno.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;

public interface AlunoDao 
{
	public void salvar(Aluno aluno);
	
	public void atualizar(Aluno aluno);
	
	public void remover(Aluno aluno);
	
	public List<Aluno> listar(); 

	public Aluno buscar(long l);
}
