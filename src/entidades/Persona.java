package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Persona implements Comparable <Persona> {
//Añadir excepciones a los set
	private String dni;
	private String nombre;
	private String ap1;
	private String ap2;
	private GregorianCalendar fnac;
	private Direccion domicilio;
	
//CONSTRUCTORES
	
	public Persona() {
	
	}
	
	/**
	 * @param dni - String
	 * @param nombre - String
	 * @param ap1 - String
	 * @param ap2 - String
	 * @param fnac - GregorianCalendar
	 * @param domicilio - Direccion
	 */
	public Persona(String dni, String nombre, String ap1, String ap2, GregorianCalendar fnac, Direccion domicilio) {
		
		this.setDni(dni);
		this.setNombre(nombre);
		this.setAp1(ap1);
		this.setAp2(ap2);
		this.setFnac(fnac);
		this.setDomicilio(domicilio);
	}
	
	//CONSTRUCTOR DE COPIA
	public Persona(Persona p)
	{
		this.setDni(p.getDni());
		this.setNombre(p.getNombre());
		this.setAp1(p.getAp1());
		this.setAp2(p.getAp2());
		this.setFnac(p.fnac);
		this.setDomicilio(p.getDomicilio());
	}

//GETTERS SETTERS	
	
	public String getNombre() {
		String aux=new String(this.nombre);
		return aux;
	}
	public void setNombre(String nombre) {
		String aux=new String(nombre);
		this.nombre = aux;
	}
	public String getAp1() {
		String aux=new String(this.ap1);
		return aux;
	}
	public void setAp1(String ap1) {
		String aux=new String(ap1);
		this.ap1 = aux;
	}
	public String getAp2() {
		String aux=new String(ap2);
		return aux;
	}
	public void setAp2(String ap2) {
		String aux=new String(ap2);
		this.ap2 = aux;
	}
	public String getDni() {
		String aux=this.dni;
		return aux;
	}
	public void setDni(String dni) {
		String aux=new String(dni);
		this.dni = aux;
	}
	
	public GregorianCalendar getFnac() {
		GregorianCalendar aux= this.fnac;
		return aux;
	}
	
	public void setFnac(GregorianCalendar fnac) {
		GregorianCalendar f= fnac;
		this.fnac=f;
	}
	
	
	public Direccion getDomicilio() {
		Direccion aux=this.domicilio;
		return aux;
	}

	
	public void setDomicilio(Direccion domicilio) {
		Direccion aux=new Direccion(domicilio);
		this.domicilio=aux;
	}
	
	
	
	//METODOS
	
	@Override
	public String toString() {
		return dni+" - "+nombre+" "+ap1+" "+ap2;
	}
	
	/**
	 * Devuelve un entero según una persona sea mayor o menor en cuanto a ordenación.
	 * Duelve 0 si son iguales
	 * 
	 */
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		//return this.ap1.compareToIgnoreCase(o.ap1);
		if(this.ap1.compareToIgnoreCase(o.ap1)<0)
		{
			return -1;
		}else
			if(this.ap1.compareToIgnoreCase(o.ap1)>0)
			{
				return 1;
			}else
				if(this.ap1.compareToIgnoreCase(o.ap1)==0 && this.ap2.compareToIgnoreCase(o.ap2)==0 && this.nombre.compareToIgnoreCase(o.nombre)==0)
				{
					return 0;
				}
		return 0;
	}
		
	/**
	 * Dos personas son iguales si su DNI es igual
	 */
	@Override
	public boolean equals(Object obj) {
		Persona p=(Persona)obj;
		if (this.dni.equalsIgnoreCase(p.dni))
			return true;
		else {
			return false;
		}
		
	}
	
	public String nombreCompleto()
	{
		return this.ap1+" "+this.ap2+", "+this.nombre;
	}
	
	
	
	
}
	 
	
	










//http://puntocomnoesunlenguaje.blogspot.com/2015/10/ejemplo-de-relaciones-entre-clases-java-composicion.html
