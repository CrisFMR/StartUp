package cl.praxis.models.dto;

import java.time.LocalDate;

// Variables

public class Usuarios {
	private int id;
	private String correo;
	private String nick;
	private String nombre;
	private String password;
	private int peso;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
//Constructor void
	
	public Usuarios() {
		super();

	}
	
//Constructor with Parameters

	public Usuarios(int id, String correo,  String nick, String nombre, String password, int peso, LocalDate createdAt,
			LocalDate updatedAt) {
		super();
		this.id = id;
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
//Getter & Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", correo=" + correo + ", nick=" + nick + ", nombre=" + nombre + ", password="
				+ password + ", peso=" + peso + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
	


	