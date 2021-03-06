package br.com.projetoperiodo.util.persistencia.fabrica;

import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitoriaDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.instituto.professor.dao.ProfessorDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.util.persistencia.connection.ConnectionFactory;

public abstract class FabricaDAO {

	protected ConnectionFactory connectionFactory;
	
	public abstract UsuarioDao criarUsuarioDAO();
	
	public abstract RelatorioFrequenciaDao criarRelatorioFrequenciaDAO();
	
	public abstract SemanaDao criarSemanaDAO();
	
	public abstract AtividadeDao criarAtividadeDAO();
	
	public abstract MonitoriaDao criarMonitoriaDAO();
	
	public abstract AlunoDao criarAlunoDAO();
	
	public abstract DisciplinaDao criarDisciplinaDAO();
	
	public abstract CursoDao criarCursoDAO();
	
	public abstract ProfessorDao criarProfessorDao();
	
	public abstract PeriodoDao criarPeriodoDao();
	
	public abstract void fecharFabrica();
}
