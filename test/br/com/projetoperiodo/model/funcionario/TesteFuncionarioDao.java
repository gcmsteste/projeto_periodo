package br.com.projetoperiodo.model.funcionario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.departamento.Departamento;
import br.com.projetoperiodo.model.instituto.funcionario.Funcionario;
import br.com.projetoperiodo.model.instituto.funcionario.FuncionarioDao;
import br.com.projetoperiodo.model.instituto.funcionario.HibernateFuncionarioDao;
import br.com.projetoperiodo.model.instituto.funcionario.JPAFuncionarioDao;
import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;

public class TesteFuncionarioDao {
	
	private FuncionarioDao funcionarioDao;
	
	@Before
	public void setUp() {
		funcionarioDao = new JPAFuncionarioDao();
	}
	@Test
	public void testeInserirFuncionario() {
		int qtdInicio = funcionarioDao.listar().size();
		funcionarioDao.salvar(montarObjetoFuncionario());
		int qtdFim = funcionarioDao.listar().size();
		Assert.assertEquals(qtdInicio + 1, qtdFim);
	}
	private Funcionario montarObjetoFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setSiape("5847560");
		return funcionario;
	}
	
	private Usuario montarObjetoUsuario() {
		Usuario usuario = new UsuarioImpl();
		usuario.setLogin("FUNCIONARIOLOGIN");
		return usuario;
	}
	
	
	
}
