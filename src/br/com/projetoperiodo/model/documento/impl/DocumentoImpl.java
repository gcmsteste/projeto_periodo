package br.com.projetoperiodo.model.documento.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.com.projetoperiodo.model.documento.Documento;
import br.com.projetoperiodo.model.negocio.entidade.impl.EntidadeNegocioImpl;

@Entity
@Table(name = "TEMPLATE_DOCUMENTO")
public class DocumentoImpl extends EntidadeNegocioImpl implements Documento {
	
	@Column(name="TEMPLATE_NOME")
	private String descricao;
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="TEMPLATE_CONTENT")
	private byte[] conteudo;
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.Documento#getConteudo()
	 */
	@Override
	public byte[] getConteudo() {

		return conteudo;
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.Documento#setConteudo(byte[])
	 */
	@Override
	public void setConteudo(byte[] conteudo) {

		this.conteudo = conteudo;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.Documento#getDescricao()
	 */
	@Override
	public String getDescricao() {
		return this.descricao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.documento.Documento#setDescricao(java.lang.String)
	 */
	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
