
package br.com.projetoperiodo.model.relatorio.frequencia.controller.impl;

import java.util.Calendar;
import java.util.List;

import br.com.projetoperiodo.model.documento.ConstrutorDocumento;
import br.com.projetoperiodo.model.instituto.monitor.Monitoria;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.controller.ControladorRelatorio;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.controller.ControladorSemana;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.fachada.Fachada;
import br.com.projetoperiodo.util.fachada.Persistencia;

public class ControladorRelatorioImpl extends ControladorNegocioImpl implements ControladorRelatorio {

	public ControladorRelatorioImpl() {

	}

	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new RelatorioFrequenciaImpl();
	}

	@Override
	public List<RelatorioFrequencia> buscarRelatoriosDeMonitor(Monitoria monitoria) {

		return Persistencia.getInstance().buscarRelatoriosMonitoria(monitoria.getChavePrimaria());
	}

	@Override
	public void prepararRelatoriosDoMonitor(Monitoria monitoria) {

		ControladorSemana controladorSemana = Fachada.getInstance().getControladorSemana();
		RelatorioFrequencia relatorio;
		Periodo periodoMonitor = monitoria.getPeriodo();
		int mes = periodoMonitor.getSemestre().semestre == 2 ? 7 : 1;
		for (int contador = 0; contador < 6; mes++, contador++) {
			relatorio = (RelatorioFrequencia) this.criarEntidadeNegocio();
			relatorio.setMes(mes);
			relatorio.setUltimaAlteracao(Calendar.getInstance().getTime());
			relatorio.setMonitor(monitoria);
			relatorio.setSituacao(Situacao.ESPERA);
			relatorio = (RelatorioFrequencia) Persistencia.getInstance().salvarRelatorio(relatorio);
			controladorSemana.cadastrarSemanasComRelatorio(relatorio);
		}

	}

	@Override
	public RelatorioFrequencia buscarRelatoriosDeMonitoriaPorMes(Monitoria monitoria, int mes) {

		return (RelatorioFrequencia) Persistencia.getInstance().buscarRelatoriosMonitoriaPorMes(monitoria.getChavePrimaria(), mes);
	}

	@Override
	public void atualizarRelatorio(RelatorioFrequencia relatorio) {

		Persistencia.getInstance().atualizarRelatorio(relatorio);
	}

	@Override
	public byte[] gerarDocumentoDeRelatorio(RelatorioFrequencia relatorio, Usuario requisitante) throws NegocioException {

		if (relatorio.getSituacao().equals(Situacao.ESPERA) && "ALUNO".equals(requisitante.getPapelUsuario())) {
			throw new NegocioException(Constantes.ERRO_RELATORIO_NAO_APROVADO);
		}
		return ConstrutorDocumento.getInstancia().gerarRelatorio(relatorio);
	}

	@Override
	public void removerRelatoriosDeMonitoria(Monitoria monitoria) {

		List<RelatorioFrequencia> relatorios = this.buscarRelatoriosDeMonitor(monitoria);
		for (RelatorioFrequencia relatorio : relatorios) {
			Persistencia.getInstance().removerRelatorio(relatorio);
		}
	}

	@Override
	public RelatorioFrequencia aprovarRelatorio(RelatorioFrequencia relatorio) {

		relatorio.setSituacao(Situacao.APROVADO);
		return (RelatorioFrequencia) Persistencia.getInstance().atualizarRelatorio(relatorio);
	}

	@Override
	public List<Situacao> buscaSituacaoDosRelatoriosDeMonitoria(Monitoria monitoria) {

		return Persistencia.getInstance().listarSituacaoDeRelatorioDeMonitoria(monitoria.getChavePrimaria());
	}

	@Override
	public String getNomeClasseEntidade() {

		return RelatorioFrequenciaImpl.class.getSimpleName();
	}

}
