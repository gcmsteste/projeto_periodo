package br.com.projetoperiodo.model.relatorio.semana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.controller.ControladorRelatorio;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;


public class TesteSemanaDao {

	private static SemanaDao dao = CreatorFabrica.
					createFactory(CreatorFabrica.FABRICA_JPA).criarSemanaDAO();
	
	@AfterClass
	public static void close() {
		JPAUtil.getInstance().destroyInstance();
	}
	
	@Test
	public void testeInserirSemana() {
		
		int qtdInicio = dao.listar(" from SemanaImpl ").size();
		dao.salvar(montarObjetoSemana());
		int qtdFim = dao.listar("").size();
		assertEquals(qtdInicio + 1, qtdFim);
	}
	
	@Test
	public void testeRemoverSemana() {
		Semana semana = montarObjetoSemana();
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
		Semana semanaPesquisada = dao.buscar(semana.getChavePrimaria());
		assertNotNull(semanaPesquisada);
		semana.getAtividade(0);
		semanaPesquisada.getAtividade(0).getSemana();
		assertNotNull(semanaPesquisada.getAtividade(0));
		
		
		
	}
	
	@Test
	public void testeAlterarSemana() {
		Semana semana = montarObjetoSemana();
		dao.salvar(semana);
		
		Semana semanaPesquisada = dao.buscar(semana.getChavePrimaria());
		assertNotNull(semanaPesquisada);
		String descricaoAltesAlteracao = semanaPesquisada.getDescricao();
		assertNotNull(descricaoAltesAlteracao);
		semanaPesquisada.setDescricao("Corrigindo exercícios");
		
		dao.alterar(semanaPesquisada);
		
		String descricaoPosAlteracao = dao.buscar(semanaPesquisada.getChavePrimaria()).
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
		semana.setUltimaAlteracao( Calendar.getInstance().getTime() );
		return semana;
	}
	
	private Atividade montarObjetoAtividade(Semana semana) {
		Atividade atividade = new AtividadeImpl();
		atividade.setHorarioEntrada("09:00");
		atividade.setHorarioSaida("12:00");
		atividade.setData(new Date());
		atividade.setSemana(semana);
		atividade.setUltimaAlteracao( Calendar.getInstance().getTime() );
		return atividade;
	}

}
