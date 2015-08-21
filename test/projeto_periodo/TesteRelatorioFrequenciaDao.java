
package projeto_periodo;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
	private ConnectionFactory connection;
	private Orientador orientador;
	private Funcionario funcionario;
	private Disciplina disciplina;
	private Monitor monitor;
	private RelatorioFrequencia relatorioFrequencia;
	private Semana semana;
	private Atividade atividade;
	
	@Before
	public void setUp() {

		connection = new ConnectionFactory();
		dao = new RelatorioFrequenciaDao(connection.getConnection());

	}

	@Test
	public void testeInserirRelatorioFrequenciaDao() {

		dao.inserir(this.relatorioFrequencia);
		Collection<Object> lista = dao.listar();
		assertNotNull(lista);
		RelatorioFrequencia relatorio = (RelatorioFrequencia)lista.iterator().next();
		

	}

	public Monitor montarObjetoMonitor() {

		Monitor monitor = new Monitor();
		monitor.setEmail("edmilsonsantana2@hotmail.com");
		monitor.setMatricula("20141Y6-RC0323");
		monitor.setNome("Edmilson Santana");
		return monitor;
	}

	public Disciplina montarObjetoDisciplina() {

		Disciplina disciplina = new Disciplina();
		disciplina.setDescricao("Padrões de Projeto");
		ArrayList<Aluno> pagantes = new ArrayList<Aluno>();
		pagantes.add(this.monitor);
		disciplina.setPagantes(pagantes);
		return disciplina;

	}

	public RelatorioFrequencia montarObjetoRelatorioFrequencia() {

		RelatorioFrequencia relatorioFrequencia = new RelatorioFrequencia();
		relatorioFrequencia.setAno(2015);
		relatorioFrequencia.setMes(8);
		relatorioFrequencia.setCargaHorariaMensal(80);
		relatorioFrequencia.setOrientador(this.orientador);
		relatorioFrequencia.setFuncionario(this.funcionario);
		relatorioFrequencia.setMonitor(this.monitor);
		Collection<Semana> semanas = new ArrayList<Semana>();
		semanas.add(this.semana);
		relatorioFrequencia.setSemanas(semanas);
		relatorioFrequencia.setEdital("2015.1");
		return relatorioFrequencia;
	}

	public Funcionario montarObjetoFuncionario() {

		Funcionario funcionario = new Funcionario();
		funcionario.setSiape("1234567");
		funcionario.setEmail("funcionario@ifpe.com.br");
		funcionario.setNome("João");
		return funcionario;
	}

	public Orientador montarObjetoOrientador() {
		Orientador orientador = new Orientador();
		orientador.setSiape("2934834");
		orientador.setNome("Marcos André");
		orientador.setDisciplina(this.disciplina);
		return orientador;
	}
	
	public Semana montarObjetoSemana() {
		Semana semana = new Semana();
		semana.setDescricao("Fazendo levantamento bibliográfico");
		semana.setObservacoes("Atividade realizada fora da instituição");
		Collection<Atividade> atividades = new ArrayList<Atividade>();
		atividades.add(this.atividade);
		semana.setAtividades(atividades);
		return semana;
	}
	
	public Atividade montarObjetoAtividade() {
		Atividade atividade = new Atividade();
		atividade.setData( new Date());
		atividade.setHorarioEntrada( "14:00" );
		atividade.setHorarioSaida( "18:00" );
		return atividade;
	}
	
	public void montarCenario() {
		this.funcionario = montarObjetoFuncionario();
		this.orientador = montarObjetoOrientador();
		this.monitor = montarObjetoMonitor();
		this.disciplina = montarObjetoDisciplina();
		this.monitor.setDisciplina(this.disciplina);
		Collection<Aluno> pagantes = new ArrayList<Aluno>();
		pagantes.add(this.monitor);
		this.disciplina.setPagantes(pagantes);
		this.orientador = montarObjetoOrientador();
		this.atividade = montarObjetoAtividade();
		this.semana = montarObjetoSemana();
		
	}

}
