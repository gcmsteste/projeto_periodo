
package br.com.projetoperiodo.model.instituto.aluno.controller.impl;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;

public class ControladorAlunoImpl extends ControladorNegocioImpl implements ControladorAluno {

	private AlunoDao dao;
	
	public ControladorAlunoImpl() {
		dao = fabrica.criarAlunoDAO();
	}
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new AlunoImpl();
	}

	@Override
	public Aluno cadastrarAluno(Aluno aluno) {

		String senhaCriptografada = Util.criptografarSenha(
						aluno.getSenha(), aluno.getSenha(), Constantes.CONSTANTE_CRIPTOGRAFIA);
		aluno.setSenha(senhaCriptografada);
		dao.salvar(aluno);
		return aluno;
	}

}
