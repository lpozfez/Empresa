package metodos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosPedirdatos {
	
	
	//Pide dato validado
		public static String pideDatovalidado(String mensaje, String[]opcionesok, String error)
		{
			//M�todo que pide un dato de cadena y mira si est� dentro de un vector de cadenas
			String datook=" ";//Esta es la variable que dar� el dato correcto
			Scanner lector= new Scanner(System.in);
			String datoAvalidar;
			do//Nos aseguramos de que el dato est� en las opciones correctas
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

		//Pide DNI v�lido
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
	
	
		//Valida el DNI que se le d�
		public static boolean ValidaDni(String dni)
		//M�todo que te dice si un DNI que se le d� es correcto. 
		{
			boolean dniValido=false;//Variable que devuelve si el dni es valido o no
			String numdni=dni.substring(0, 8);//Variable que contiene los n�meros del dni como cadena
			String letradni=dni.substring(8, 9);//Contiene la letra del dni dado
			double numerodni=Double.valueOf(numdni);//Variable que contiene el n�mero de dni como doble
			letradni=letradni.toLowerCase();
			//Miramos si es correcto
			if (letradni.equals(Calculaletradni(numerodni)))
			{
				dniValido=true;
			}
			
			
			return dniValido;
		}
		
		//M�todo que calcula la letra de un DNI, d�ndole el n�mero
		public static String Calculaletradni(double numdni)
		{
			//M�todo que calcula la letra de un DNI, d�ndole el n�mero

			String letradni=" ";
			String[] letrasokdni= {"t","r","w","a","g","m","y","f","p","d","x","b","n","j","z","s","q","v","h","l","c","k","e"};
			double modulonumdni=numdni%23;
			for (int i=0; i<23;i++)
			{
				if(modulonumdni==i)//si el m�dulo es igual a i queremos que nos devuelva la letra 
				{
					letradni=letrasokdni[i];
				}
			}
			
			return letradni;
		}
		
		//M�todo que busca una cadena dentro de un vector de cadenas
				public static int CadenadentroVector(String[] vector, String cadenaabuscar)
				{
					//M�todo que busca una cadena dentro de un vector de cadenas
					int posicion=-1;
					for (int i=0;i<vector.length;i++)//recorremos el vector
					{
						posicion=vector[i].indexOf(cadenaabuscar);//Guardamos la posici�n del vector en la que se encuentra la cadena buscada
						
						if (posicion>-1) //Si la cadena est� dentro del vector, la guardamos en la variable resultante, si no, quedar� el -1
						{
							posicion=vector[i].indexOf(cadenaabuscar);
							break;
						}
						
					}
					return posicion;
				}
}

	
	
	
	
	
	

