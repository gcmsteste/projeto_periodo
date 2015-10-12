
package br.com.projetoperiodo.model.instituto.disciplina.controller;

import java.util.List;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;

public interface ControladorDisciplina extends ControladorNegocio
{
	List<Disciplina> listarDisciplinasCadastradas();
}