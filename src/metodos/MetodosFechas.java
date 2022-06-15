package metodos;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetodosFechas {

	/**
	 * Método que cambia un GregorianCalendar a date sql.
	 * @param f - Fecha en GregorianCalendar
	 * @return - java.sql.Date
	 */
	public static java.sql.Date cambiaGCasqlDate(GregorianCalendar f)
	{
		int anyo=f.get(Calendar.YEAR)-1900;//El año del Calendar es year+1900
		int mes=f.get(Calendar.MONTH)-1;//El mes de Calendar comienza en 0
		int dia=f.get(Calendar.DAY_OF_MONTH);
		
		Date fCambiada=new Date(anyo,mes,dia);	
		
		java.util.Date utilDate = fCambiada;
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    
		return (java.sql.Date) sqlDate;
	}
	/**
	 * Método que pasa una fecha de sql.Date a GregorianCalendar.
	 * Para que el cambio se haga correctamente se resta 1900 al año y 1 al mes.
	 * @param f - sql.Date
	 * @return -GregorianCalendar
	 */
	public static GregorianCalendar cambiasqlDateaGC(java.sql.Date f)
	{
		f.setTime(f.getTime());
		java.util.Date futil= new java.util.Date(f.getTime());
		GregorianCalendar g=new GregorianCalendar();
		g.setTime(futil);
		int anyo=g.get(Calendar.YEAR);
		int mes=g.get(Calendar.MONTH);
		int dia=g.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar ffinal=new GregorianCalendar(anyo,mes,dia);
		return ffinal;
	}
	
	public static int diferenciaFechas(GregorianCalendar fini, GregorianCalendar ffin)
	{
		long diferencia;
		int dias;
		diferencia=(fini.getTime().getTime()-ffin.getTime().getTime());
		dias=(int) (diferencia/(24*60*60*1000));
		
		return dias;
	}
	
	public static int numDiasenMes (GregorianCalendar fecha)
	{
		int numdias=fecha.getActualMaximum(fecha.DAY_OF_MONTH);
		return numdias;
	}
	
	public static String formateaFechaGC(GregorianCalendar fecha)
	{
		//Imprimir fecha:usando SimpleDateFormat, se debe instanciar un formato para mostrar las fechas, aunque solo se hace una vez
				SimpleDateFormat Fformateada = new SimpleDateFormat("dd/MM/yyyy");
				return Fformateada.format(fecha.getTime());
	}
	
	/*
	 * https://facingissuesonit.com/2018/07/30/java-date-to-gregoriancalendar-and-gregoriancalendar-to-date-conversion/
	 * 
	 * //convert GregorianCalendar to date Date newDate=calendar.getTime();
	 * formatter=new SimpleDateFormat(DATE_FORMAT1);
	 * System.out.println(formatter.format(newDate));
	 */
	
	
	
}
