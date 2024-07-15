package cl.praxis.controllers.service;

import cl.praxis.models.dao.UserDAO;
import cl.praxis.models.dao.UserDAOImpl;
import cl.praxis.models.dto.Usuarios;

public class ServUser {
	
private UserDAO uDAO = new UserDAOImpl();
	
	public void create (Usuarios u) {
		uDAO.create(u);
	}
	
	public boolean mailReg(String email) {
		return uDAO.mailReg(email);
	}
	
	public Usuarios validate(String correo, String password) {
	    return uDAO.validate(correo, password);
	}	
}
