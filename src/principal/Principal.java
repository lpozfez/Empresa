package principal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import accesoBD.OficinaBD;
import accesoBD.PersonaBD;
import accesoBD.ProgramadorBD;
import accesoBD.VendedorBD;
import entidades.*;
import metodos.MetodosFechas;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		accesoBD.ConexionBD.creaConexion();
//Pruebo el método cambia fechas
		/*
		System.out.println("Pasar de GC a SQLDate");
		GregorianCalendar futil= new GregorianCalendar(1999,9,15);
		java.sql.Date sqlDate=MetodosFechas.cambiaGCasqlDate(futil);
		
		System.out.println("Gregorian Calendar util: "+futil.getTime());
		System.out.println("Date sql: "+sqlDate);
		System.out.println("");
		System.out.println("Pasar de SQLDate a GC");
	
		java.sql.Date fechasql=new java.sql.Date (1992,8,10);
		GregorianCalendar util= MetodosFechas.cambiasqlDateaGC(fechasql);
		
		System.out.println(fechasql);
		System.out.println(util.getTime());
		*/
		
		
//PRUEBAS VENDEDOR
		/*
		//GregorianCalendar fechaAlta, Oficina oficinatrab,String tipo, String zona
		GregorianCalendar fechanac= new GregorianCalendar(1999,9,15);
		Direccion domicilio=new Direccion("JA01","C/CERÓN","10","JAÉN","JAÉN");
		GregorianCalendar alta= new GregorianCalendar(2021,10,1);
		Oficina ofi=OficinaBD.buscaOficinas("GA03");
		Vendedor v1=new Vendedor("77374614S", "ANA", "CASTELLÓN", "LIMÓN", fechanac, domicilio, alta, ofi, "V", "JAÉN-GRANADA");
		//VendedorBD.insertVendedor(v1);
		VendedorBD.modificaVend(v1);
		*/
		//VendedorBD.borraVendedor("77374614S");
		/*
		ArrayList<Vendedor> vendedores=VendedorBD.buscaVendedor();
		System.out.println(vendedores);
		
		boolean estaelvendedor=PersonaBD.buscaPersonas("77374614S");
		System.out.println(estaelvendedor);
		*/
//PRUEBAS PROGRAMADOR
		/*
		GregorianCalendar fechanac= new GregorianCalendar(1995,10,24);
		Direccion domicilio=new Direccion("JA02","PZ. LOS PLANETAS","50B","JAÉN","JAÉN");
		GregorianCalendar alta= new GregorianCalendar(2020,1,1);
		Oficina ofi=OficinaBD.buscaOficinas("GA03");
		ArrayList<String> tecnologias=new ArrayList<String>();
		tecnologias.add("JAVA");
		tecnologias.add("ORACLE");
		tecnologias.add("C++");
		Programador p1=new Programador("25947372Z", "LORENZO", "PÉREZ", "LÓPEZ", fechanac, domicilio, alta, ofi, "P",tecnologias );
		ProgramadorBD.insertProgramador(p1);
		
		ProgramadorBD.borraProgramador("25947372Z");
		System.out.println(ProgramadorBD.buscaProgramador("25947372Z"));
		*/
			/*
				Direccion dir= new Direccion("GR01","AVD PLAZA DE TOROS","25","GRANADA","GRANADA");
				Oficina ofi= new Oficina("GA03", "GRANADA PLAZA DE TOROS",dir );
				OficinaBD.insertaOficina(ofi);	
				
				
				
				//OficinaBD.borraOficina("GA03");
				ArrayList oficinas=OficinaBD.buscaOficinas();
				  
				for(int i=0;i< oficinas.size() ;i++) {
					System.out.println(oficinas.get(i).toString());
				}
					 
				*/ 
		//Oficina ofi= new Oficina("GA03", "GRANADA-PLAZA TOROS",dir );
		
		//OficinaBD.modificaOfi(ofi);
		
		//Oficina oficina=OficinaBD.buscaOficinas("GA03");
			//System.out.println(oficina);
		
		//OficinaBD.borraOficina("GA03");
				
		
		
	}

}
