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
public class EmpleadoBD {

	public static void insertaEmpleado(Empleado emple) 
	{
		PreparedStatement guardaEmp;
		String insertaEmp= "INSERT INTO EMPLEAD VALUES (?,?,?,?)";
		
		try {
			guardaEmp=ConexionBD.cn.prepareStatement(insertaEmp);
		
			boolean comprobar=PersonaBD.buscaPersonas(emple.getDni());
			if(comprobar!=true)
			{	
				accesoBD.PersonaBD.insertaPersona(emple);
			}
			guardaEmp.setString(1, emple.getDni());
			guardaEmp.setDate(2, MetodosFechas.cambiaGCasqlDate(emple.getFechaAlta()));
			guardaEmp.setString(3, emple.getOficinatrab().getCodigo());
			guardaEmp.setString(4, emple.getTipo());
			guardaEmp.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Empleado> buscaEmpleados()
	{
		ArrayList<Empleado> empleados=new ArrayList<Empleado>();
		
		try {
			
			Statement guardaEMpl;
			guardaEMpl = ConexionBD.cn.createStatement();
			String consultaEmpl= "SELECT * FROM VENDEDOR FROM EMPLEAD JOIN PERSONA ON PERSONA.DNI=EMPLEAD.DNI";
			ResultSet rs=guardaEMpl.executeQuery(consultaEmpl);
			Empleado emple=null;
			//rs.next() es el puntero que recorre la consulta
			while(rs.next())
			{
				
				  String dni=rs.getString("DNI"); 
				  String nombre=rs.getString("nombre"); 
				  String ap1=rs.getString("ap1");
				  String ap2=rs.getString("ap2");
				  Date fechaNac=rs.getDate("fecha_nac");
				  String domicilio=rs.getString("CODDIR");
				  Date fechaAlta=rs.getDate("FECHAINI");
				  String codofi=rs.getString("CODIOFICINA");
				  String tipoEmpl=rs.getString("TIPOEMPL");
				  
				  GregorianCalendar fnac=MetodosFechas.cambiasqlDateaGC(fechaNac);
				  GregorianCalendar falt=MetodosFechas.cambiasqlDateaGC(fechaAlta);
				  Oficina ofi=OficinaBD.buscaOficinas(codofi);
				  Direccion direccion=accesoBD.DireccionBD.buscaDirecciones(domicilio);
				  
				  
				  //Se crea la oficina con los datos consultados.
				  emple= new Empleado (dni,nombre,ap1,ap2,fnac,direccion,falt,ofi,tipoEmpl);
				  //Se añade la nueva oficina al ArrayList
				  empleados.add(emple);
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return empleados;
	}
	
	public static Empleado buscaEmpleados(String dni)
	{
		Empleado empleado=new Empleado();
		empleado.setDni(dni);
		ArrayList<Empleado> empleados=new ArrayList<Empleado>();
		empleados=buscaEmpleados();
		int posicionempl=empleados.indexOf(empleado);
		
		for(int i=0;i<empleados.size();i++){
			if(posicionempl>=0)
			{
				empleado=empleados.get(posicionempl);
			}else
			{
				empleado=null;
			}
		}
		return empleado;
	}
	
	public static void borraEmpleado(String dni)
	{
		PersonaBD.borraPersona(dni);
	}
	
	public static void modificaOfi(Empleado emple)
	{
		String updateEmpl="UPDATE EMPLEAD SET FECHAINI=?, CODIOFICINA=?, TIPOEMPL=? WHERE DNI='"+emple.getDni()+"'";
				
		try {
			PreparedStatement modifEmpl;
			modifEmpl=ConexionBD.cn.prepareStatement(updateEmpl);
			
			modifEmpl.setDate(1, MetodosFechas.cambiaGCasqlDate(emple.getFechaAlta()));
			modifEmpl.setString(2, emple.getOficinatrab().getCodigo());
			modifEmpl.setString(3, emple.getTipo());
			
			Oficina ofi=emple.getOficinatrab();
			OficinaBD.modificaOfi(ofi);
			
			modifEmpl.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
