package br.com.projetoperiodo.model.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Usuario  
{

	final static String ATRIBUTO_USUARIO_LOGIN = "login";
	
	final static String ATRIBUTO_USUARIO_SENHA = "senha";
	
	final static String ATRIBUTO_USUARIO_EMAIL = "email";
	
	
	String getLogin();

	String getSenha();

	void setLogin(String login);

	void setSenha(String senha);

	String getEmail();

	void setEmail(String email);

	void setNome(String nome);

	String getNome();

	long getChavePrimaria();

	Date getUltimoAcesso();

	void setUltimoAcesso(Date ultimoAcesso);

	Date getUltimaAlteracao();

	void setUltimaAlteracao(Date ultimaAlteracao);

	void setChavePrimaria(long chavePrimaria);
	
	boolean isSenhaExpirada();
	
	void setSenhaExpirada(boolean senhaExpirada);

}