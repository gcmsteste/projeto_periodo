
package br.com.projetoperiodo.model.instituto.aluno.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;

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
		CreatorFabrica.getFabricaDAO().criarAlunoDAO().salvar(aluno);
		return aluno;
	}
	@Override
	public Aluno buscarUsuarioAluno(Usuario usuario) {
		return CreatorFabrica.getFabricaDAO().criarAlunoDAO().buscar(usuario.getChavePrimaria());
	}
	
	@Override
	public Aluno buscarAluno(String matricula){
		return CreatorFabrica.getFabricaDAO().criarAlunoDAO().buscarPelaMatricula(matricula);
	}
	
	@Override
	public String getNomeClasseEntidade() {
		
		return AlunoImpl.class.getSimpleName();
	}
	
	
	@Override
	public boolean verificarPapelDeAlunoDoUsuario(Usuario usuario) {
		boolean isAluno = Boolean.TRUE;
		StringBuilder builder = new StringBuilder();
		builder.append(" select count(*) ");
		builder.append(" from ");
		builder.append(this.getNomeClasseEntidade());
		builder.append(" a ");
		builder.append(" where a.chavePrimaria = ");
		builder.append(usuario.getChavePrimaria());
		Long quantidade = CreatorFabrica.getFabricaDAO().criarAlunoDAO().buscarQuantidadeAlunos(builder.toString());
		if ( quantidade.longValue() == 0L ) {
			isAluno = Boolean.FALSE;
		}
		return isAluno;
	}

	
}
