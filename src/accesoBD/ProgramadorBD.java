package accesoBD;

import java.sql.Array;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.*;
import metodos.MetodosFechas;

public class ProgramadorBD {

	/**
	 * Método que inserta un programador dado por parámetro.
	 * @param pro
	 */
	public static void insertProgramador(Programador pro)
	{
		//Crear el Statement
		PreparedStatement guardaProg;
		//Instruccion en SQL
		String insert="INSERT INTO PROGRAMADOR VALUES (?,?)";
		
		try {
			guardaProg=ConexionBD.cn.prepareStatement(insert);
			boolean comprobar=PersonaBD.buscaPersonas(pro.getDni());
			if(comprobar!=true)
			{
				accesoBD.EmpleadoBD.insertaEmpleado(pro);
			}
			for(int i=0;i<pro.getTecnologias().size();i++)
			{
				guardaProg.setString(1, pro.getDni());
				guardaProg.setString(2,pro.getTecnologias().get(i));
				guardaProg.execute();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método que devuelve un ArrayList de programadores.
	 * @return
	 */
	public static ArrayList<Programador> buscaProgramador()
	{
		ArrayList<Programador> programadores=new ArrayList<Programador>();
		
		try {
			
			Statement guardaProg;
			guardaProg = ConexionBD.cn.createStatement();
			String consultaProg= "SELECT * FROM PROGRAMADOR JOIN EMPLEAD ON PROGRAMADOR.DNI=EMPLEAD.DNI JOIN PERSONA ON PERSONA.DNI=EMPLEAD.DNI";
			ResultSet rs=guardaProg.executeQuery(consultaProg);
			int numfilas=0;
			String dni1 = null; 
			  String nombre = null;
			  String ap1 = null;
			  String ap2 = null;
			  Date fechaNac = null;
			  String domicilio = null;
			  Date fechaAlta = null;
			  String codofi = null;
			  String tipoEmpl = null;
			  String tecnologia = null;
			  GregorianCalendar fnac = null;
			  GregorianCalendar falt = null;
			  Oficina ofi = null;
			  Direccion direccion = null;
			ArrayList<String> tecnologias=new ArrayList<String>();
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				numfilas=numfilas+1;
				  dni1=rs.getString("dni"); 
				  nombre=rs.getString("nombre"); 
				  ap1=rs.getString("ap1");
				  ap2=rs.getString("ap2");
				  fechaNac=rs.getDate("fecha_nac");
				  domicilio=rs.getString("CODDIR");
				  fechaAlta=rs.getDate("FECHAINI");
				  codofi=rs.getString("CODIOFICINA");
				  tipoEmpl=rs.getString("TIPOEMPL");
				  tecnologia=rs.getString("tecnologia");
				  tecnologias.add(tecnologia);
				  fnac=MetodosFechas.cambiasqlDateaGC(fechaNac);
				  falt=MetodosFechas.cambiasqlDateaGC(fechaAlta);
				  ofi=OficinaBD.buscaOficinas(codofi);
				  direccion=accesoBD.DireccionBD.buscaDirecciones(domicilio);
			}	
			Programador programador= new Programador (dni1,nombre,ap1,ap2,fnac,direccion,falt,ofi,tipoEmpl,tecnologias);
			programadores.add(programador);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return programadores;
	}
	/**
	 * Método que devuelve un programador dado por parámetro su dni.
	 * @param dni
	 * @return
	 */
	public static Programador buscaProgramador(String dni)
	{
		Programador programador=new Programador();
		programador.setDni(dni);
		ArrayList<Programador> programadores=new ArrayList<Programador>();
		programadores=buscaProgramador();
		int posicionProg=programadores.indexOf(programador);
		
		for(int i=0;i<programadores.size();i++){
			if(posicionProg>=0)
			{
				programador=programadores.get(posicionProg);
			}else
			{
				programador=null;
			}
		}
		return programador;
	}
	
	public static void borraProgramador(String dni)
	{
		PersonaBD.borraPersona(dni);
	}
	
	public static void modificaProg(Programador prog)
	{
		PersonaBD.borraPersona(prog.getDni());
		ProgramadorBD.insertProgramador(prog);
	}
		
	
}
