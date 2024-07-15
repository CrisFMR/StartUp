package cl.praxis.models.dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	private static Connection con = null;

    private DataBase() {
        
    	try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafioMVC", "postgres", "Admin2024");
            System.out.println(con.isValid(5000) ? "Se establecio conexión con BD." : "No se pudo conectar a la BD.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar con BD: " + e.getMessage());
        }
    }

    public static Connection getCon() throws SQLException  {
        if (con == null || con.isClosed()) {
            new DataBase();
        }
        return con;
    }
}