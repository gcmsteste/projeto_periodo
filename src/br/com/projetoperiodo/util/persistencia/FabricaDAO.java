package br.com.projetoperiodo.util.persistencia;

import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.relatorio.atividade.dao.AtividadeDao;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;

public abstract class FabricaDAO {

	public abstract UsuarioDao criarUsuarioDAO();
	
	public abstract RelatorioFrequenciaDao criarRelatorioFrequenciaDAO();
	
	public abstract SemanaDao criarSemanaDAO();
	
	public abstract AtividadeDao criarAtividadeDAO();
	
	public abstract MonitorDao criarMonitorDAO();
	
	public abstract AlunoDao criarAlunoDAO();
	
	public abstract DisciplinaDao criarDisciplinaDAO();
	
	public abstract CursoDao criarCursoDAO();
	
	
	
}
