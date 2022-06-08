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
			
			for(int i=0;i<=pro.getTecnologias().size();i++)
			{
				guardaProg.setString(1, pro.getDni());
				guardaProg.setString(2, pro.getTecnologias().get(i));
				guardaProg.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Programador> buscaProgramador()
	{
		ArrayList<Programador> programadores=new ArrayList<Programador>();
		
		try {
			
			Statement guardaProg;
			guardaProg = ConexionBD.cn.createStatement();
			String consultaProg= "SELECT * FROM PROGRAMADOR JOIN EMPLEAD ON PROGRAMADOR.DNI=EMPLEAD.DNI JOIN PERSONA ON PERSONA.DNI=EMPLEAD.DNI";
			ResultSet rs=guardaProg.executeQuery(consultaProg);
			Programador prog=null;
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
				  String tecnologia=rs.getString("tecnologia");
				  
				  GregorianCalendar fnac=MetodosFechas.cambiasqlDateaGC(fechaNac);
				  GregorianCalendar falt=MetodosFechas.cambiasqlDateaGC(fechaAlta);
				  Oficina ofi=OficinaBD.buscaOficinas(codofi);
				  Direccion direccion=accesoBD.DireccionBD.buscaDirecciones(domicilio);
				  ArrayList<String> tecnologias=new ArrayList<String>();
				  tecnologias.add(0, tecnologia);
				  if(dni.equalsIgnoreCase(rs.getString("dni"))&i!=0)
				  {
					  tecnologias.add(i, tecnologia);
					  i=i++;
				  } 
				  //Se crea la oficina con los datos consultados.
				  prog= new Programador (dni,nombre,ap1,ap2,fnac,direccion,falt,ofi,tipoEmpl,tecnologias);
				  //Se añade la nueva oficina al ArrayList
				  programadores.add(prog);
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return programadores;
	}
	
	public static Programador buscaProgramador(String dni)
	{
		Programador programador=new Programador();
		programador.setDni(dni);
		ArrayList<Programador> programadores=new ArrayList<Programador>();
		programadores=buscaProgramador();
		int posicionprog=programadores.indexOf(programador);
		
		for(int i=0;i<programadores.size();i++){
			if(posicionprog>=0)
			{
				programador=programadores.get(posicionprog);
			}else
			{
				programador=null;
			}
		}
		return programador;
	}
	
	public static void borraProgramador(String dni)
	{
		
		String deleteProg= "DELETE FROM PROGRAMADOR WHERE DNI='"+dni+"'";
		//PrepareStatement comienza con índice 1
		Statement borraProg;
		try {
			borraProg=ConexionBD.cn.createStatement();
			
			ArrayList <Programador> progcomprobar=buscaProgramador();
			Programador progabuscar= new Programador();
			progabuscar.setDni(dni);
			if(progcomprobar.indexOf(progabuscar)>=0)
			{
				borraProg.executeUpdate(deleteProg);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public static void modificaProg(Programador prog)
	{
		String updateProg="UPDATE PROGRAMADOR SET TECNOLOGIA=? WHERE DNI='"+prog.getDni()+"'";
				
		try {
			PreparedStatement modifProg;
			modifProg=ConexionBD.cn.prepareStatement(updateProg);
			
			modifProg.setString(1, prog.getTecnologias().get(i));
			
			Oficina ofi=prog.getOficinatrab();
			OficinaBD.modificaOfi(ofi);
			
			modifProg.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	
}
