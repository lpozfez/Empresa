package metodos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosPedirdatos {
	
	
	//Pide dato validado
		public static String pideDatovalidado(String mensaje, String[]opcionesok, String error)
		{
			//Método que pide un dato de cadena y mira si está dentro de un vector de cadenas
			String datook=" ";//Esta es la variable que dará el dato correcto
			Scanner lector= new Scanner(System.in);
			String datoAvalidar;
			do//Nos aseguramos de que el dato está en las opciones correctas
			{
				System.out.println(mensaje);
				datoAvalidar=lector.nextLine();//Pedir el dato
				datoAvalidar=datoAvalidar.toUpperCase();
				//Si el dato no es correcto, mostramos el error
				if (CadenadentroVector(opcionesok, datoAvalidar)<0)
				{
					System.out.println(error);
				}
			}while(CadenadentroVector(opcionesok, datoAvalidar)<0);
			datook=datoAvalidar;//El dato ya es correcto
			return datook;
		}

		//Pide DNI válido
		public static String pideDNIvalido(String mensaje, String error)
		{
			//Pide un DNI, lo valida y lo devuelve correcto 
			Scanner lector= new Scanner(System.in);
			String dniok=" ";
			boolean dniValido=false;//Variable que devuelve si el dni es valido o no
			do
			{
				System.out.println(mensaje);
				String dni=lector.next();
				dniValido=ValidaDni(dni);
				if (dniValido==true)
				{
					dniok=dni;
				}
				else
				{
					System.out.println(error);
				}
			}while(dniValido==false);
			return dniok;
		}
	
	
		//Valida el DNI que se le dé
		public static boolean ValidaDni(String dni)
		//Método que te dice si un DNI que se le dé es correcto. 
		{
			boolean dniValido=false;//Variable que devuelve si el dni es valido o no
			String numdni=dni.substring(0, 8);//Variable que contiene los números del dni como cadena
			String letradni=dni.substring(8, 9);//Contiene la letra del dni dado
			double numerodni=Double.valueOf(numdni);//Variable que contiene el número de dni como doble
			letradni=letradni.toLowerCase();
			//Miramos si es correcto
			if (letradni.equals(Calculaletradni(numerodni)))
			{
				dniValido=true;
			}
			
			
			return dniValido;
		}
		
		//Método que calcula la letra de un DNI, dándole el número
		public static String Calculaletradni(double numdni)
		{
			//Método que calcula la letra de un DNI, dándole el número

			String letradni=" ";
			String[] letrasokdni= {"t","r","w","a","g","m","y","f","p","d","x","b","n","j","z","s","q","v","h","l","c","k","e"};
			double modulonumdni=numdni%23;
			for (int i=0; i<23;i++)
			{
				if(modulonumdni==i)//si el módulo es igual a i queremos que nos devuelva la letra 
				{
					letradni=letrasokdni[i];
				}
			}
			
			return letradni;
		}
		
		//Método que busca una cadena dentro de un vector de cadenas
				public static int CadenadentroVector(String[] vector, String cadenaabuscar)
				{
					//Método que busca una cadena dentro de un vector de cadenas
					int posicion=-1;
					for (int i=0;i<vector.length;i++)//recorremos el vector
					{
						posicion=vector[i].indexOf(cadenaabuscar);//Guardamos la posición del vector en la que se encuentra la cadena buscada
						
						if (posicion>-1) //Si la cadena está dentro del vector, la guardamos en la variable resultante, si no, quedará el -1
						{
							posicion=vector[i].indexOf(cadenaabuscar);
							break;
						}
						
					}
					return posicion;
				}
}

	
	
	
	
	
	

