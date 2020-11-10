import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Mushi ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 690);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel, "name_154338621588300");
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(-33, 0, 225, 185);
		label.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\logo_preview_rev_1.png"));
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoUsername.png"));
		label_1.setBounds(926, 44, 57, 40);
		panel.add(label_1);
		
		JLabel lblBienvenidoX = new JLabel("Bienvenido, x");
		lblBienvenidoX.setBounds(821, 56, 122, 16);
		panel.add(lblBienvenidoX);
		
		JButton btnProveedores = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral ml = new MenuLateral();
				ml.setVisible(true);
			}
		});
		btnProveedores.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoProveedores.png"));
		btnProveedores.setBounds(168, 159, 206, 171);
		panel.add(btnProveedores);
		
		JButton btnVentas = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral ml = new MenuLateral();
				ml.setVisible(true);
			}
		});
		btnVentas.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoVentas.png"));
		btnVentas.setBounds(453, 159, 206, 171);
		panel.add(btnVentas);
		
		JButton btnProductos = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral ml = new MenuLateral();
				ml.setVisible(true);
			}
		});
		btnProductos.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoProductos.png"));
		btnProductos.setBounds(737, 159, 206, 171);
		panel.add(btnProductos);
		
		JButton btnClientes = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral ml = new MenuLateral();
				ml.setVisible(true);
			}
		});
		btnClientes.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoClinetes.png"));
		btnClientes.setBounds(314, 399, 206, 171);
		panel.add(btnClientes);
		
		JButton btnCompras = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral ml = new MenuLateral();
				ml.setVisible(true);
			}
		});
		btnCompras.setIcon(new ImageIcon("C:\\Users\\loren\\eclipse-workspace\\SgeErp\\img\\iconoCompras.png"));
		btnCompras.setBounds(625, 399, 206, 171);
		panel.add(btnCompras);
		
		JLabel lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setBounds(223, 343, 91, 16);
		panel.add(lblProveedores);
		
		JLabel lblVentas = new JLabel("VENTAS");
		lblVentas.setBounds(537, 343, 57, 16);
		panel.add(lblVentas);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setBounds(811, 343, 91, 16);
		panel.add(lblProductos);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setBounds(389, 591, 91, 16);
		panel.add(lblClientes);
		
		JLabel lblCompras = new JLabel("COMPRAS");
		lblCompras.setBounds(702, 591, 91, 16);
		panel.add(lblCompras);
		
		
	}

}
