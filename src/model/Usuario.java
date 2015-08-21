
package model;

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

	public String setLogin() {

		return login;
	}

	public String setSenha() {

		return senha;
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