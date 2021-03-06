
package br.com.projetoperiodo.model.instituto.professor.controller;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface ControladorProfessor extends ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();
	
	Professor cadastrarProfessor(Professor professor); 
	
	String getNomeClasseEntidade();

	boolean verificarPapelDeProfessorDoUsuario(Usuario usuario);

}