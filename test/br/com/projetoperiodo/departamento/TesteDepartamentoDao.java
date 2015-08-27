
package br.com.projetoperiodo.departamento;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.departamento.Departamento;
import br.com.projetoperiodo.model.instituto.departamento.DepartamentoDao;
import br.com.projetoperiodo.model.instituto.departamento.HibernateDepartamentoDao;
import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class TesteDepartamentoDao {

	private DepartamentoDao departamentoDao;

	@Before
	public void setUp() {

		departamentoDao = new HibernateDepartamentoDao();
	}

	@Test
	public void testeInserirDepartamento() {
		int qtdInicio = departamentoDao.listar().size();
		departamentoDao.salvar(montarObjetoDepartamento());
		int qtdFim = departamentoDao.listar().size();
		Assert.assertEquals(qtdInicio + 1, qtdFim);
	}

	private Departamento montarObjetoDepartamento() {
		Departamento departamento = new Departamento();
		departamento.setDescricao( "Departamento de Pesquisa" );
		departamento.setDescricaoAbreviada("DPE");
		return departamento;
	}

	@After
	public void close() {
		HibernateUtil.getSessionFactory().close();
	}
}
