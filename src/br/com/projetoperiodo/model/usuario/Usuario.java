
package br.com.projetoperiodo.model.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface Usuario extends EntidadeNegocio {

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

	Date getUltimoAcesso();

	void setUltimoAcesso(Date ultimoAcesso);

	boolean isSenhaExpirada();

	void setSenhaExpirada(boolean senhaExpirada);

}