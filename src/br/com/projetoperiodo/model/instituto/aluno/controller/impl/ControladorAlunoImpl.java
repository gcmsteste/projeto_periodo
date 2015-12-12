
package br.com.projetoperiodo.model.instituto.aluno.controller.impl;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.fachada.Persistencia;

public class ControladorAlunoImpl extends ControladorNegocioImpl implements ControladorAluno {


	
	public ControladorAlunoImpl() {
	
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
		Persistencia.getInstance().salvarAluno(aluno);
		return aluno;
	}
	@Override
	public Aluno buscarUsuarioAluno(Usuario usuario) {
		return (Aluno) Persistencia.getInstance().buscarAluno(usuario.getChavePrimaria());
	}
	
	@Override
	public Aluno buscarAluno(String matricula){
		return (Aluno) Persistencia.getInstance().buscarAluno(matricula);
	}
	
	@Override
	public String getNomeClasseEntidade() {
		
		return AlunoImpl.class.getSimpleName();
	}
	
	
	@Override
	public boolean verificarPapelDeAlunoDoUsuario(Usuario usuario) {
		boolean isAluno = Boolean.TRUE;
		Long quantidade = Persistencia.getInstance().buscarQuantidadeDeAlunos(usuario.getChavePrimaria());
		if ( quantidade.longValue() == 0L ) {
			isAluno = Boolean.FALSE;
		}
		return isAluno;
	}

	
}
