
package br.com.projetoperiodo.model.usuario;

public class Usuario {

	public String nome;

	private String login;

	private String senha;

	private String email;

	public String getLogin() {

		return login;
	}

	public String getSenha() {

		return senha;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}