package cl.bootcamp.ejeciocio_rest.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import cl.bootcamp.ejeciocio_rest.dao.UsuarioDao;
import cl.bootcamp.ejeciocio_rest.model.Usuario;

@SpringBootTest
public class UsuarioDaoTest {

	@Autowired
	UsuarioDao usuarioDao;
	
	
	@Test
	void test() {
		Usuario usuario=usuarioDao.getById(1);
		
		assertEquals(usuario.getId(),1);
	}
	
	@Test
	void testLits() {
		List<Usuario> usuarioList=usuarioDao.getList();
		
		assertEquals(usuarioList.size(),6);
	}
}
