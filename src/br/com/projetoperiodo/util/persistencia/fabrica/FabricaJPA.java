
package br.com.projetoperiodo.util.persistencia.fabrica;

import javax.persistence.EntityManagerFactory;

import br.com.projetoperiodo.model.documento.dao.DocumentDao;
import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.dao.JPAAlunoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.JPACursoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.JPADisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.JPAMonitoriaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitoriaDao;
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
import br.com.projetoperiodo.util.persistencia.connection.JPAConnectionFactory;
import br.com.projetoperiodo.util.persistencia.persistencia.DatabaseUnit;

public class FabricaJPA extends FabricaDAO {

	private EntityManagerFactory entityManagerFactory = null;
	
	public FabricaJPA(DatabaseUnit unit) {
		super.connectionFactory = new JPAConnectionFactory(unit);
		this.entityManagerFactory = (EntityManagerFactory) super.connectionFactory.getConnection();
	}


	@Override
	public UsuarioDao criarUsuarioDAO() {

		return new JPAUsuarioDao(entityManagerFactory);
	}

	@Override
	public RelatorioFrequenciaDao criarRelatorioFrequenciaDAO() {

		return new JPARelatorioFrequenciaDao(this.entityManagerFactory);
	}

	@Override
	public SemanaDao criarSemanaDAO() {

		return new JPASemanaDao(this.entityManagerFactory);
	}

	@Override
	public AtividadeDao criarAtividadeDAO() {

		return new JPAAtividadeDao(this.entityManagerFactory);
	}

	@Override
	public MonitoriaDao criarMonitoriaDAO() {

		return new JPAMonitoriaDao(entityManagerFactory);
	}

	@Override
	public AlunoDao criarAlunoDAO() {

		return new JPAAlunoDao(entityManagerFactory);
	}

	@Override
	public DisciplinaDao criarDisciplinaDAO() {

		return new JPADisciplinaDao(entityManagerFactory);
	}

	@Override
	public CursoDao criarCursoDAO() {

		return new JPACursoDao(entityManagerFactory);
	}

	@Override
	public ProfessorDao criarProfessorDao() {

		return new JPAProfessorDao(entityManagerFactory);
	}

	@Override
	public PeriodoDao criarPeriodoDao() {

		return new JPAPeriodoDao(entityManagerFactory);
	}

	@Override
	public DocumentDao criarDocumentDao() {

		return null;
	}


	@Override
	public void fecharFabrica() {
		this.entityManagerFactory.close();
	}

}
