package accesoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Direccion;

public class DireccionBD {

	public static void insertaDireccion(entidades.Direccion dir)
	{
		PreparedStatement guardadir;
		//Instrucción en sql
		String insertadirec= "INSERT INTO DIRECCION VALUES (?,?,?,?,?)";

		try {
			guardadir=ConexionBD.cn.prepareStatement(insertadirec);
			boolean comprobar=siDirYaEsta(dir);
			if(comprobar!=true)
			{
			
				guardadir.setString(1, dir.getCodigo());
				guardadir.setString(2, dir.getCalle());
				guardadir.setString(3, dir.getNumero());
				guardadir.setString(4, dir.getLocalidad());
				guardadir.setString(5, dir.getProvincia());
				//Ejecutamos el preparestatement
				guardadir.execute();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<entidades.Direccion> buscaDirecciones()
	{
		ArrayList<entidades.Direccion> oficinas=new ArrayList<entidades.Direccion>();
		
		try {
			
			Statement guardaDir;
			guardaDir = ConexionBD.cn.createStatement();
			String consultaOfi= "SELECT * FROM DIRECCION";
			ResultSet rs=guardaDir.executeQuery(consultaOfi);
			entidades.Direccion dir=null;
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				
				String codigo=rs.getString("COD");
				  String calle=rs.getString("CALLE");
				  String numero=rs.getString("NUMERO");
				  String localidad=rs.getString("LOCALIDAD");
				  String provincia=rs.getString("PROVINCIA");
				  
				  Direccion direccion=new Direccion(codigo,calle,numero,localidad,provincia); 
				  //Se crea la oficina con los datos consultados.
				  dir= new entidades.Direccion (codigo,calle,numero,localidad,provincia);
				  //Se añade la nueva oficina al ArrayList
				  oficinas.add(dir);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return oficinas;
		
	}
	
	public static ArrayList<String> buscaLocalidades()
	{
		ArrayList<String> localidades=new ArrayList<String>();
		
		try {
			
			Statement guardaLoca;
			guardaLoca = ConexionBD.cn.createStatement();
			String consultaLoc= "SELECT * FROM LOCALIDAD";
			ResultSet rs=guardaLoca.executeQuery(consultaLoc);
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				String localidad=rs.getString("NOMBRELOC");
				 localidades.add(localidad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return localidades;
	}
	public static ArrayList<String> buscaProvincias()
	{
		ArrayList<String> provincias=new ArrayList<String>();
		try {
			
				Statement guardaProv;
				guardaProv = ConexionBD.cn.createStatement();
				String consultaProv= "SELECT * FROM LOCALIDAD";
				ResultSet rs=guardaProv.executeQuery(consultaProv);
				//rs.next() es el puntero que recorre la consulta
				while(rs.next())
				{
					String provincia=rs.getString("NOMBREPROV");
					 provincias.add(provincia);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return provincias;
	}
	
	public static entidades.Direccion buscaDirecciones(String codigo)
	{
		entidades.Direccion direccion=new entidades.Direccion();
		direccion.setCodigo(codigo);
		
		ArrayList<entidades.Direccion> direcciones=buscaDirecciones();
		
		int posiciondedir=direcciones.indexOf(direccion);
		
		for(int i=0;i<direcciones.size();i++){
			if(posiciondedir>=0)
			{
				direccion=direcciones.get(posiciondedir);
			}else
			{
				direccion=null;
			}
		}
		return direccion;
	}
	
	public static void borraDireccion(String codigo)
	{
		
		String deleteDir= "DELETE FROM DIRECCION WHERE CODIGO='"+codigo+"'";
		//PrepareStatement comienza con índice 1
		Statement corraDir;
		try {
			corraDir=ConexionBD.cn.createStatement();
			
			ArrayList <entidades.Direccion> oficomprobar=buscaDirecciones();
			//Este objeto Oficina es auxiliar, para utilizar el indexOf y comprobar si está dentro del ArrayList
			entidades.Direccion dirabuscar= new entidades.Direccion();
			dirabuscar.setCodigo(codigo);
			//oficomprobar.indexOf(ofiabuscar);
			if(oficomprobar.indexOf(dirabuscar)>=0)
			{
				corraDir.executeUpdate(deleteDir);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void modificaDireccion(entidades.Direccion dir)
	{
		String updateDir="UPDATE DIRECCION SET CODIGO=?, CALLE=?, NUMERO=?, LOCALIDAD=? WHERE CODIGO='"+dir.getCodigo()+"'";
				
		try {
			PreparedStatement modifiDir;
			modifiDir=ConexionBD.cn.prepareStatement(updateDir);
			
			modifiDir.setString(1, dir.getCodigo());
			modifiDir.setString(2,dir.getCalle());
			modifiDir.setString(3,dir.getNumero());
			modifiDir.setString(4,dir.getLocalidad());
			
			modifiDir.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Método que comprueba si una dirección ya está en la base de datos.
	 * Si está te la devuelve.
	 * Si no está devuelve null.
	 * @param dir - Es la dirección que se pasa como parámetro
	 * @return Direccion
	 */
	public static boolean siDirYaEsta(Direccion dir)
	{
		Direccion aux=buscaDirecciones(dir.getCodigo());
		if(aux!= null)
		{
			return true;
		}
		return false;
	}
	
}
