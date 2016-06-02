package conexion;

import java.sql.*;

public class PruebaMala {

	public static void main(String[] args) {
		String conexion="jdbc:sqlserver://localhost";
		String nombre="prueba";
		String contraseña="prueba";
		String select="select ID,Nombre,Apellidos,Direccion from ICClientes";
		
		try {
			Connection conexionICOTR=DriverManager.getConnection(conexion, nombre, contraseña);
			Statement sentencia=conexionICOTR.createStatement();
			ResultSet miResultado=sentencia.executeQuery(select);
			int resultados=miResultado.getFetchSize();
			System.out.println(resultados);
			System.out.println("ID  Nombre       Apellidos        Direccion");
			while(miResultado.next()){
				
				System.out.print(miResultado.getInt("ID")+" ");
				
				System.out.print(miResultado.getString("Nombre")+" ");
				
				System.out.print(miResultado.getString("Apellidos")+" ");
				
				System.out.print(miResultado.getString("Direccion"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
