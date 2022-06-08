package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Empleado extends Persona {

	private GregorianCalendar fechaAlta;
	private Oficina oficinatrab;
	private String tipo;//Es una letra V/P
	

	/**
	 * @param dni - String
	 * @param nombre - String
	 * @param ap1 - String
	 * @param ap2 - String
	 * @param fnac - GregorianCalendar
	 * @param domicilio- Direccion
	 * @param fechaAlta -GregorianCalendar
	 * @param oficinatrab - Oficina
	 */
	public Empleado(String dni, String nombre, String ap1, String ap2, GregorianCalendar fnac, Direccion domicilio, GregorianCalendar fechaAlta,Oficina oficinatrab, String tipo) {
		super(dni, nombre, ap1, ap2, fnac, domicilio);
		this.setFechaAlta(fechaAlta);
		this.setOficinatrab(oficinatrab);
		this.setTipo(tipo);
		
	}
	
	//TODO constructor copia y encapsulamiento

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public GregorianCalendar getFechaAlta() {
		GregorianCalendar f=this.fechaAlta;
		return f;
	}

	public void setFechaAlta(GregorianCalendar ffin) {
		GregorianCalendar f=ffin;
		this.fechaAlta = f;
	}

	public Oficina getOficinatrab() {
		Oficina ofi=this.oficinatrab;
		return ofi;
	}

	public void setOficinatrab(Oficina oficinatrab) {
		Oficina ofi=oficinatrab;
		this.oficinatrab=ofi;
		
	}
	

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		String aux=this.tipo;
		return aux;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		String aux=tipo;
		this.tipo = aux;
	}

	@Override
	public String toString() {
		//return String.format("%s-%s %s %s",super.getDni(),super.nombreCompleto(),this.fechaAlta,this.oficinatrab);
		return super.getDni()+" - "+super.nombreCompleto()+" "+this.fechaAlta+" "+this.oficinatrab;
	}
	
	/**
	 * Método que devuelve los años de antiguedad de un empleado. Es un int, por lo uqe solo devuelve años completos.
	 * @return antiguedad 
	 */
	public int antiguedad()
	{
		int antiguedad = 0;
		GregorianCalendar hoy=new GregorianCalendar();
		antiguedad=hoy.YEAR-this.fechaAlta.YEAR;
		return antiguedad;
	}
	
	/**
	 * Método que calcula la nómina de un empleado, teniendo en cuenta la antiguedad del empleado y el mes.
	 * @param mes
	 * @return nomina
	 */
	public Double nomina(int mes)
	{
		Double salarioBase=500.0;
		Double nomina=salarioBase+this.antiguedad();
		return nomina;
		
	}
	//Controlar que el mes sea de 0-12?
	/*
	 * nómina para todo empleado: salario base=500+ x año antiguedad 25+ (cantidad segun tipo empleado x dias del mes) 
	 * como parametro se le pasa el mes con un int
	 *
	 * programador:+5 x dia del mes + 20 x tecnologia q tenga
	 * vendedor:+6 x dia del mes
	 */
	
	//metodo calculo antiguedad
	

}
