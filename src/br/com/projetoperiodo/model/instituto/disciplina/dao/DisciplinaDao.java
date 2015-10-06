package br.com.projetoperiodo.model.instituto.disciplina.dao;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;

public interface DisciplinaDao {

	public void salvar(Disciplina disciplina);
	
	public void atualizar(DisciplinaImpl disciplina);
	
	public void remover(DisciplinaImpl disciplina);
	
	public List<DisciplinaImpl> listar(); 

	public Disciplina buscar(int primaryK);
	
}
