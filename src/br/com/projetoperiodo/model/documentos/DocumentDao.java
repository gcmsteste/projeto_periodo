package br.com.projetoperiodo.model.documentos;

import java.io.OutputStream;

public interface  DocumentDao {
	
	public void salvar(String fileName);
	
	public OutputStream buscar();
}
