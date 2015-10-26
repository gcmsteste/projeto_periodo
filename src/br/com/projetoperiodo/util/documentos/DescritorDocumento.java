
package br.com.projetoperiodo.util.documentos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.impl.PeriodoImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;

public class DescritorDocumento {

	private PdfReader reader;

	private static final String SOURCE = "C:\\Users\\EdmilsonS\\Projetos Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\projeto_periodo\\pdf\\selection.pdf";

	private static final String DEST = "C:\\Users\\EdmilsonS\\Projetos Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\projeto_periodo\\pdf\\relatorio.pdf";

	private PdfContentByte conteudoDocumento;

	private PdfStamper copia;

	private FontSelector seletorFonte;

	public static final int NOME_MONITOR_X = 124;

	public static final int NOME_MONITOR_Y = 675;

	public static final int QUANTIDADE_ATIVIDADES = 5;

	public static final int QUANTIDADE_SEMANAS = 5;

	public static final int NOME_DISCIPLINA_X = 132;

	public static final int NOME_DISCIPLINA_Y = 658;

	public static final int NOME_ORIENTADOR_X = 142;

	public static final int NOME_ORIENTADOR_Y = 641;

	public static final int MATRICULA_X = 546;

	public static final int MATRICULA_Y = 675;

	public static final int NOME_CURSO_X = 534;

	public static final int NOME_CURSO_Y = 658;

	public static final int MES_X = 487;

	public static final int MES_Y = 718;

	public static final int ANO_X = 521;

	public static final int ANO_Y = 718;

	public static final int EDITAL_X = 509;

	public static final int EDITAL_Y = 696;

	public static final int ATIVIDADE_Y = 588;

	public static final int HORARIO_ENTRADA_X = 340;

	public static final int HORARIO_SAIDA_X = 390;

	public static final int DATA_ATIVIDADE_X = 307;

	public static final int SEMANA_DESCRICAO_X = 250;

	public static final int SEMANA_DESCRICAO_Y = 588;

	private DescritorDocumento() {
		try {
			System.getProperty("user.dir");
			reader = new PdfReader(SOURCE);
			copia = new PdfStamper(reader, new FileOutputStream(DEST));
			conteudoDocumento = copia.getOverContent(1);
			configurarFonteDocumento();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (DocumentException e) {

			e.printStackTrace();
		}
	}

	private void configurarFonteDocumento() {

		this.seletorFonte = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		this.seletorFonte.addFont(font);
	}

	public void closeReader() {

		reader.close();
	}

	public static DescritorDocumento getInstancia() {

		return new DescritorDocumento();
	}

	private void preencherNomeMonitor(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_LEFT, phrase, NOME_MONITOR_X, NOME_MONITOR_Y, 0);
	}

