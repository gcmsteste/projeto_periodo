
package br.com.projetoperiodo.model.usuario;

import java.util.Date;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface Usuario extends EntidadeNegocio {

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

	String getSobrenome();

	void setSobrenome(String sobrenome);

	String getPapelUsuario();

}