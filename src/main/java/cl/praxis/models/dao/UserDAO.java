package cl.praxis.models.dao;

import java.util.List;

import cl.praxis.models.dto.Usuarios;

public interface UserDAO {
	void create(Usuarios u);
	Usuarios read(int id);
	List<Usuarios> read();
	Usuarios validate(String correo, String password);
	boolean mailReg(String email);
	
	
	
}