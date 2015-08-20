

import java.util.Date;

import conection.conexaoBancoDados;

public class User 
{
	public String nome;
	public int idade;
	private Date dataDeNascimento;
	private String login;
	private String senha;
	private int telefone;


	
	
	private void realizarLogin(String login, String senha)
	{
		this.login = login;
		this.senha = senha;
	}

	public String getLogin()
	{
		return login;
	}
	
	public String getSenha()
	{
		return senha;
	}
	
	public String setLogin()
	{
		return login;
	}
	
	public String setSenha()
	{
		return senha;
	}

}