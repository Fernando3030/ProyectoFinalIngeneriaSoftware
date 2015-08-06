package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	 public Connection getConnection()
	    {
	        return this.con;
	    }
	
	//___________________________________________________________________________________ Soy una barra separadora :)
	/* METODO PARA REALIZAR UNA CONSULTA A LA BASE DE DATOS
	 * INPUT:
	 *      table => nombre de la tabla donde se realizara la consulta, puede utilizarse tambien INNER JOIN
	 *      fields => String con los nombres de los campos a devolver Ej.: campo1,campo2campo_n
	 *      where => condicion para la consulta
	 * OUTPUT: un object[][] con los datos resultantes, sino retorna NULL
	 */
	    public Object [][] select(String table, String fields, String where)
	    {
	      int registros = 0;
	      String colname[] = fields.split(",");

	      //Consultas SQL
	      String q ="SELECT " + fields + " FROM " + table;
	      String q2 = "SELECT count(*) as total FROM " + table;
	      if(where!=null)
	      {
	          q+= " WHERE " + where;
	          q2+= " WHERE " + where;
	      }
	      //obtenemos la cantidad de registros existentes en la tabla
	      try{
	         PreparedStatement pstm = con.prepareStatement(q2);
	         ResultSet res = pstm.executeQuery();
	         res.next();
	         registros = res.getInt("total");
	         res.close();
	      }catch(SQLException e){
	         System.out.println(e);
	      }
	    //se crea una matriz con tantas filas y columnas que necesite
	    Object[][] data = new String[registros][fields.split(",").length];
	    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
	      try{
	         PreparedStatement pstm = con.prepareStatement(q);
	         ResultSet res = pstm.executeQuery();
	         int i = 0;
	         while(res.next()){
	            for(int j=0; j<=fields.split(",").length-1;j++){
	                data[i][j] = res.getString( colname[j].trim() );
	            }
	            i++;         }
	         res.close();
	          }catch(SQLException e){
	         System.out.println(e);
	    }
	    return data;
	 }

}