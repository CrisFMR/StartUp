package cl.praxis.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.models.dbase.DataBase;
import cl.praxis.models.dto.Usuarios;

public class UserDAOImpl implements UserDAO {

//Registra el usuario en nuestra BD
	@Override
	public void create(Usuarios u) {
		if (mailReg(u.getCorreo())) {
			throw new RuntimeException("Correo ya está registrado");
		}

		String sql = "insert into usuarios (correo, nick, nombre, password, peso, created_at, updated_at) VALUES ('"
				+ u.getCorreo() + "', '" + u.getNick() + "', '" + u.getNombre() + "', '" + u.getPassword() 
				+ "', " + u.getPeso() + ", '" + u.getCreatedAt() + "', '"  + u.getUpdatedAt() + "')";

		System.out.print(sql);
		
		try {
			Connection c = DataBase.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			System.out.println("ERROR en método create()" + e.getMessage());
			e.printStackTrace();
		}
	}

//Devuelve informacion de BD en realcion al ID
	@Override
	public Usuarios read(int id) {
		Usuarios u = null;

		try {
			Connection c = DataBase.getCon();
			Statement s = c.createStatement();
			String sql = "select id, correo, nick, nombre, password, peso, created_at, updated_at from usuarios where id = "+ id;
			
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				Timestamp TSCreate = rs.getTimestamp("created_at");
				Timestamp TSUpdate = rs.getTimestamp("updated_at");
				
				u = new Usuarios(rs.getInt("id"), 
						rs.getString("correo"),
						rs.getString("nick"), 
						rs.getString("nombre"), 
						rs.getString("password"), 
						rs.getInt("peso"),
						TSCreate.toLocalDateTime().toLocalDate(),
						TSUpdate.toLocalDateTime().toLocalDate());
			}
		} catch (SQLException e) {
			System.out.println("ERROR en método read(id)" + e.getMessage());
			e.printStackTrace();
		}

		return u;
	}
	
	
	//confirma si el mail del usuario se encuentra registrado
	@Override
	public boolean mailReg (String email) {
	    boolean isRegistered = false;

	    try (Connection c = DataBase.getCon();
	         PreparedStatement pstmt = c.prepareStatement("select 1 from usuarios where correo = ?")) {
	        pstmt.setString(1, email);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                isRegistered = true;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al verificar correo electrónico: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return isRegistered;
	}

//
	@Override
	public List<Usuarios> read() {
		List<Usuarios> user = new ArrayList<Usuarios>();
		try {

			Connection c = DataBase.getCon();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select id, correo, nick, nombre, password, peso, created_at, update_at from usuarios");

			while (rs.next()) {

				Timestamp TSCreate = rs.getTimestamp("created_at");
				Timestamp TSUpdate = rs.getTimestamp("updated_at");

				user.add(new Usuarios(rs.getInt("id"), rs.getString("correo"), 
						rs.getString("nick"), rs.getString("nombre"), rs.getString("password"), rs.getInt("peso"),
						TSCreate.toLocalDateTime().toLocalDate(), TSUpdate.toLocalDateTime().toLocalDate()));
			}

		} catch (SQLException e) {
			System.out.println("ERROR en metodo Read()" + e.getMessage());
			e.printStackTrace();
		}
		return user;
	}
	
	
	//Entrega correo y nombre del usuario una vez validado login en relacion a lo registrado en DB.
	@Override
	public Usuarios validate(String correo, String password) {
		Usuarios usuarios = new Usuarios();
		try (Connection c = DataBase.getCon();
				PreparedStatement ps = c.prepareStatement("select * from usuarios where correo =? and password =?")) {
			ps.setString(1, correo);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					usuarios.setCorreo(rs.getString("correo"));
					usuarios.setNombre(rs.getString("nombre"));
					return usuarios;
				}
			}

		} catch (SQLException e) {
			System.out.println("ERROR al validar login" +e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
}