package br.com.projetoperiodo.model.negocio.entidade;

import java.util.Date;

public interface EntidadeNegocio
{
	String ATRIBUTO_CHAVE_PRIMARIA = "chavePrimaria";
	
	public Date getUltimaAlteracao();
	
	public void setUltimaAlteracao(Date ultimaAlteracao);
	
	public long getChavePrimaria();
	
	public void setChavePrimaria(long chavePrimaria);
	
	boolean isSenhaExpirada();
	
	void setSenhaExpirada(boolean senhaExpirada);
}