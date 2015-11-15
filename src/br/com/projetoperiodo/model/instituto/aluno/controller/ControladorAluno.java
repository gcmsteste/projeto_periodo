
package br.com.projetoperiodo.model.instituto.aluno.controller;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface ControladorAluno extends ControladorNegocio
{

	Aluno cadastrarAluno(Aluno aluno);
	
	Aluno buscarUsuarioAluno(Usuario usuario);

	boolean verificarPapelDeAlunoDoUsuario(Usuario usuario);
}