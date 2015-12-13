package br.com.projetoperiodo.model.documento.dao;

import java.io.InputStream;

import br.com.projetoperiodo.model.documento.Documento;

public interface  DocumentDao {
	
	public void salvar(String fileName);
	
	public Documento buscar();
}
