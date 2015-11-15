
package br.com.projetoperiodo.model.instituto.professor.controller;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;

public interface ControladorProfessor extends ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();

	String getNomeClasseEntidade();

	boolean verificarPapelDeProfessorDoUsuario(Usuario usuario);

}