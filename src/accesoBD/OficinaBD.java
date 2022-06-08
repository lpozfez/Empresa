/**
 * 
 */
package accesoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import accesoBD.ConexionBD;
import entidades.Oficina;
import metodos.MetodosFechas;
import entidades.Direccion;

/**
 * @author lourd
 *
 */
public class OficinaBD {

	/**
	 * El m�todo insertaOficina realiza un insert en la base de datos, de la oficina que se le pasa por par�metro. 
	 * @param ofi - El par�metro ofi es un objeto oficina
	 */
	public static void insertaOficina(entidades.Oficina ofi)
	{
		PreparedStatement guardaOfi;
		//Instrucci�n en sql
		String insertaOfi= "INSERT INTO OFICINA VALUES (?,?,?)";
		DireccionBD.insertaDireccion(ofi.getDireccion());

		try {
			
			guardaOfi=ConexionBD.cn.prepareStatement(insertaOfi);
			guardaOfi.setString(1, ofi.getCodigo());
			guardaOfi.setString(2, ofi.getNombre());
			guardaOfi.setString(3, ofi.getDireccion().getCodigo());
						
			guardaOfi.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo que obtiene todas las oficinas que hay en la base de datos, es decir, todas las tuplas de la tabla oficina.
	 * @return Devuelve un ArrayList de todas las oficinas de la base de datos
	 */
	public static ArrayList<entidades.Oficina> buscaOficinas()
	{
		ArrayList<entidades.Oficina> oficinas=new ArrayList<entidades.Oficina>();
		
		try {
			
			Statement guardaOfi;
			guardaOfi = ConexionBD.cn.createStatement();
			String consultaOfi= "SELECT * FROM OFICINA";
			ResultSet rs=guardaOfi.executeQuery(consultaOfi);
			entidades.Oficina ofi=null;
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				  
				  String cod=rs.getString("codigo"); 
				  String nombre=rs.getString("nombre"); 
				  String dire=rs.getString("CODDIRECCION");
				  
				  Direccion direccion=accesoBD.DireccionBD.buscaDirecciones(dire);
				  
				  //Se crea la oficina con los datos consultados.
				  ofi= new entidades.Oficina (cod, nombre, direccion);
				  //Se a�ade la nueva oficina al ArrayList
				  oficinas.add(ofi);
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return oficinas;
		
	}
	/**
	 * Sobrecarga del m�todo buscaOficinas. En este caso devuelve solo una.
	 * @param codigo
	 * @return Devuelve la oficina que corresponde al c�digo pasado por par�metro
	 */
	public static entidades.Oficina buscaOficinas(String codigo)
	{
		entidades.Oficina oficina=new entidades.Oficina();
		oficina.setCodigo(codigo);
		
		ArrayList<entidades.Oficina> oficinas=buscaOficinas();
		
		int posiciondeofi=oficinas.indexOf(oficina);
		
		for(int i=0;i<oficinas.size();i++){
			if(posiciondeofi>=0)
			{
				oficina=oficinas.get(posiciondeofi);
			}else
			{
				oficina=null;
			}
		}
		return oficina;
	}
	
	
	/**
	 * M�todo que borra oficinas de la base de datos, haciendo un delete.
	 * @param codigo - Es el c�digo de la oficina a borrar
	 * @see <a href=http://www.jtech.ua.es/j2ee/publico/lja-2012-13/sesion07-apuntes.html>P�gina de referencia</a>
	 */
	public static void borraOficina(String codigo)
	{
		
		String deleteOfi= "DELETE FROM OFICINA WHERE CODIGO='"+codigo+"'";
		//PrepareStatement comienza con �ndice 1
		Statement borraOfi;
		try {
			borraOfi=ConexionBD.cn.createStatement();
			
			ArrayList <entidades.Oficina> oficomprobar=buscaOficinas();
			//Este objeto Oficina es auxiliar, para utilizar el indexOf y comprobar si est� dentro del ArrayList
			entidades.Oficina ofiabuscar= new entidades.Oficina();
			ofiabuscar.setCodigo(codigo);
			//oficomprobar.indexOf(ofiabuscar);
			if(oficomprobar.indexOf(ofiabuscar)>=0)
			{
				borraOfi.executeUpdate(deleteOfi);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param ofi - Se le pasa un objeto oficina como par�metro
	 */
	public static void modificaOfi(entidades.Oficina ofi)
	{
		String updateofi="UPDATE OFICINA SET CODIGO=?, NOMBRE=?, CODDIRECCION=? WHERE CODIGO='"+ofi.getCodigo()+"'";
				
		try {
			PreparedStatement modifOfi;
			modifOfi=ConexionBD.cn.prepareStatement(updateofi);
			
			modifOfi.setString(1, ofi.getCodigo());
			modifOfi.setString(2, ofi.getNombre());
			
			Direccion d=ofi.getDireccion();
			DireccionBD.modificaDireccion(d);
			
			modifOfi.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
