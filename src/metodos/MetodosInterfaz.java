package metodos;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MetodosInterfaz {
	//Métodos GUI
	
	/**
	 * Centra la ventana (JFrame) que se le pasa por parámetro
	 * @param ventana
	 */
	public static void centraVentana(JFrame ventana)
	{
		//Se crea una dimensión para poder centrar el jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//Se dividen la anchura y altura de la ventada a la mitad para que se cree centrado
		ventana.setLocation(dim.width/2-ventana.getSize().width/2, dim.height/2-ventana.getSize().height/2);
	}
	public static void centraVentana(JDialog ventana)
	{
		//Se crea una dimensión para poder centrar el jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//Se dividen la anchura y altura de la ventada a la mitad para que se cree centrado
		ventana.setLocation(dim.width/2-ventana.getSize().width/2, dim.height/2-ventana.getSize().height/2);
	}
	
	public static void DesactivarFormu(JPanel panel)
	{
		
				
	}
	
	

	//Menu completo en q las opcionesok sean una cadena
		public static String Menu(String[] opciones, String opcionesok, String titulo, String pregunta, String error,String simbolosubrayar)
		{ String opcionelegida=" ";
		
			return opcionelegida;
		}

		//Menú simple
		public static String Menu (String[] opciones, String[] opcionesok)
		{
			return Menu(opciones, opcionesok, "Menú de opciones", "Introduzca una de las opciones", "Error, introduzca una opción correcta","-");
		}

	
	//Menú completo
		public static String Menu(String[] opciones, String[] opcionesok, String titulo, String pregunta, String error,String simbolosubrayar)
		//Método menú en su forma más completa
		{
			String opcionelegida=" ";//Esta variable es la resultante del menú
			subrayaTexto(titulo,simbolosubrayar);//título, se solicita al usuario en esta versión
			//Se muestran las opciones que se pueden elegir
			for (int i=0;i<opciones.length;i++) 
				{
				System.out.println(opcionesok[i]+"-"+opciones[i]);//opcionesok son las opciones que el usuario debe introducir
				}
			//Se pide el dato validado con otro método
			opcionelegida=MetodosPedirdatos.pideDatovalidado(pregunta, opcionesok, error);
			return opcionelegida;
		}
		
		// escribeSimbolo simple
		public static void escribeSimbolo (int longitud)
		{//Versión para escribir algo subrayado con un guión
			escribeSimbolo(longitud, "_");
		}

		//Escribe una línea de símbolos elegidos de la longitud que se diga
		public static void escribeSimbolo (int longitud, String simbolo)
		{//Método para escribir algo subrayado
			for (int i=0; i<longitud; i++)
			{
				System.out.print(simbolo);
			}
			System.out.println("");
		}

		//Subraya texto simple
		public static void subrayaTexto (String texto)
		//método de subrayar un texto con un guión
		{
			subrayaTexto(texto, "_");
		}

		//Subraya texto con un símbolo que se pide
		public static void subrayaTexto (String texto, String simbolo)
		//método de subrayar un texto con un símbolo que se pide
		{
			System.out.println(texto);
			escribeSimbolo(texto.length(), simbolo);
		}
		
		
		
		
}
