package br.com.projetoperiodo.model.documento.controller;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public abstract class DocumentBuilder {
	protected byte[] document;

	public DocumentBuilder() { }
	
	public byte[] buildDocument(RelatorioFrequencia relatorio) {
		document = createDocument(relatorio);
		inserirSemanas();
		return document;
	}
	protected abstract byte[] createDocument(RelatorioFrequencia relatorio);
	protected abstract void inserirSemanas();
	protected abstract void inserirNomeMonitor();
	
}
