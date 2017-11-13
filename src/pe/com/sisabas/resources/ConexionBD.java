package pe.com.sisabas.resources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;




public final class ConexionBD {
	
	public static void main(String [] s)throws Exception{
		ConexionBD.obtenerConexion();
	}
	
	public static Connection obtenerConexion() throws SQLException {

		Connection con = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext
						.lookup("jdbc/sisabas");
			con = datasource.getConnection();
			System.out.println("ConexionBD...ok"+con);
		} catch (NamingException ex) {
			throw new SQLException("ConexionBD...No se pudo encontrar el DataSource.");
		} catch (SQLException ex) {
			throw new SQLException("ConexionBD...No se pudo obtener una conexion.");
		}
		return con;
	}

}
