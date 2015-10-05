
package br.com.projetoperiodo.model.usuario.impl;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;

import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;
import br.com.projetoperiodo.model.usuario.Usuario;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverrides({@AttributeOverride(name = "chavePrimaria", column = @Column(name = "USUARIO_ID") ),})
public class UsuarioImpl extends EntidadeNegocioImpl implements Usuario {

	@Column(name = "USUARIO_NOME", nullable = false)
	private String nome;

	@Column(name = "USUARIO_LOGIN", nullable = false)
	private String login;

	@Column(name = "USUARIO_SENHA", nullable = false)
	private String senha;

	@Column(name = "USUARIO_EMAIL", nullable = false)
	private String email;

	@Column(name = "ULTIMO_ACESSO", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date ultimoAcesso;

	@Column(name = "SENHA_EXPIRADA", nullable = false)
	private boolean senhaExpirada;

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getLogin()
	 */
	@Override
	public String getLogin() {

		return login;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getSenha()
	 */
	@Override
	public String getSenha() {

		return senha;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setLogin(java.lang.String)
	 */
	@Override
	public void setLogin(String login) {

		this.login = login;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setSenha(java.lang.String)
	 */
	@Override
	public void setSenha(String senha) {

		this.senha = senha;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getEmail()
	 */
	@Override
	public String getEmail() {

		return email;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {

		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {

		this.nome = nome;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getNome()
	 */
	@Override
	public String getNome() {

		return nome;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getChavePrimaria()
	 */

	public long getChavePrimaria() {

		// TODO Auto-generated method stub
		return super.getChavePrimaria();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getUltimoAcesso()
	 */
	@Override
	public Date getUltimoAcesso() {

		return ultimoAcesso;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setUltimoAcesso(java.util.Date)
	 */
	@Override
	public void setUltimoAcesso(Date ultimoAcesso) {

		this.ultimoAcesso = ultimoAcesso;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#getUltimaAlteracao()
	 */

	@Override
	public Date getUltimaAlteracao() {

		// TODO Auto-generated method stub
		return super.getUltimaAlteracao();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setUltimaAlteracao(java.util.Date)
	 */

	@Override
	public void setUltimaAlteracao(Date ultimaAlteracao) {

		// TODO Auto-generated method stub
		super.setUltimaAlteracao(ultimaAlteracao);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.projetoperiodo.model.usuario.impl.Usuario#setChavePrimaria(long)
	 */

	@Override
	public void setChavePrimaria(long chavePrimaria) {

		super.setChavePrimaria(chavePrimaria);
	}

	public boolean isSenhaExpirada() {

		return senhaExpirada;
	}

	public void setSenhaExpirada(boolean senhaExpirada) {

		this.senhaExpirada = senhaExpirada;
	}
}