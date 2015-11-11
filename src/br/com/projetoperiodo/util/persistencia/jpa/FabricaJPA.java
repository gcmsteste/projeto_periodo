package br.com.projetoperiodo.util.persistencia.jpa;

import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.dao.JPAAlunoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.JPACursoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.JPADisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.JPAMonitorDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.JPAPeriodoDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.instituto.professor.dao.JPAProfessorDao;
import br.com.projetoperiodo.model.instituto.professor.dao.ProfessorDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.JPAAtividadeDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.JPARelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.JPASemanaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.usuario.dao.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.util.persistencia.dao.FabricaDAO;

public class FabricaJPA extends FabricaDAO {

	private static FabricaJPA instance = null;
	
	private FabricaJPA() { }
	public static FabricaJPA getInstance() {
		if ( instance == null ) {
			instance = new FabricaJPA();
		}
		return instance;
	}
	@Override
	public UsuarioDao criarUsuarioDAO() {

		return new JPAUsuarioDao();
	}

	@Override
	public RelatorioFrequenciaDao criarRelatorioFrequenciaDAO() {

		return new JPARelatorioFrequenciaDao();
	}

	@Override
	public SemanaDao criarSemanaDAO() {

		return new JPASemanaDao();
	}

	@Override
	public AtividadeDao criarAtividadeDAO() {

		return new JPAAtividadeDao();
	}

	@Override
	public MonitorDao criarMonitorDAO() {

		return new JPAMonitorDao();
	}

	@Override
	public AlunoDao criarAlunoDAO() {

		return new JPAAlunoDao();
	}

	@Override
	public DisciplinaDao criarDisciplinaDAO() {

		return new JPADisciplinaDao();
	}

	@Override
	public CursoDao criarCursoDAO() {

		return new JPACursoDao();
	}

	@Override
	public ProfessorDao criarProfessorDao() {

		return new JPAProfessorDao();
	}

	@Override
	public PeriodoDao criarPeriodoDao() {

		return new JPAPeriodoDao();
	}

}
