
package br.com.projetoperiodo.model.documento;

public interface Documento {

	byte[] getConteudo();

	void setConteudo(byte[] conteudo);

	String getDescricao();

	void setDescricao(String descricao);

}