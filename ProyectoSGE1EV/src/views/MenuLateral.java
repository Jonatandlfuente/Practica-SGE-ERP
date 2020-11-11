package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuLateral extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuLateral() {
		setTitle("Mushi ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 690);
		getContentPane().setLayout(null);
		
		JPanel pMenu = new JPanel();
		pMenu.setBackground(SystemColor.textHighlight);
		pMenu.setBounds(0, 0, 281, 643);
		getContentPane().add(pMenu);
		pMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\logo_preview_rev_1.png"));
		lblLogo.setBounds(22, 0, 190, 193);
		pMenu.add(lblLogo);
		
		JButton btnProveedores = new JButton("PROVEEDORES");
		btnProveedores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnProveedores.setSelected(true);
		btnProveedores.setForeground(new Color(0, 0, 0));
		btnProveedores.setBackground(SystemColor.textHighlight);
		btnProveedores.setBounds(0, 223, 281, 44);
		pMenu.add(btnProveedores);
		
		JButton btnVentas = new JButton("VENTAS");
		btnVentas.setBackground(SystemColor.textHighlight);
		btnVentas.setBounds(0, 290, 281, 44);
		pMenu.add(btnVentas);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.setBackground(SystemColor.textHighlight);
		btnProductos.setBounds(0, 357, 281, 44);
		pMenu.add(btnProductos);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.setBackground(SystemColor.textHighlight);
		btnClientes.setBounds(0, 423, 281, 44);
		pMenu.add(btnClientes);
		
		JButton btnCompras = new JButton("COMPRAS");
		btnCompras.setBackground(SystemColor.textHighlight);
		btnCompras.setBounds(0, 492, 281, 44);
		pMenu.add(btnCompras);
		
		JPanel pGeneral = new JPanel();
		pGeneral.setBackground(new Color(255, 255, 255));
		pGeneral.setBounds(282, 0, 773, 643);
		getContentPane().add(pGeneral);
		pGeneral.setLayout(null);
		
		JLabel lblPregunta = new JLabel("\u00BFQU\u00C9 QUIERES HACER?");
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPregunta.setBounds(230, 44, 327, 39);
		pGeneral.add(lblPregunta);
		
		JButton btbAñadir = new JButton("New button");
		btbAñadir.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\MushiERP\\img\\iconoA\u00F1adir.png"));
		btbAñadir.setBounds(149, 164, 191, 191);
		pGeneral.add(btbAñadir);
		
		JButton btnModificar = new JButton("New button");
		btnModificar.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\MushiERP\\img\\iconoModificar.png"));
		btnModificar.setBounds(455, 164, 191, 191);
		pGeneral.add(btnModificar);
		
		JButton btnConsultar = new JButton("New button");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\MushiERP\\img\\iconoConsultar.png"));
		btnConsultar.setBounds(149, 405, 191, 191);
		pGeneral.add(btnConsultar);
		
		JButton btnBorrar = new JButton("New button");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\MushiERP\\img\\iconoBorrar.png"));
		btnBorrar.setBounds(455, 405, 191, 191);
		pGeneral.add(btnBorrar);
		
		JLabel lblAñadir = new JLabel("A\u00F1adir");
		lblAñadir.setBounds(230, 135, 56, 16);
		pGeneral.add(lblAñadir);
		
		JLabel lblModificar = new JLabel("Modificar");
		lblModificar.setBounds(519, 135, 56, 16);
		pGeneral.add(lblModificar);
		
		JLabel lblBorrar = new JLabel("Borrar");
		lblBorrar.setBounds(534, 376, 56, 16);
		pGeneral.add(lblBorrar);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(215, 376, 56, 16);
		pGeneral.add(lblConsultar);
		
	}
}
