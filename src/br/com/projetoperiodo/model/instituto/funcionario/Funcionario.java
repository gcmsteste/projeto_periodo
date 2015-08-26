package br.com.projetoperiodo.model.instituto.funcionario;

import br.com.projetoperiodo.model.instituto.departamento.Departamento;
import br.com.projetoperiodo.model.usuario.Usuario;

public class Funcionario extends Usuario
{
	private String siape;
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
