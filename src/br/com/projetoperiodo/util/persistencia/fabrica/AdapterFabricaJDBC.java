package br.com.projetoperiodo.util.persistencia.fabrica;

import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitoriaDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.instituto.professor.dao.ProfessorDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.util.persistencia.persistencia.DatabaseUnit;

public class AdapterFabricaJDBC extends FabricaJDBC {

	public FabricaDAO fabrica;
	
	public AdapterFabricaJDBC(DatabaseUnit unit, FabricaDAO dao) {
		super(unit);
		this.fabrica = dao;
	}
	
	@Override
	public AlunoDao criarAlunoDAO() {
	
		return fabrica.criarAlunoDAO();
	}
	
	@Override
	public AtividadeDao criarAtividadeDAO() {
	
		return fabrica.criarAtividadeDAO();
	}
	
	@Override
	public DisciplinaDao criarDisciplinaDAO() {
	
		return fabrica.criarDisciplinaDAO();
	}

	@Override
	public RelatorioFrequenciaDao criarRelatorioFrequenciaDAO() {
		return fabrica.criarRelatorioFrequenciaDAO();
	}

	@Override
	public SemanaDao criarSemanaDAO() {
		return fabrica.criarSemanaDAO();
	}
	
	@Override
	public UsuarioDao criarUsuarioDAO() {
	
		return fabrica.criarUsuarioDAO();
	}

	@Override
	public MonitoriaDao criarMonitoriaDAO() {

		return fabrica.criarMonitoriaDAO();
	}

	@Override
	public ProfessorDao criarProfessorDao() {

		return fabrica.criarProfessorDao();
	}

	
	@Override
	public void fecharFabrica() {
	
		super.fecharFabrica();
		this.fabrica.fecharFabrica();
	}
}
