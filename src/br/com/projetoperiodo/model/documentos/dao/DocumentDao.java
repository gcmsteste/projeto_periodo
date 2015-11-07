package br.com.projetoperiodo.model.documentos.dao;

import java.io.InputStream;

public interface  DocumentDao {
	
	public void salvar(String fileName);
	
	public InputStream buscar();
}
