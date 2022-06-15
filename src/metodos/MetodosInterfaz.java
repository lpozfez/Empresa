package metodos;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MetodosInterfaz {
	//M�todos GUI
	
	/**
	 * Centra la ventana (JFrame) que se le pasa por par�metro
	 * @param ventana
	 */
	public static void centraVentana(JFrame ventana)
	{
		//Se crea una dimensi�n para poder centrar el jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//Se dividen la anchura y altura de la ventada a la mitad para que se cree centrado
		ventana.setLocation(dim.width/2-ventana.getSize().width/2, dim.height/2-ventana.getSize().height/2);
	}
	public static void centraVentana(JDialog ventana)
	{
		//Se crea una dimensi�n para poder centrar el jframe
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

		//Men� simple
		public static String Menu (String[] opciones, String[] opcionesok)
		{
			return Menu(opciones, opcionesok, "Men� de opciones", "Introduzca una de las opciones", "Error, introduzca una opci�n correcta","-");
		}

	
	//Men� completo
		public static String Menu(String[] opciones, String[] opcionesok, String titulo, String pregunta, String error,String simbolosubrayar)
		//M�todo men� en su forma m�s completa
		{
			String opcionelegida=" ";//Esta variable es la resultante del men�
			subrayaTexto(titulo,simbolosubrayar);//t�tulo, se solicita al usuario en esta versi�n
			//Se muestran las opciones que se pueden elegir
			for (int i=0;i<opciones.length;i++) 
				{
				System.out.println(opcionesok[i]+"-"+opciones[i]);//opcionesok son las opciones que el usuario debe introducir
				}
			//Se pide el dato validado con otro m�todo
			opcionelegida=MetodosPedirdatos.pideDatovalidado(pregunta, opcionesok, error);
			return opcionelegida;
		}
		
		// escribeSimbolo simple
		public static void escribeSimbolo (int longitud)
		{//Versi�n para escribir algo subrayado con un gui�n
			escribeSimbolo(longitud, "_");
		}

		//Escribe una l�nea de s�mbolos elegidos de la longitud que se diga
		public static void escribeSimbolo (int longitud, String simbolo)
		{//M�todo para escribir algo subrayado
			for (int i=0; i<longitud; i++)
			{
				System.out.print(simbolo);
			}
			System.out.println("");
		}

		//Subraya texto simple
		public static void subrayaTexto (String texto)
		//m�todo de subrayar un texto con un gui�n
		{
			subrayaTexto(texto, "_");
		}

		//Subraya texto con un s�mbolo que se pide
		public static void subrayaTexto (String texto, String simbolo)
		//m�todo de subrayar un texto con un s�mbolo que se pide
		{
			System.out.println(texto);
			escribeSimbolo(texto.length(), simbolo);
		}
		
		
		
		
}
