package br.com.projetoperiodo.model.relatorio.atividade;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.JPAAtividadeDao;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.JPAUtil;


public class TesteAtividadeDao {

	private static AtividadeDao dao;
	
	@BeforeClass
	public static void setUp() {
		dao = new JPAAtividadeDao();
	}
	
	@AfterClass
	public static void close() {
		FabricaJPA.getInstancia().closeEntityManagerFactory();
	}
	
	@Test
	public void testeInserirAtividade() {

		int qtdInicio = dao.listar().size();
		dao.salvar(montarObjetoAtividade());
		int qtdFim = dao.listar().size();
		Assert.assertEquals(qtdInicio + 1, qtdFim);
	}
	
	@Test
	public void testeRemoverAtividade() {
		AtividadeImpl atividade = montarObjetoAtividade();
		dao.salvar(atividade);
		
		int qtdInicio = dao.listar().size();
		dao.remover(atividade);
		int qtdFim = dao.listar().size();
		Assert.assertEquals(qtdInicio - 1, qtdFim );
	}
	
	@Test
	public void testeAlterarAtividade() {
		Atividade atividadeInserida = montarObjetoAtividade();
		dao.salvar(atividadeInserida);
		
		AtividadeImpl atividadePesquisada = dao.
						buscar(atividadeInserida.getId());
		Assert.assertNotNull(atividadePesquisada);
		String horarioAntesAlteracao = atividadePesquisada.
						getHorarioEntrada();
		atividadePesquisada.setHorarioEntrada("13:00");
		dao.alterar(atividadePesquisada);
		
		String horarioPosAlteracao = dao.buscar
						(atividadePesquisada.getId()).getHorarioEntrada();
		Assert.assertNotNull(horarioPosAlteracao);
		Assert.assertNotEquals(horarioAntesAlteracao, horarioPosAlteracao );
		
	}
	
	public AtividadeImpl montarObjetoAtividade() {
		AtividadeImpl atividade = new AtividadeImpl();
		atividade.setData( new Date() );
		atividade.setHorarioEntrada("14:00");
		atividade.setHorarioSaida("18:00");
		return atividade;
	}
	

}
