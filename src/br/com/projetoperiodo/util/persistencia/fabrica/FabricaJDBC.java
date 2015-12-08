
package br.com.projetoperiodo.util.persistencia.fabrica;

import br.com.projetoperiodo.model.documentos.dao.DocumentDao;
import br.com.projetoperiodo.model.documentos.dao.JDBCDocumentDao;
import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.instituto.professor.dao.ProfessorDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;

public class FabricaJDBC extends FabricaDAO {

	private static FabricaJDBC instance;
	//sql.Connection connection = (sql.Connection)connection.getConnection();
	private FabricaJDBC() {
	}

	public static FabricaDAO getInstance() {

		if (instance == null) {
			instance = new FabricaJDBC();
		}
		return instance;
	}

	@Override
	public UsuarioDao criarUsuarioDAO() {

		return null;
	}

	@Override
	public RelatorioFrequenciaDao criarRelatorioFrequenciaDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SemanaDao criarSemanaDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtividadeDao criarAtividadeDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonitorDao criarMonitorDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoDao criarAlunoDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisciplinaDao criarDisciplinaDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoDao criarCursoDAO() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorDao criarProfessorDao() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PeriodoDao criarPeriodoDao() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDao criarDocumentDao() {
		return new JDBCDocumentDao();
	}

}
