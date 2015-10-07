package br.com.projetoperiodo.model.relatorio.atividade;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;


public class TesteAtividadeDao {

	private static AtividadeDao dao = CreatorFabrica.
					createFactory(CreatorFabrica.FABRICA_JPA).criarAtividadeDAO();
	
	@AfterClass
	public static void close() {
		JPAUtil.getInstance().destroyInstance();
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
		Atividade atividade = montarObjetoAtividade();
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
		
		Atividade atividadePesquisada = dao.
						buscar(atividadeInserida.getChavePrimaria());
		Assert.assertNotNull(atividadePesquisada);
		String horarioAntesAlteracao = atividadePesquisada.
						getHorarioEntrada();
		atividadePesquisada.setHorarioEntrada("13:00");
		dao.alterar(atividadePesquisada);
		
		String horarioPosAlteracao = dao.buscar
						(atividadePesquisada.getChavePrimaria()).getHorarioEntrada();
		Assert.assertNotNull(horarioPosAlteracao);
		Assert.assertNotEquals(horarioAntesAlteracao, horarioPosAlteracao );
		
	}
	
	public Atividade montarObjetoAtividade() {
		Atividade atividade = new AtividadeImpl();
		atividade.setData( new Date() );
		atividade.setHorarioEntrada("14:00");
		atividade.setHorarioSaida("18:00");
		atividade.setUltimaAlteracao( Calendar.getInstance().getTime() );
		return atividade;
	}
	

}
