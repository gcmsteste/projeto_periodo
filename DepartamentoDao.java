package model.instituto.departamento;

import java.util.List;


public interface DepartamentoDao {
	
	public void salvar(Departamento departamento);

	public List<Departamento> listar();
	
	public void remover(Departamento departamento);
	
	public void atualizar(Departamento departamento);
}
