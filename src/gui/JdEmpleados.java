package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import accesoBD.DireccionBD;
import accesoBD.OficinaBD;
import metodos.MetodosInterfaz;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class JdEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tFDni;
	private JTextField tFNombre;
	private JTextField tFAp1;
	private JTextField tFAp2;
	private JTextField tFFechaNac;
	private JTextField tFCodigoDireccion;
	private JTextField tFCalle;
	private JTextField tFNumeroDir;
	private JComboBox cBLocalidad;
	private final ButtonGroup bGTipoEmple = new ButtonGroup();
	private JComboBox cBOficinas;
	private JTextField tFZona;
	private DefaultListModel modelListaTecn;
	private JTextField tFTecnoAAñadir;
	private JList listTecnologias;

	/**
	 * Create the dialog.
	 */
	public JdEmpleados() {
		setTitle("Empleados");
		setBounds(100, 100, 608, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDni = new JLabel("DNI");
			lblDni.setBounds(31, 31, 37, 14);
			contentPanel.add(lblDni);
		}
		
		tFDni = new JTextField();
		tFDni.setText("Ej: 99999999X");
		tFDni.setBounds(106, 31, 86, 20);
		contentPanel.add(tFDni);
		tFDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 56, 46, 14);
		contentPanel.add(lblNombre);
		
		tFNombre = new JTextField();
		tFNombre.setBounds(106, 56, 154, 20);
		contentPanel.add(tFNombre);
		tFNombre.setColumns(10);
		
		JLabel lblAp1 = new JLabel("Apellido 1");
		lblAp1.setBounds(31, 81, 46, 14);
		contentPanel.add(lblAp1);
		
		JLabel lblAp2 = new JLabel("Apellido 2");
		lblAp2.setBounds(31, 106, 46, 14);
		contentPanel.add(lblAp2);
		
		tFAp1 = new JTextField();
		tFAp1.setBounds(106, 81, 154, 20);
		contentPanel.add(tFAp1);
		tFAp1.setColumns(10);
		
		tFAp2 = new JTextField();
		tFAp2.setBounds(106, 106, 154, 20);
		contentPanel.add(tFAp2);
		tFAp2.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nacimiento");
		lblFechaNac.setBounds(31, 134, 96, 14);
		contentPanel.add(lblFechaNac);
		
		tFFechaNac = new JTextField();
		tFFechaNac.setBounds(128, 131, 86, 20);
		contentPanel.add(tFFechaNac);
		tFFechaNac.setColumns(10);
		
		JLabel lblCodDireccion = new JLabel("C\u00F3digo");
		lblCodDireccion.setBounds(304, 58, 46, 14);
		contentPanel.add(lblCodDireccion);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(304, 83, 46, 14);
		contentPanel.add(lblCalle);
		
		JLabel lblNum = new JLabel("N\u00FAmero");
		lblNum.setBounds(304, 108, 46, 14);
		contentPanel.add(lblNum);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(304, 133, 46, 14);
		contentPanel.add(lblLocalidad);
		
		JSeparator separatorProg = new JSeparator();
		separatorProg.setBounds(31, 172, 532, 2);
		contentPanel.add(separatorProg);
		
		tFCodigoDireccion = new JTextField();
		tFCodigoDireccion.setText("Ej:JA01");
		tFCodigoDireccion.setBounds(360, 55, 46, 20);
		contentPanel.add(tFCodigoDireccion);
		tFCodigoDireccion.setColumns(10);
		
		tFCalle = new JTextField();
		tFCalle.setBounds(360, 80, 210, 20);
		contentPanel.add(tFCalle);
		tFCalle.setColumns(10);
		
		tFNumeroDir = new JTextField();
		tFNumeroDir.setBounds(360, 105, 46, 20);
		contentPanel.add(tFNumeroDir);
		tFNumeroDir.setColumns(10);
		
		cBLocalidad = new JComboBox();
		cBLocalidad.setBounds(360, 129, 210, 22);
		contentPanel.add(cBLocalidad);
		//Añadimos al comboBox las localidades desde la base de datos
		llenaCBLocalidades();
		
		JLabel lblTipoEmpl = new JLabel("Tipo de empleado:");
		lblTipoEmpl.setBounds(31, 181, 119, 14);
		contentPanel.add(lblTipoEmpl);
		
		JRadioButton rdbtnProgramador = new JRadioButton("Programador");
		bGTipoEmple.add(rdbtnProgramador);
		rdbtnProgramador.setBounds(31, 202, 109, 23);
		contentPanel.add(rdbtnProgramador);
		
		JRadioButton rdbtnVendedor = new JRadioButton("Vendedor");
		bGTipoEmple.add(rdbtnVendedor);
		rdbtnVendedor.setBounds(31, 228, 109, 23);
		contentPanel.add(rdbtnVendedor);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta");
		lblFechaAlta.setBounds(31, 284, 96, 14);
		contentPanel.add(lblFechaAlta);
		
		JCalendar calendarFalta=new JCalendar();
		calendarFalta.setBounds(31, 309, 173, 117);
		contentPanel.add(calendarFalta);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JdListadoEmple dialog = new JdListadoEmple();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				MetodosInterfaz.centraVentana(dialog);
			}
		});
		btnBuscar.setBounds(202, 27, 89, 23);
		contentPanel.add(btnBuscar);
		
		JSeparator separatorProg_1 = new JSeparator();
		separatorProg_1.setBounds(301, 46, 269, 2);
		contentPanel.add(separatorProg_1);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(304, 30, 86, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblOficina = new JLabel("Oficina");
		lblOficina.setBounds(233, 201, 58, 14);
		contentPanel.add(lblOficina);
		
		cBOficinas = new JComboBox();
		cBOficinas.setBounds(304, 193, 244, 22);
		contentPanel.add(cBOficinas);
		llenaCBOficinas();
		
		JLabel lblZona = new JLabel("Zona");
		lblZona.setBounds(233, 226, 46, 14);
		contentPanel.add(lblZona);
		
		tFZona = new JTextField();
		tFZona.setBounds(304, 225, 194, 20);
		contentPanel.add(tFZona);
		tFZona.setColumns(10);
		
//Tecnologías
		
		JScrollPane scrollPaneTecnologias = new JScrollPane();
		scrollPaneTecnologias.setBounds(233, 302, 244, 78);
		contentPanel.add(scrollPaneTecnologias);
		
		listTecnologias = new JList();
		scrollPaneTecnologias.setViewportView(listTecnologias);
		modelListaTecn = new DefaultListModel();
		
		
		JLabel lblTecnologias = new JLabel("Tecnolog\u00EDas:");
		lblTecnologias.setBounds(233, 284, 117, 14);
		contentPanel.add(lblTecnologias);
		
		JButton btnAñadirTecn = new JButton("+");
		btnAñadirTecn.setBounds(487, 357, 46, 23);
		contentPanel.add(btnAñadirTecn);
		
		JButton btnBorrarTecn = new JButton("-");
		btnBorrarTecn.setBounds(487, 388, 46, 23);
		contentPanel.add(btnBorrarTecn);
		
		tFTecnoAAñadir = new JTextField();
		tFTecnoAAñadir.setBounds(233, 391, 244, 20);
		contentPanel.add(tFTecnoAAñadir);
		tFTecnoAAñadir.setColumns(10);
		

		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton okBBorraEmpleado = new JButton("Borrar");
			okBBorraEmpleado.setActionCommand("OK");
			buttonPane.add(okBBorraEmpleado);
			{
				JButton okBGuardaEmpleado = new JButton("Guardar");
				okBGuardaEmpleado.setActionCommand("OK");
				buttonPane.add(okBGuardaEmpleado);
				getRootPane().setDefaultButton(okBGuardaEmpleado);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Método que llena el combobox de oficinas
	 */
	private void llenaCBOficinas()
	{
		DefaultComboBoxModel d=new DefaultComboBoxModel();
		d.addAll(OficinaBD.buscaOficinas());
		cBOficinas.setModel(d);
		cBOficinas.setSelectedIndex(0);
	}

	/**
	 * Método que llena el combobox localidades
	 */
	private void llenaCBLocalidades() {
		
		DefaultComboBoxModel d=new DefaultComboBoxModel();
		d.addAll(DireccionBD.buscaLocalidades());
		cBLocalidad.setModel(d);
		cBLocalidad.setSelectedIndex(0);
	}
	
	/**
	 * Método que añade la tecnología del campo de texto a la lista de tecnologías
	 */
	private void agregarTecno()
	{
		String tecnologia=tFTecnoAAñadir.getText();
		modelListaTecn.addElement(tecnologia);
		listTecnologias.setModel(modelListaTecn);
		//Limpiamos el campo de texto
		tFTecnoAAñadir.setText("");
	}
}