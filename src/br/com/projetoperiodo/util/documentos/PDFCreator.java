package br.com.projetoperiodo.util.documentos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.atividade.impl.AtividadeImpl;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;

public class PDFCreator {

	private static PDFCreator creator = null;
	private PdfReader reader;
	private static final String SOURCE = "selection.pdf";
	private static final String DEST = "relatorio.pdf";
	private PdfContentByte conteudoDocumento;
	private PdfStamper copia;
	private FontSelector seletorFonte;
	public static final int NOME_MONITOR_X = 124;
	public static final int NOME_MONITOR_Y = 675;

	public static final int NOME_DISCIPLINA_X = 132;
	public static final int NOME_DISCIPLINA_Y = 658;

	public static final int NOME_ORIENTADOR_X = 142;
	public static final int NOME_ORIENTADOR_Y = 641;

	public static final int MATRICULA_X = 546;
	public static final int MATRICULA_Y = 675;

	public static final int NOME_CURSO_X = 534;
	public static final int NOME_CURSO_Y = 658;

	public static final int MES_X = 534;
	public static final int MES_Y = 730;

	public static final int ANO_X = 534;
	public static final int ANO_Y = 658;

	public static final int HORARIO_ENTRADA_X = 340;
	public static final int HORARIO_ENTRADA_Y = 588;

	public static final int HORARIO_SAIDA_X = 390;
	public static final int HORARIO_SAIDA_Y = 588;
	
	public static final int DATA_ATIVIDADE_X = 307;
	public static final int DATA_ATIVIDADE_Y = 588;

	public static final int SEMANA_DESCRICAO_X = 250;
	public static final int SEMANA_DESCRICAO_Y = 588;
	
	private PDFCreator() {
		try {
			reader = new PdfReader(SOURCE);
			copia = new PdfStamper(reader, new FileOutputStream(DEST));
			conteudoDocumento = copia.getOverContent(1);
			configurarFonteDocumento();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
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

	public static PDFCreator getInstancia() {
		if (creator == null) {
			creator = new PDFCreator();
		}
		return creator;
	}

	private void preencherNomeMonitor(String nome, PdfContentByte canvas) {
		Phrase phrase = new Phrase(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, NOME_MONITOR_X, NOME_MONITOR_Y, 0);
	}

	private void preencherNomeDisciplina(String nome, PdfContentByte canvas) {
		FontSelector seletor = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		seletor.addFont(font);
		Phrase phrase = seletor.process(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, NOME_DISCIPLINA_X, NOME_DISCIPLINA_Y, 0);
	}

	private void preencherCampoMes(String nome, PdfContentByte canvas) {
		FontSelector seletor = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		seletor.addFont(font);
		Phrase phrase = seletor.process(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, MES_X, MES_Y, 0);
	}

	private void preencherNomeOrientador(String nome, PdfContentByte canvas) {
		FontSelector seletor = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		seletor.addFont(font);
		Phrase phrase = seletor.process(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, NOME_ORIENTADOR_X, NOME_ORIENTADOR_Y, 0);
	}

	private void preencherMatricula(String nome, PdfContentByte canvas) {
		FontSelector seletor = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		seletor.addFont(font);
		Phrase phrase = seletor.process(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, MATRICULA_X, MATRICULA_Y, 0);
	}

	private void preencherNomeCurso(String nome, PdfContentByte canvas) {
		FontSelector seletor = new FontSelector();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
		seletor.addFont(font);
		Phrase phrase = seletor.process(nome);
		ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, NOME_CURSO_X, NOME_CURSO_Y, 0);
	}

	private void preencherHorarioEntradaAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {
		Phrase phrase = seletorFonte.process(atividade.getHorarioEntrada());
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_ENTRADA_X,
				HORARIO_ENTRADA_Y - decrementoPosicaoRelativaY, 0);
	}

