package model;

import java.util.Collection;

public class Disciplina {
	
	private String descricao;
	private Collection<Aluno> pagantes;
	
	
	public String getDescricao() {

		return descricao;
	}
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}
	public Collection<Aluno> getPagantes() {

		return pagantes;
	}
	public void setPagantes(Collection<Aluno> pagantes) {

		this.pagantes = pagantes;
	}

	
	
}
