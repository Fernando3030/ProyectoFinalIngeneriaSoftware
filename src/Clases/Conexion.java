package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	public Connection con=null;
	public ResultSet resultado;
	public Statement sentencias;
	public String driver="org.postgresql.Driver";
	public String dataBase="BDIngSoftware";
	public String user="postgres";
	public String contrasena="fernando30";
	public String url="jdbc:postgresql://localhost:5433/"+dataBase;
	
	public Conexion()
	{
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, user, contrasena);
			if(con != null)
			{
				System.out.println("Coneccion exitosa");
			}
			else
			{
				System.out.println("Fallo en la Coneccion ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet ExtraerAdmin() throws SQLException
	{
		sentencias= con.createStatement();
	
		String query= "select * from administrador where cod_admin like '001'";
		resultado= sentencias.executeQuery(query);

		return resultado;
			
		
	}

}