package cl.bootcamp.ejeciocio_rest.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.bootcamp.ejeciocio_rest.model.Rol;
import cl.bootcamp.ejeciocio_rest.model.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	
	private final JdbcTemplate jdbcTemplate;
	
	
	public UsuarioDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate= jdbcTemplate;
	} 

	@Override
	public Usuario getById(int id) {
		try {
			Usuario usuario=jdbcTemplate.queryForObject("Select * from usuario where usuario_id=?" ,
					(ResultSet rs, int rowNum)->{
						Usuario usr = new Usuario();
						usr.setId(rs.getInt("usuario_id"));
						usr.setUsername(rs.getString("username"));
						usr.setPassword(rs.getString("password"));
						usr.setNombre(rs.getString("nombre"));
						usr.setApellido(rs.getString("apellido"));
						usr.setEmail(rs.getString("email"));
						usr.setRol( Rol.valueOf( rs.getString("rol")));
						return usr;						
					},
					new Object[]{id});
					
					
					return usuario;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			
			return null;
		}
		
	}

	@Override
	public List<Usuario> getList() {
		try {
			List<Usuario> usuarioList=jdbcTemplate.query("Select * from usuario" ,
					(ResultSet rs, int rowNum)->{
						
						Usuario usr = new Usuario();
						usr.setId(rs.getInt("usuario_id"));
						usr.setUsername(rs.getString("username"));
						usr.setPassword(rs.getString("password"));
						usr.setNombre(rs.getString("nombre"));
						usr.setApellido(rs.getString("apellido"));
						usr.setEmail(rs.getString("email"));
						usr.setRol( Rol.valueOf( rs.getString("rol")));
						return usr;						
					});
					
					
					return usuarioList;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			
			return null;
		}
	}

}
