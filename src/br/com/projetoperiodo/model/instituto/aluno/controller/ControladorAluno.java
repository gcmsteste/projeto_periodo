
package br.com.projetoperiodo.model.instituto.aluno.controller;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;

public interface ControladorAluno extends ControladorNegocio
{

	Aluno cadastrarAluno(Aluno aluno);
}