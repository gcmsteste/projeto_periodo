
package br.com.projetoperiodo.model.relatorio.frequencia;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.departamento.Departamento;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.funcionario.Funcionario;
import br.com.projetoperiodo.model.instituto.orientador.Orientador;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.JPARelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Grau;
import br.com.projetoperiodo.util.constantes.Modalidade;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class TesteRelatorioFrequenciaDao {

	private RelatorioFrequenciaDao dao;

	@Before
	public void setUp() {

		dao = new JPARelatorioFrequenciaDao();
		// montarCenario();
	}

	@After
	public void tearDown() throws SQLException {

		JPAUtil.getEntityManagerFactory().close();
	}

	@Test
	public void testeInserirRelatorioFrequencia() {

		int qtdIncio = dao.listar().size();
		dao.salvar(montarCenario());
		int qtdFim = dao.listar().size();
		assertEquals(qtdIncio + 1, qtdFim);
	}

	public Monitor montarObjetoMonitor() {

		Monitor monitor = new Monitor();
		monitor.setMatricula("20141Y6-RC0323");
		monitor.setEmail("monitor@email.com");
		monitor.setLogin("Monitor");
		monitor.setNome("Fernando");
		monitor.setModalidade(Modalidade.BOLSISTA);
		monitor.setSenha(Util.criptografarSenha("monitor123", Util.CONSTANTE_CRIPTOGRAFIA));
		return monitor;
	}

	public RelatorioFrequencia montarObjetoRelatorioFrequencia(Monitor monitor, Orientador orientador) {

		RelatorioFrequencia relatorioFrequencia = new RelatorioFrequencia();
		relatorioFrequencia.setAno(2015);
		relatorioFrequencia.setMes(8);
		relatorioFrequencia.setCargaHorariaMensal(80);
		relatorioFrequencia.setOrientador(orientador);
		relatorioFrequencia.setFuncionario(montarObjetoFuncionario());
		relatorioFrequencia.setMonitor(monitor);
		Collection<Semana> semanas = new ArrayList<Semana>();
		for (int i = 0; i < 5; i++) {
			semanas.add(montarObjetoSemana(relatorioFrequencia));
		}
		relatorioFrequencia.setSemanas(semanas);
		relatorioFrequencia.setEdital("2015.1");
		relatorioFrequencia.setDataEntregaRelatorio(new Date());
		return relatorioFrequencia;
	}

	public Funcionario montarObjetoFuncionario() {

		Funcionario funcionario = new Funcionario();
		funcionario.setSiape("5847560");
		funcionario.setLogin("funcionariologin");
		funcionario.setEmail("funcionario@email.com");
		funcionario.setSenha(Util.criptografarSenha("funcionario123", 
						Util.CONSTANTE_CRIPTOGRAFIA));
		funcionario.setDepartamento(montarObjetoDepartamento());
		return funcionario;
	}

	public Departamento montarObjetoDepartamento() {

		Departamento departamento = new Departamento();
		departamento.setDescricao("Direção de Ensino");
		departamento.setDescricaoAbreviada("DEN");
		return departamento;
	}

	public Orientador montarObjetoOrientador() {

		Orientador orientador = new Orientador();
		orientador.setSiape("1428475");
		orientador.setNome("Roberto");
		return orientador;
	}

	public Disciplina montarObjetoDisciplina() {

		Disciplina disciplina = new Disciplina();
		disciplina.setDescricao("Desenvolvimento WEB 2");
		return disciplina;
	}

	public Curso montarObjetoCurso() {

		Curso curso = new Curso();
		curso.setModalidade(Grau.SUPERIOR);
		curso.setDescricao("Análise de Sistemas");
		return curso;
	}

	public Semana montarObjetoSemana(RelatorioFrequencia relatorio) {

		Semana semana = new Semana();
		semana.setDescricao("Fazendo levantamento bibliográfico");
		semana.setObservacoes("Atividade realizada fora da instituição");
		Collection<Atividade> atividades = new ArrayList<Atividade>();
		for (int i = 0; i < 5; i++) {
			atividades.add(montarObjetoAtividade());
		}
		semana.setAtividades(atividades);
		semana.setRelatorio(relatorio);
		return semana;
	}

	public Atividade montarObjetoAtividade() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2015);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getFirstDayOfWeek());
		Atividade atividade = new Atividade();
		atividade.setData(calendar.getTime());
		atividade.setHorarioEntrada("14:00");
		atividade.setHorarioSaida("18:00");
		return atividade;
	}

	public RelatorioFrequencia montarCenario() {

		Curso curso = montarObjetoCurso();
		Disciplina disciplina = montarObjetoDisciplina();
		disciplina.setCurso(curso);
		Orientador orientador = montarObjetoOrientador();
		orientador.setDisciplina(disciplina);
		
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(disciplina);
		Monitor monitor = montarObjetoMonitor();
		monitor.setCurso(curso);
		monitor.setDisciplinas(disciplinas);
		monitor.setDisciplina(disciplina);
		RelatorioFrequencia relatorio = 
						montarObjetoRelatorioFrequencia(monitor, orientador);
		return relatorio;
	}

}
