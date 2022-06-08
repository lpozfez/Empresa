/**
 * Contiene las clases del proyecto
 */
package entidades;

import java.util.Objects;

/**
 * @author lourdes
 *La clase dirección se compone de: 
 *codigo(Es un String)
 *calle(Contiene el tipo de vía y nombre de la calle, String)
 *número de vía (es una String)
 *localidad (es una String)
 */
public class Direccion {

	private String codigo;
	private String calle;
	private String numero;
	private String localidad;
	private String provincia;
	
	/**
	 * @param calle - String
	 * @param numero - String
	 * @param localidad - String
	 */
	public Direccion(String codigo, String calle, String numero, String localidad,String provincia) {
		
		this.setCodigo(codigo);
		this.setCalle(calle);
		this.setNumero(numero);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
	}
	
	//CONSTRUCTOR DE COPIA
	public Direccion(Direccion d)
	{
		this.setCodigo(d.getCodigo());
		this.setCalle(d.getCalle());
		this.setNumero(d.getNumero());
		this.setLocalidad(d.getLocalidad());
		this.setProvincia(d.getProvincia());
	}
	
	public Direccion() {
		// TODO Auto-generated constructor stub
	}

	public String getCalle() {
		String aux=this.calle;
		return aux;
	}
	public void setCalle(String calle) {
		String aux= new String(calle);
		this.calle = aux;
	}
	
	public String getNumero() {
		String aux=this.numero; 
		return aux;
	}
	
	public void setNumero(String numero) {
		String aux= new String(numero);
		this.numero = aux;
	}
	public String getLocalidad() {
		String aux=this.localidad;
		return aux;
	}
	public void setLocalidad(String localidad) {
		String aux= new String(localidad);
		this.localidad = aux;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		String aux=this.codigo;
		return aux;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		String aux= new String(codigo);
		this.codigo = aux;
	}
	

	//METODOS
	
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		String aux=this.provincia;
		return aux;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		String aux= new String(provincia);
		this.provincia = aux;
	}

	/**
	 * Una dirección será igual a otra cuando todas sus propiedades sean iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		Direccion d= (Direccion) obj;
		if((this.codigo.equalsIgnoreCase(d.codigo)))
		{
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return this.calle+" , "+this.numero+" "+this.localidad;
	}
	
	
	
	
	
	
}
