package br.com.projetoperiodo.model.relatorio.semana;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.semana.dao.JPASemanaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.JPAUtil;


public class TesteSemanaDao {
	private static SemanaDao dao;
	
	@BeforeClass
	public static void setUp() {
		dao = new JPASemanaDao();
	}
	@AfterClass
	public static void close() {
		FabricaJPA.getInstancia().closeEntityManagerFactory();
	}
	@Test
	public void testeInserirSemana() {
		int qtdInicio = dao.listar().size();
		dao.salvar(montarObjetoSemana());
		int qtdFim = dao.listar().size();
		assertEquals(qtdInicio + 1, qtdFim);
	}
	
	@Test
	public void testeRemoverSemana() {
		SemanaImpl semana = montarObjetoSemana();
		dao.salvar(semana);
		
		int qtdInicio = dao.listar().size();
		dao.remover(semana);
		int qtdFim = dao.listar().size();
		assertEquals(qtdInicio - 1, qtdFim);
	}
	
	@Test
	public void testeBuscarSemana() {
		Semana semana = montarObjetoSemana();
		dao.salvar(semana);
		Semana semanaPesquisada = dao.buscar(semana.getId());
		assertNotNull(semanaPesquisada);
		semana.getAtividades(0);
		semanaPesquisada.getAtividades(0).getSemana();
		assertNotNull(semanaPesquisada.getAtividades(0));
		
		
		
	}
	
	@Test
	public void testeAlterarSemana() {
		Semana semana = montarObjetoSemana();
		dao.salvar(semana);
		
		SemanaImpl semanaPesquisada = dao.buscar(semana.getId());
		assertNotNull(semanaPesquisada);
		String descricaoAltesAlteracao = semanaPesquisada.getDescricao();
		assertNotNull(descricaoAltesAlteracao);
		semanaPesquisada.setDescricao("Corrigindo exercícios");
		
		dao.alterar(semanaPesquisada);
		
		String descricaoPosAlteracao = dao.buscar(semanaPesquisada.getId()).
						getDescricao();
		
		assertNotEquals(descricaoAltesAlteracao, descricaoPosAlteracao);
	}
	
	private SemanaImpl montarObjetoSemana() {
		SemanaImpl semana = new SemanaImpl();
		semana.setDescricao("Levantamento bibliográfico");
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		return semana;
	}
	
	private AtividadeImpl montarObjetoAtividade(Semana semana) {
		AtividadeImpl atividade = new AtividadeImpl();
		atividade.setHorarioEntrada("09:00");
		atividade.setHorarioSaida("12:00");
		atividade.setData(new Date());
		atividade.setSemana(semana);
		return atividade;
	}

}
