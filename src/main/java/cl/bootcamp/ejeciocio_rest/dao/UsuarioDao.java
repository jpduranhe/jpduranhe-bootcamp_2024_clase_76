package cl.bootcamp.ejeciocio_rest.dao;

import java.util.List;

import cl.bootcamp.ejeciocio_rest.model.Usuario;

public interface UsuarioDao {

	
	Usuario getById(int id);
	List<Usuario> getList();
}
