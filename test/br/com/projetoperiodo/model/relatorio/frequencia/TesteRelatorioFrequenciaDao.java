
package br.com.projetoperiodo.model.relatorio.frequencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.JPARelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;
import br.com.projetoperiodo.util.persistencia.jpa.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class TesteRelatorioFrequenciaDao {

	private static RelatorioFrequenciaDao relatorioDao = CreatorFabrica.
					createFactory(CreatorFabrica.FABRICA_JPA).criarRelatorioFrequenciaDAO();


	@AfterClass
	public static void tearDown()  {

		JPAUtil.getInstance().destroyInstance();
	}
	
	@Test
	public void testeInserirRelatorioFrequencia() {

		int qtdIncio = relatorioDao.listar().size();
		relatorioDao.salvar(montarObjetoRelatorioFrequencia());
		int qtdFim = relatorioDao.listar().size();
		assertEquals(qtdIncio + 1, qtdFim);
	}

	@Test
	public void testeRemoverRelatorioFrequencia() {
		RelatorioFrequencia relatorio = montarObjetoRelatorioFrequencia();
		relatorioDao.salvar(relatorio);
		
		int qtdInicio = relatorioDao.listar().size();
		relatorioDao.remover(relatorio);
		int qtdFim = relatorioDao.listar().size();
		assertEquals(qtdInicio - 1, qtdFim);
	}
	
	@Test
	public void testeAlterarRelatorioFrequencia() {
		RelatorioFrequencia relatorio = montarObjetoRelatorioFrequencia();
		relatorioDao.salvar(relatorio);
		
		RelatorioFrequencia relatorioPesquisado = relatorioDao.
						buscar(relatorio.getChavePrimaria());
		assertNotNull(relatorioPesquisado);
		int cargaHorariaAntesAlteracao = relatorioPesquisado.getCargaHorariaMensal();
		relatorioPesquisado.setCargaHorariaMensal(120);
		
		relatorioDao.atualizar(relatorioPesquisado);
		int cargaHorariaAposAlteracao = relatorioDao.buscar(relatorioPesquisado.getChavePrimaria()).
						getCargaHorariaMensal();
		assertFalse(cargaHorariaAntesAlteracao == cargaHorariaAposAlteracao);
		
		
	}
	
	public RelatorioFrequencia montarObjetoRelatorioFrequencia() {

		RelatorioFrequencia relatorioFrequencia = new RelatorioFrequenciaImpl();
		relatorioFrequencia.setMes(8);
		relatorioFrequencia.setCargaHorariaMensal(80);
		relatorioFrequencia.setDataEntregaRelatorio(new Date());
		relatorioFrequencia.setSemanas(montarObjetoSemana(relatorioFrequencia));
		relatorioFrequencia.setSemanas(montarObjetoSemana(relatorioFrequencia));
		relatorioFrequencia.setSemanas(montarObjetoSemana(relatorioFrequencia));
		relatorioFrequencia.setSemanas(montarObjetoSemana(relatorioFrequencia));
		relatorioFrequencia.setSemanas(montarObjetoSemana(relatorioFrequencia));
		relatorioFrequencia.setUltimaAlteracao( Calendar.getInstance().getTime() );
		return relatorioFrequencia;
	}

	public Semana montarObjetoSemana(RelatorioFrequencia relatorio) {

		Semana semana = new SemanaImpl();
		semana.setDescricao("Fazendo levantamento bibliográfico");
		semana.setObservacoes("Atividade realizada fora da instituição");
		semana.setRelatorio(relatorio);
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setAtividades(montarObjetoAtividade(semana));
		semana.setUltimaAlteracao(Calendar.getInstance().getTime());
		return semana;
	}

	public Atividade montarObjetoAtividade(Semana semana) {

		Atividade atividade = new AtividadeImpl();
		atividade.setData(new Date());
		atividade.setHorarioEntrada("14:00");
		atividade.setHorarioSaida("18:00");
		atividade.setSemana(semana);
		atividade.setUltimaAlteracao(Calendar.getInstance().getTime());
		return atividade;
	}

}
