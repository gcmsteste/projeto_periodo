package dao;

import java.sql.Connection;
import java.util.Collection;

import model.RelatorioFrequencia;

public class RelatorioFrequenciaDao implements DAO
{
	Connection connection;
	public RelatorioFrequenciaDao(Connection connection) {
		this.connection = connection;
	}
	@Override
	public void inserir(Object object) {
		RelatorioFrequencia relatorioFrequencia = (RelatorioFrequencia)object;
		
		
		
	}

	@Override
	public void atualizar(Object object) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Object object) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Object> listar() {

		// TODO Auto-generated method stub
		return null;
	}

}
