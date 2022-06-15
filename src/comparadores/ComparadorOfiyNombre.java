package comparadores;

import java.util.Comparator;

import entidades.Empleado;

public class ComparadorOfiyNombre implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		// TODO Auto-generated method stub
		String s1=e1.getOficinatrab().getNombre()+e1.nombreCompleto();
		String s2=e2.getOficinatrab().getNombre()+e2.nombreCompleto();
		return s1.compareTo(s2);
	}

}
