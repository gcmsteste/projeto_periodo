
package br.com.projetoperiodo.relatorio;

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

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.curso.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.funcionario.Funcionario;
import br.com.projetoperiodo.model.instituto.orientador.Orientador;
import br.com.projetoperiodo.model.relatorio.Atividade;
import br.com.projetoperiodo.model.relatorio.JDBCRelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.Semana;
import br.com.projetoperiodo.util.persistencia.ConnectionFactory;

public class TesteRelatorioFrequenciaDao {

	private RelatorioFrequenciaDao dao;
	private Connection connection;
	
	@Before
	public void setUp() {

		connection = new ConnectionFactory().getConnection();
		dao = new JDBCRelatorioFrequencia(connection);
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
	

	public void testeAtualizarRelatorioFrequencialDao(){
		Collection<Object> relatorios = dao.listar();
		RelatorioFrequencia relatorio = (RelatorioFrequencia)relatorios.iterator().next();
		
		//dao.atualizar();
		
	}
	/*
	public Monitor montarObjetoMonitorParaUpdate(){
		Monitor monitor = new Monitor();
			monitor.setEmail("douglasalbuquerque95@gmail.com");
			monitor.setMatricula("20141Y6-RC0439");
			monitor.setNome("Douglas Albuquerque");
		return monitor;
	}
	
	public Disciplina montarObjetoDisciplinaParaUpdate(){
		Disciplina disciplina = new Disciplina();
			disciplina.setDescricao("WEB II");
			ArrayList<Aluno> pagantes = new ArrayList<Aluno>();
			pagantes.add(monitor);
			disciplina.setPagantes(pagantes);
		return disciplina;
	}
	
	public RelatorioFrequencia montarObjetoRelatorioFrequenciaParaUpdate(){
		RelatorioFrequencia relatorioFrequencia = new RelatorioFrequencia();
			relatorioFrequencia.setMes(7);
			relatorioFrequencia.setAno(2015);
			relatorioFrequencia.setCargaHorariaMensal(80);
			relatorioFrequencia.setEdital("2015.1");
			relatorioFrequencia.setOrientador(this.orientador);
			relatorioFrequencia.setMonitor(this.monitor);
			//relatorioFrequencia.setDataEntregaRelatorio(dataEntregaRelatorio);
			relatorioFrequencia.setFuncionario(this.funcionario);
			Collection<Semana> semanas = new ArrayList<Semana>();
			semanas.add(this.semana);
			relatorioFrequencia.setSemanas(semanas);
		return relatorioFrequencia;
	}

	public Funcionario montarObjetoFuncionarioParaUpdate(){
		Funcionario funcionario = new Funcionario();
			funcionario.setSiape("1234765");
			funcionario.setEmail("funcionario1@ifpe.com.br");
			funcionario.setNome("Severino");
		return funcionario;
	}
	
	public Orientador montarObjetoOrientadorParaUpdate(){
		Orientador orientador = new Orientador();
			orientador.setNome("Paulo Abadie");
			orientador.setSiape("1237654");
			orientador.setDisciplina(this.disciplina);
		return orientador;
	}
	
	public Semana montarObjetoSemanaParaUpdate(){
		Semana semana = new Semana();
			semana.setDescricao("Introdu褯 a conceitos de OO");
			semana.setDescricao("Atividade realizada na pr󰲩a Institui褯");
			Collection<Atividade> atividades = new ArrayList<Atividade>();
			atividades.add(this.atividade);
			semana.setAtividades(atividades);
		return semana;
	}
	
	public Atividade montarObjetoAtividadeParaUpdate(){
		Atividade atividade = new Atividade();
			atividade.setHorarioEntrada("13:00");
			atividade.setHorarioSaida("17:00");
			atividade.setData(new Date());
		return atividade;
	}
	
	public void montarCenarioParaUpdateTeste(){
		this.monitor = montarObjetoMonitorParaUpdate();
		this.disciplina = montarObjetoDisciplinaParaUpdate();
		this.monitor.setDisciplina(this.disciplina);
		Collection<Aluno> pagantes = new ArrayList<Aluno>();
		pagantes.add(this.monitor);
		//this.
		this.funcionario = montarObjetoFuncionarioParaUpdate();
		this.orientador = montarObjetoOrientadorParaUpdate();
		this.semana = montarObjetoSemanaParaUpdate();
		this.atividade = montarObjetoAtividadeParaUpdate();
		this.disciplina.setPagantes(pagantes);
	} */

}
