package accesoBD;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.*;

public class PersonaBD {

	/**
	 * Método para insertar una persona en la base de datos.
	 * @param persona
	 */
	public static void insertaPersona(Persona persona)
	{
		PreparedStatement guardaPer;
		//Instrucción en sql
		String insertaPer= "INSERT INTO PERSONA VALUES (?,?,?,?,?,?)";

		try {
			
			guardaPer=ConexionBD.cn.prepareStatement(insertaPer);
			guardaPer.setString(1, persona.getDni());
			guardaPer.setString(2, persona.getNombre());
			guardaPer.setString(3, persona.getAp1());
			guardaPer.setString(4, persona.getAp2());
			guardaPer.setDate(5, metodos.MetodosFechas.cambiaGCasqlDate(persona.getFnac()));
			guardaPer.setString(6, persona.getDomicilio().getCodigo());
			
			boolean comprobar=DireccionBD.siDirYaEsta(persona.getDomicilio());
			if(comprobar!=true)
			{
				DireccionBD.insertaDireccion(persona.getDomicilio());
				
			}
			//Ejecutamos el preparestatement
			guardaPer.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método que devuelve si una persona ya existe.
	 * @return - ArrayList<Persona>
	 */
	public static boolean buscaPersonas(String dniabuscar)
	{		
		try {
			
			Statement buscPer;
			buscPer = ConexionBD.cn.createStatement();
			String consultaPer= "SELECT * FROM PERSONA WHERE DNI='"+dniabuscar+"'";
			ResultSet rs=buscPer.executeQuery(consultaPer);
			
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
		
	}
	
	public static void borraPersona(String dni)
	{
		
		String deletePer= "DELETE FROM PERSONA WHERE DNI='"+dni+"'";
		//PrepareStatement comienza con índice 1
		Statement borraPer;
		try {
			borraPer=ConexionBD.cn.createStatement();
			boolean existe=buscaPersonas(dni);
			if(existe==true)
			{
				borraPer.execute(deletePer);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