	private void preencherHorarioSaidaAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {
		Phrase phrase = seletorFonte.process(atividade.getHorarioSaida());
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_SAIDA_X,
				HORARIO_SAIDA_Y - decrementoPosicaoRelativaY, 0);
	}
	private void preencherDataAtividade(Atividade atividade, int decrementoPosicaoRelativaY) {
		DateFormat formataData = DateFormat.getDateInstance();
		Phrase phrase = seletorFonte.process(formataData.format(atividade.getData()));
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, DATA_ATIVIDADE_X,
				DATA_ATIVIDADE_Y - decrementoPosicaoRelativaY, 0);
	}
	private void preencherAtividadesDaSemana(Semana semana) {
		int decrementoPosicaoRelativaY = 0;
		for (int i = 0; i < 5; i++) {
			Atividade atividade = semana.getAtividades(i);
			preencherAtividadeDocumento(atividade, decrementoPosicaoRelativaY);
			decrementoPosicaoRelativaY += 14;
		}
	}
	
	private void preencherDescricaoSemana(Semana semana) {
		Paragraph paragraph = new Paragraph();
		Phrase phrase = seletorFonte.process("Primeira linha");
		paragraph.add(phrase);
		paragraph.add(Chunk.NEWLINE);
		phrase = seletorFonte.process("Segunda linha");
		paragraph.add(phrase);
		ColumnText columnText;
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, paragraph, SEMANA_DESCRICAO_X,
				SEMANA_DESCRICAO_Y, 0);
		
	}
	private void preencherAtividadeDocumento(Atividade atividade, int decrementoPosicaoRelativaY) {
		preencherDataAtividade(atividade, decrementoPosicaoRelativaY);
		preencherHorarioEntradaAtividade(atividade, decrementoPosicaoRelativaY);
		preencherHorarioSaidaAtividade(atividade, decrementoPosicaoRelativaY);
	}
	
	private void preencherPrimeiraAtividadeDocumento() {
		
	}

	public void preencherHorarioEntradaRelatorio(int posicao, Atividade atividade) {
		
		Phrase phrase = seletorFonte.process(atividade.getHorarioEntrada());
		ColumnText.showTextAligned(conteudoDocumento, Element.ALIGN_RIGHT, phrase, HORARIO_ENTRADA_X, HORARIO_ENTRADA_Y,
				0);
	}

	public void preencherHorarioSaidaRelatorio(int posicao) {

	}

	public void gerarRelatorio(RelatorioFrequencia relatorio) throws DocumentException, IOException {
		PdfStamper stamper = null;

		/*
		 * PdfContentByte canvas = stamper.getOverContent(1);
		 * preencherNomeMonitor(relatorio.getMonitor().getNome(), canvas);
		 * preencherNomeDisciplina(relatorio.getMonitor().
		 * getDisciplina().getDescricao(), canvas);
		 * preencherNomeOrientador(relatorio.getOrientador().getNome(), canvas);
		 * preencherMatricula(relatorio.getMonitor().getMatricula(), canvas);
		 * preencherNomeCurso(relatorio.getMonitor().getCurso().getDescricao(),
		 * canvas); //preencherCampoMes(Integer.toString(relatorio.getMes()),
		 * canvas);
		 */
		preencherAtividadesDaSemana(relatorio.getSemanas(0));
		preencherDescricaoSemana(relatorio.getSemanas(0));
		copia.close();
	}

	public static void main(String[] args) throws DocumentException, IOException {
		RelatorioFrequencia relatorio = new RelatorioFrequenciaImpl();
		for (int i = 0; i < 5; i++) {
			SemanaImpl semana = new SemanaImpl();
			semana.setDescricao("A minha primeira \r\n semana de monitoria");
			for (int j = 0; j < 5; j++) {
				AtividadeImpl atividade = new AtividadeImpl();
				atividade.setHorarioEntrada("14:00");
				atividade.setHorarioSaida("18:00");
				atividade.setData(new Date());
				semana.setAtividades(atividade);
			}
			relatorio.setSemanas(semana);
		}

		MonitorImpl monitor = new MonitorImpl();
		Disciplina disciplina = new DisciplinaImpl();
		Professor professor = new ProfessorImpl();
		Curso curso = new CursoImpl();
		curso.setDescricao("Análise de Sistemas");
		professor.setNome("Marcos Costa");
		disciplina.setDescricao("Introdução à Programação");
		monitor.setNome("Edmilson Santana");
		monitor.setDisciplina(disciplina);
		monitor.setMatricula("20141Y6-RC0323");
		monitor.setCurso(curso);
		relatorio.setProfessor(professor);
		relatorio.setMonitor(monitor);
		relatorio.setMes(9);
		PDFCreator.getInstancia().gerarRelatorio(relatorio);
	}
}
