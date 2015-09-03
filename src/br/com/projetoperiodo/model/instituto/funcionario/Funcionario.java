package br.com.projetoperiodo.model.instituto.funcionario;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.projetoperiodo.model.instituto.departamento.Departamento;
import br.com.projetoperiodo.model.usuario.Usuario;
@Entity
@Table(name = "FUNCIONARIO")
@PrimaryKeyJoinColumn( name = "FUNCIONARIO_ID")
public class Funcionario extends Usuario
{
	@Column( name = "FUNCIONARIO_SIAPE")
	private String siape;
	// Ao inserir um funcionario que possui departamento, insiro departamento também
	@ManyToOne(fetch=FetchType.LAZY, optional = false, cascade=CascadeType.PERSIST)
	@JoinColumn(name="DEPARTAMENTO_ID", referencedColumnName= "DEPARTAMENTO_ID")
	private Departamento departamento;
	
	public String getSiape() {

		return siape;
	}

	public void setSiape(String siape) {

		this.siape = siape;
	}

	public Departamento getDepartamento() {

		return departamento;
	}

	public void setDepartamento(Departamento departamento) {

		this.departamento = departamento;
	}
}
