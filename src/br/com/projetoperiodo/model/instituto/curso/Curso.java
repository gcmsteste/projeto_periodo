
package br.com.projetoperiodo.model.instituto.curso;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;

public interface Curso extends EntidadeNegocio
{
	Disciplina getDisciplinas(int index);

	void setDisciplinas(Disciplina disciplina);

	String getDescricao();

	void setDescricao(String descricao);

	Aluno getAlunos(int index);

	void setAlunos(Aluno aluno);

	Grau getModalidade();

	void setModalidade(Grau modalidade);

}