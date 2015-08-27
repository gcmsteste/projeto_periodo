package br.com.projetoperiodo.model.instituto.aluno;

import java.util.List;

public interface AlunoDao 
{
	public void inserir(Aluno aluno);
	
	public void atualizar(Aluno aluno);
	
	public void remover(Aluno aluno);
	
	public List<Aluno> listar(); 
}
