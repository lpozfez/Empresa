package accesoBD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Programador;
import entidades.*;

public class VendedorBD {

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
}
