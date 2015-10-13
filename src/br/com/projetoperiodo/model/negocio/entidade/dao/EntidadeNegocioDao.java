package br.com.projetoperiodo.model.negocio.entidade.dao;

import java.util.HashMap;

import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface EntidadeNegocioDao {

	EntidadeNegocio buscar(HashMap<String, Object> filter) throws NegocioException;
}
