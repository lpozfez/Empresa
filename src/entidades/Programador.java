package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * 
 * @author lourdes
 *Programador es el empleado que se dedica a desarrollar aplicaciones para la empresa.
 */
public class Programador extends Empleado {
	
	ArrayList<String> tecnologias;

	
	/**
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 * @param fnac
	 * @param domicilio
	 * @param fechaAlta
	 * @param oficinatrab
	 * @param tipo
	 * @param tecnologias - ArrayList de tecnologías que domina el programador. Puede estar vacío.
	 */
	public Programador(String dni, String nombre, String ap1, String ap2, GregorianCalendar fnac, Direccion domicilio,
			GregorianCalendar fechaAlta, Oficina oficinatrab, String tipo, ArrayList tecnologias) {
		super(dni, nombre, ap1, ap2, fnac, domicilio, fechaAlta, oficinatrab, tipo);
		this.setTecnologias(tecnologias);
	}



	public Programador() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the tecnologías
	 */
	public ArrayList<String> getTecnologias() {
		return tecnologias;
	}
	public String getTecnologiasString() {
		String tecnologias="";
		for(int i=0;i<this.getTecnologias().size();i++)
		{
			tecnologias=this.getTecnologias()+" ";
		}
		return tecnologias;
	}

	/**
	 * @param tecnologías the tecnologías to set
	 */
	public void setTecnologias(ArrayList<String> tecnologias) {
		this.tecnologias = tecnologias;
	}
	
	
	
	
	@Override
	public String toString() {
		return this.getDni();
		
	}



	//MÉTODOS
	public static int numDiasenMes (GregorianCalendar fecha)
	{
		int numdias=fecha.getActualMaximum(fecha.DAY_OF_MONTH);
		return numdias;
	}
	//programador:+5 x dias del mes + 20 x tecnologia q tenga
	//exception si programador no tiene ninguna tecnología
	public Double nomina(int mes)
	{
		//int complemento=(this.getFechaAlta().getActualMaximum(mes))*5;
		int complemento=(numDiasenMes(this.getFechaAlta()))*5;
		int comple_tecno=20*(this.tecnologias.size());
		Double nomina=super.nomina(mes)+complemento+comple_tecno;
		return nomina;
		
	}
	

}
