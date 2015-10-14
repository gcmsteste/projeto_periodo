
package br.com.projetoperiodo.model.instituto.periodo;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;

public interface Periodo extends EntidadeNegocio{

	int getAno();

	void setAno(int ano);

	Semestre getSemestre();

	void setSemestre(Semestre semestre);

}