package br.com.projetoperiodo.model.instituto.disciplina;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;

public interface DisciplinaDao {

	public void salvar(Disciplina disciplina);
	
	public void atualizar(Disciplina disciplina);
	
	public void remover(Disciplina disciplina);
	
	public List<Disciplina> listar(); 

	public Disciplina buscar(int primaryK);
	
}
