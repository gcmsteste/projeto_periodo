package br.com.projetoperiodo.model.documento;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;

@Entity
@Table(name = "TEMPLATE_DOCUMENTO")
public class DocumentoImpl extends EntidadeNegocioImpl {
	
	@Column(name="TEMPLATE_NOME")
	private String descricao;
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="TEMPLATE_CONTENT")
	private byte[] conteudo;

	public byte[] getConteudo() {

		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {

		this.conteudo = conteudo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
