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
	//private AnadirProveedor aP;
	private PanelGeneral pg;

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
				pg = new PanelGeneral();
				nuevoPanel(pg);
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
		
	}

	public void nuevoPanel(JPanel actual){
		contentPane.removeAll();
		contentPane.add(actual);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
