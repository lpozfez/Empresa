/**
 * 
 */
package entidades;

import java.util.Objects;

/**
 * @author lourdes
 *
 */
public class Oficina {

	private String codigo;
	private String nombre;
	private Direccion direccion;
	
	/**
	 * @param codigo - String
	 * @param nombre - String
	 * @param direccion - Direccion
	 */
	public Oficina(String codigo, String nombre, Direccion direccion) {
		super();
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}
	
	//Constructor de copia
	public Oficina(Oficina ofi)
	{
		this.setCodigo(ofi.getCodigo());
		this.setNombre(ofi.getNombre());
		this.setDireccion(ofi.getDireccion());
	}

	public Oficina(String cod, String descrip, String local, String prov, String ofiae) {
		// TODO Auto-generated constructor stub
	}

	public Oficina() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		String aux= this.codigo;
		return aux;
	}

	public void setCodigo(String codigo) {
		String aux=new String(codigo);
		this.codigo = aux;
	}

	public String getNombre() {
		String aux=this.nombre;
		return aux;
	}

	public void setNombre(String nombre) {
		String aux= new String(nombre);
		this.nombre = aux;
	}

	public Direccion getDireccion() {
		Direccion aux=this.direccion;
		return aux;
	}

	public void setDireccion(Direccion direccion) {
		Direccion aux= new Direccion(direccion);
		this.direccion = aux;
	}
	
	//METODOS

	@Override
	public String toString() {
		return this.nombre;
	}

	/**
	 * Una oficina será igual a otra cuando su código sea el mismo
	 */
	@Override
	public boolean equals(Object obj) {
		Oficina ofi=(Oficina)obj;
		if(this.getCodigo().equalsIgnoreCase(ofi.getCodigo()))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	
}
