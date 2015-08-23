
package projeto_periodo;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.ConnectionFactory;
import dao.DAO;
import dao.RelatorioFrequenciaDao;
import model.Aluno;
import model.Atividade;
import model.Disciplina;
import model.Funcionario;
import model.Monitor;
import model.Orientador;
import model.RelatorioFrequencia;
import model.Semana;

public class TesteRelatorioFrequenciaDao {

	private DAO dao;
	private Connection connection;
	
	@Before
	public void setUp() {

		connection = new ConnectionFactory().getConnection();
		dao = new RelatorioFrequenciaDao(connection);
	}
	
	@After
	public void tearDown() throws SQLException {
		connection.close();
	}
	
	@Test
	public void testeInserirRelatorioFrequencia() {
		int qtdIncio = dao.listar().size();
		dao.inserir(montarObjetoRelatorioFrequencia());
		int qtdFim = dao.listar().size();
		assertEquals(qtdIncio + 1, qtdFim);	
	}

	public Monitor montarObjetoMonitor() {
		Monitor monitor = new Monitor();
		monitor.setMatricula("20141Y6-RC0323");
		return monitor;
	}

	public RelatorioFrequencia montarObjetoRelatorioFrequencia() {

		RelatorioFrequencia relatorioFrequencia = new RelatorioFrequencia();
		relatorioFrequencia.setAno(2015);
		relatorioFrequencia.setMes(8);
		relatorioFrequencia.setCargaHorariaMensal(80);
		relatorioFrequencia.setOrientador(montarObjetoOrientador());
		relatorioFrequencia.setFuncionario(montarObjetoFuncionario());
		relatorioFrequencia.setMonitor(montarObjetoMonitor());
		Collection<Semana> semanas = new ArrayList<Semana>();
		for( int i = 0; i < 5; i++ ) {
			semanas.add(montarObjetoSemana());
		}
		relatorioFrequencia.setSemanas(semanas);
		relatorioFrequencia.setEdital("2015.1");
		relatorioFrequencia.setDataEntregaRelatorio( new Date() );
		return relatorioFrequencia;
	}

	public Funcionario montarObjetoFuncionario() {

		Funcionario funcionario = new Funcionario();
		funcionario.setSiape("5847560");
		return funcionario;
	}

	public Orientador montarObjetoOrientador() {
		Orientador orientador = new Orientador();
		orientador.setSiape("1428475");
		return orientador;
	}
	
	public Semana montarObjetoSemana() {
		Semana semana = new Semana();
		semana.setDescricao("Fazendo levantamento bibliográfico");
		semana.setObservacoes("Atividade realizada fora da instituição");
		Collection<Atividade> atividades = new ArrayList<Atividade>();
		for( int i = 0; i < 5; i++ ) {
			atividades.add(montarObjetoAtividade());
		}
		semana.setAtividades(atividades);
		return semana;
	}
	
	public Atividade montarObjetoAtividade() {
	
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2015);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 
						Calendar.getInstance().getFirstDayOfWeek());
		Atividade atividade = new Atividade();
		atividade.setData( calendar.getTime() );
		atividade.setHorarioEntrada( "14:00" );
		atividade.setHorarioSaida( "18:00" );
		return atividade;
	}
	

}
