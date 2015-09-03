package br.com.projetoperiodo.model.instituto.aluno;

import java.util.List;

public interface AlunoDao 
{
	public void salvar(Aluno aluno);
	
	public void atualizar(Aluno aluno);
	
	public void remover(Aluno aluno);
	
	public List<Aluno> listar(); 

	public Aluno buscar(int primaryK);
}
