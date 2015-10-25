
package br.com.projetoperiodo.model.instituto.curso.controller;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface ControladorCurso extends ControladorNegocio{

	EntidadeNegocio criarEntidadeNegocio();


	Curso buscarCursoPadrao();
}