	private void preencherNomeDisciplina(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_LEFT, phrase, NOME_DISCIPLINA_X, NOME_DISCIPLINA_Y, 0);
	}

	private void preencherCampoMes(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, MES_X, MES_Y, 0);
	}

	private void preencherNomeOrientador(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_LEFT, phrase, NOME_ORIENTADOR_X, NOME_ORIENTADOR_Y, 0);
	}

	private void preencherCampoEdital(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_LEFT, phrase, EDITAL_X, EDITAL_Y, 0);
	}

	private void preencherCampoAno(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_LEFT, phrase, ANO_X, ANO_Y, 0);
	}

	private void preencherMatricula(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, MATRICULA_X, MATRICULA_Y, 0);
	}

	private void preencherNomeCurso(String nome) {

		Phrase phrase = seletorFonte.process(nome);
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, NOME_CURSO_X, NOME_CURSO_Y, 0);
	}

	private void preencherHorarioEntradaAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {

		if (atividade.getHorarioEntrada() != null) {
			Phrase phrase = seletorFonte.process(atividade.getHorarioEntrada());
			ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_ENTRADA_X,
							ATIVIDADE_Y - decrementoPosicaoRelativaY, 0);
		}

	}

	private void preencherHorarioSaidaAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {

		if (atividade.getHorarioSaida() != null) {
			Phrase phrase = seletorFonte.process(atividade.getHorarioSaida());
			ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_SAIDA_X,
							ATIVIDADE_Y - decrementoPosicaoRelativaY, 0);
		}

	}

	private void preencherDataAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {

		if (atividade.getData() != null) {
			DateFormat formataData = DateFormat.getDateInstance();
			Phrase phrase = seletorFonte.process(formataData.format(atividade.getData()));
			ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, DATA_ATIVIDADE_X,
							ATIVIDADE_Y - decrementoPosicaoRelativaY, 0);
		}

	}

	private void preencherHorarioEntradaRelatorio(int posicao, Atividade atividade) {

		Phrase phrase = seletorFonte.process(atividade.getHorarioEntrada());
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_ENTRADA_X, ATIVIDADE_Y, 0);
	}

	private void preencherDescricaoSegundaSemana(Semana semana) throws DocumentException {

		if (semana.getDescricao() != null) {
			Phrase phrase = seletorFonte.process(semana.getDescricao());
			ColumnText columnText = new ColumnText(conteudoDocumento);
			columnText.setSimpleColumn(phrase, 73, 529, 250, 100, 10, Element.ALIGN_JUSTIFIED);
			columnText.go();
		}

	}

	private void preencherDescricaoQuartaSemana(Semana semana) throws DocumentException {

		if (semana.getDescricao() != null) {
			Phrase phrase = seletorFonte.process(semana.getDescricao());
			ColumnText columnText = new ColumnText(conteudoDocumento);
			columnText.setSimpleColumn(phrase, 73, 389, 250, 100, 10, Element.ALIGN_JUSTIFIED);
			columnText.go();
		}

	}

	private void preencherDescricaoQuintaSemana(Semana semana) throws DocumentException {

		if (semana.getDescricao() != null) {
			Phrase phrase = seletorFonte.process(semana.getDescricao());
			ColumnText columnText = new ColumnText(conteudoDocumento);
			columnText.setSimpleColumn(phrase, 73, 319, 250, 100, 10, Element.ALIGN_JUSTIFIED);
			columnText.go();
		}

	}

	private void preencherDescricaoTerceiraSemana(Semana semana) throws DocumentException {

		if (semana.getDescricao() != null) {
			Phrase phrase = seletorFonte.process(semana.getDescricao());
			ColumnText columnText = new ColumnText(conteudoDocumento);
			columnText.setSimpleColumn(phrase, 73, 459, 250, 100, 10, Element.ALIGN_JUSTIFIED);
			columnText.go();
		}

	}

	private void preencherDescricaoPrimeiraSemana(Semana semana) throws DocumentException {

		if (semana.getDescricao() != null) {
			Phrase phrase = seletorFonte.process(semana.getDescricao());
			ColumnText columnText = new ColumnText(conteudoDocumento);
			columnText.setSimpleColumn(phrase, 73, 605, 250, 260, 10, Element.ALIGN_JUSTIFIED);
			columnText.go();
		}

	}

	private void preencherAtividadesSemanais(Atividade atividade, int decrementoPosicaoRelativaY) {

		preencherDataAtividade(atividade, decrementoPosicaoRelativaY);
		preencherHorarioEntradaAtividade(atividade, decrementoPosicaoRelativaY);
		preencherHorarioSaidaAtividade(atividade, decrementoPosicaoRelativaY);
	}

	public void gerarRelatorio(RelatorioFrequencia relatorio) {

		preencherNomeMonitor(relatorio.getMonitor().getAluno().getNome());
		preencherNomeDisciplina(relatorio.getMonitor().getDisciplina().getDescricao());
		preencherNomeOrientador(relatorio.getMonitor().getDisciplina().getProfessor().getNome());
		preencherMatricula(relatorio.getMonitor().getAluno().getMatricula());
		preencherNomeCurso(relatorio.getMonitor().getAluno().getCurso().getDescricao());
		preencherCampoMes(Util.obterNomeMes(relatorio.getMes()));
		preencherCampoAno(String.valueOf(relatorio.getMonitor().getPeriodo().getAno()));
		preencherCampoEdital(relatorio.getMonitor().getPeriodo().toString());

		int decrementoPosicaoRelativaY = 0;
		for (int posicaoSemana = 0; posicaoSemana < QUANTIDADE_SEMANAS; posicaoSemana++) {
			Semana semana = relatorio.getSemana(posicaoSemana);

			for (int i = 0; i < QUANTIDADE_ATIVIDADES; i++) {
				Atividade atividade = semana.getAtividade(i);
				preencherAtividadesSemanais(atividade, decrementoPosicaoRelativaY);
				decrementoPosicaoRelativaY += 14;
			}

		}

		try {
			preencherDescricaoPrimeiraSemana(relatorio.getSemana(0));
			preencherDescricaoSegundaSemana(relatorio.getSemana(1));
			preencherDescricaoTerceiraSemana(relatorio.getSemana(2));
			preencherDescricaoQuartaSemana(relatorio.getSemana(3));
			preencherDescricaoQuintaSemana(relatorio.getSemana(4));
			copia.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws DocumentException, IOException {

		RelatorioFrequencia relatorio = new RelatorioFrequenciaImpl();
		for (int i = 0; i < 5; i++) {
			SemanaImpl semana = new SemanaImpl();
			semana.setDescricao("Esta é uma descrição semanal");
			for (int j = 0; j < 5; j++) {
				AtividadeImpl atividade = new AtividadeImpl();
				atividade.setHorarioEntrada("14:00");
				atividade.setHorarioSaida("18:00");
				atividade.setData(new Date());
				semana.setAtividades(atividade);
			}
			relatorio.setSemanas(semana);
		}

		Monitor monitor = new MonitorImpl();
		Periodo periodo = new PeriodoImpl();
		periodo.setAno(2015);
		periodo.setSemestre(Semestre.SEGUNDO);
		Disciplina disciplina = new DisciplinaImpl();
		Professor professor = new ProfessorImpl();
		Curso curso = new CursoImpl();
		Aluno aluno = new AlunoImpl();
		curso.setDescricao("Análise de Sistemas");
		professor.setNome("Marcos Costa");
		disciplina.setDescricao("Introdução à Programação");
		disciplina.setProfessor(professor);
		aluno.setNome("Edmilson Santana");
		monitor.setDisciplina(disciplina);
		aluno.setMatricula("20141Y6-RC0323");
		aluno.setCurso(curso);
		monitor.setAluno(aluno);
		monitor.setPeriodo(periodo);
		relatorio.setMonitor(monitor);
		relatorio.setMes(9);
		DescritorDocumento.getInstancia().gerarRelatorio(relatorio);

	}
}
