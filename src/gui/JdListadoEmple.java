package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoBD.EmpleadoBD;
import entidades.*;
import metodos.MetodosFechas;

import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class JdListadoEmple extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableMuestraEmple;
	private DefaultTableModel modelTabla;


	/**
	 * Create the dialog.
	 */
	public JdListadoEmple() {
		setTitle("Listado empleados");
		setBounds(100, 100, 610, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane sPScrollTabla = new JScrollPane();
		sPScrollTabla.setBounds(10, 11, 574, 312);
		contentPanel.add(sPScrollTabla);
		
		
		tableMuestraEmple = new JTable();
		modelTabla=new DefaultTableModel();
		tableMuestraEmple.setModel(modelTabla);
		llenaTablaEmpleados(tableMuestraEmple);
		
		sPScrollTabla.setViewportView(tableMuestraEmple);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	private void llenaTablaEmpleados(JTable tabla)
	{
		ArrayList<Empleado> Empleados=EmpleadoBD.leeEmpleados();
		//Añadimos las columnas a la tabla
		modelTabla.addColumn("Nombre");
		modelTabla.addColumn("Fecha Alta");
		modelTabla.addColumn("Oficina");
		modelTabla.addColumn("Tipo Empleado");
		modelTabla.addColumn("DNI");
		//Añadimos las filas
		for (Empleado empleado : Empleados) {
			Object[] fila=new Object[5];
			fila[0]=empleado.nombreCompleto();
			fila[1]=MetodosFechas.formateaFechaGC(empleado.getFechaAlta());
			fila[2]=empleado.getOficinatrab().getNombre();
			fila[3]=empleado.getClass().getName().substring(10);
			fila[4]=empleado;
			modelTabla.addRow(fila);
		}
	}
}
