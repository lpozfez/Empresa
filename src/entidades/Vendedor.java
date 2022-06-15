/**
 * 
 */
package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author lourdes
 *Vendedor es el empleado que se dedica a las ventas de la empresa
 */
public class Vendedor extends Empleado {

	String zona;
	
	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 * @param fnac
	 * @param domicilio
	 * @param fechaAlta
	 * @param oficinatrab
	 * @param tipo
	 * @param zona - String (Es la zona en la que trabaja el vendedor)
	 */
	public Vendedor(String dni, String nombre, String ap1, String ap2, GregorianCalendar fnac, Direccion domicilio,
			GregorianCalendar fechaAlta, Oficina oficinatrab,String tipo, String zona) {
		super(dni, nombre, ap1, ap2, fnac, domicilio, fechaAlta, oficinatrab, tipo);
		this.setZona(zona);
	}
	

	
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}



	public String getZona() {
		String aux=this.zona;
		return aux;
	}

	public void setZona(String zona) {
		String aux=zona;
		this.zona = aux;
	}
	
	//MÉTODOS
	
	//vendedor:+6 x dia del mes
	public Double nomina(int mes)
	{
		int complemento=(this.getFechaAlta().getActualMaximum(mes))*6;
		Double nomina=super.nomina(mes)+complemento;
		return nomina;
	}



	@Override
	public String toString() {
		return this.getDni();
	}

	

}
