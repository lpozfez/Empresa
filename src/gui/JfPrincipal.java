package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.MetodosInterfaz;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class JfPrincipal extends JFrame {

	private JPanel cPprincipal;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfPrincipal frame = new JfPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JfPrincipal() {
		setTitle("Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		
		JMenuBar mBarMenuprincipal = new JMenuBar();
		setJMenuBar(mBarMenuprincipal);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JdEmpleados dialog = new JdEmpleados();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				MetodosInterfaz.centraVentana(dialog);
				
			}
		});
		mBarMenuprincipal.add(btnEmpleados);
		
		JButton btnListaPorOfis = new JButton("Listado por oficinas");
		mBarMenuprincipal.add(btnListaPorOfis);
		cPprincipal = new JPanel();
		cPprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		cPprincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(cPprincipal);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\lourd\\Desktop\\DAW\\Programaci\u00F3n\\Proyecto_Empresa\\Imagenes\\kisspng-business-private-limited-company-outsourcing-sap-skill-acquisition-sap-training-staffing-ser-5bd0a01925c670.7270996115403991291547.png"));
		cPprincipal.add(lblImagen, BorderLayout.CENTER);
	}

}
