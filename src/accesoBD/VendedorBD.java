package accesoBD;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.*;
import metodos.MetodosFechas;

public class VendedorBD {

	/**
	 * Método que inserta un vendedor
	 * @param v
	 */
	public static void insertVendedor(Vendedor v)
	{
		//Crear el Statement
		PreparedStatement guardaVend;
		//Instruccion en SQL
		String insert="INSERT INTO VENDEDOR VALUES (?,?)";
		
		try {
			guardaVend=ConexionBD.cn.prepareStatement(insert);
			boolean comprobar=PersonaBD.buscaPersonas(v.getDni());
			if(comprobar!=true)
			{
				accesoBD.EmpleadoBD.insertaEmpleado(v);
			}
			guardaVend.setString(1, v.getDni());
			guardaVend.setString(2, v.getZona());
			guardaVend.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método que busca todos los vendedores
	 * @return
	 */
	public static ArrayList<Vendedor> buscaVendedor()
	{
		ArrayList<Vendedor> vendedores=new ArrayList<Vendedor>();
		
		try {
			
			Statement guardaVend;
			guardaVend = ConexionBD.cn.createStatement();
			String consultaVend= "SELECT * FROM VENDEDOR JOIN EMPLEAD ON VENDEDOR.DNI=EMPLEAD.DNI JOIN PERSONA ON PERSONA.DNI=EMPLEAD.DNI";
			ResultSet rs=guardaVend.executeQuery(consultaVend);
			Vendedor vend=null;
			int i=0;
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				
				  String dni=rs.getString("dni"); 
				  String nombre=rs.getString("nombre"); 
				  String ap1=rs.getString("ap1");
				  String ap2=rs.getString("ap2");
				  Date fechaNac=rs.getDate("fecha_nac");
				  String domicilio=rs.getString("CODDIR");
				  Date fechaAlta=rs.getDate("FECHAINI");
				  String codofi=rs.getString("CODIOFICINA");
				  String tipoEmpl=rs.getString("TIPOEMPL");
				  String zona=rs.getString("zona");
				  
				  GregorianCalendar fnac=MetodosFechas.cambiasqlDateaGC(fechaNac);
				  GregorianCalendar falt=MetodosFechas.cambiasqlDateaGC(fechaAlta);
				  Oficina ofi=OficinaBD.buscaOficinas(codofi);
				  Direccion direccion=accesoBD.DireccionBD.buscaDirecciones(domicilio);
				  
				  //Se crea la oficina con los datos consultados.
				  vend= new Vendedor (dni,nombre,ap1,ap2,fnac,direccion,falt,ofi,tipoEmpl,zona);
				  //Se añade la nueva oficina al ArrayList
				  vendedores.add(vend);
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return vendedores;
	}
	
	public static Vendedor buscaVendedor(String dni)
	{
		Vendedor vendedor=new Vendedor();
		vendedor.setDni(dni);
		ArrayList<Vendedor> vendedores=new ArrayList<Vendedor>();
		vendedores=buscaVendedor();
		int posicionvend=vendedores.indexOf(vendedor);
		
		for(int i=0;i<vendedores.size();i++){
			if(posicionvend>=0)
			{
				vendedor=vendedores.get(posicionvend);
			}else
			{
				vendedor=null;
			}
		}
		return vendedor;
	}
	
	
	/**
	 * Método que borra un vendedor dado por parámetro
	 * @param dni
	 */
	public static void borraVendedor(String dni)
	{
		PersonaBD.borraPersona(dni);
	}
	
	public static void modificaVend(Vendedor vend)
	{
		PersonaBD.borraPersona(vend.getDni());
		VendedorBD.insertVendedor(vend);
	}
	
	
	
}
