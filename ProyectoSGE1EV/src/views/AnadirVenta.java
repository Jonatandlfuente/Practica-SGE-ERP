package views;

import javax.swing.JPanel;

import controllers.BbddControllers;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AnadirVenta extends JPanel {

	private JList lProductos;
	private DefaultListModel modelo; 
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox cmbPersonal, cmbCliente; 
	private DefaultListModel jList = new DefaultListModel();

	/**
	 * Create the panel.
	 */
	public AnadirVenta() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVentas.setBounds(685, 13, 56, 16);
		panel.add(lblVentas);
		
		lProductos = new JList();
		lProductos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				cargaProducto();
			}
		});
		lProductos.setBackground(SystemColor.controlHighlight);
		lProductos.setBounds(281, 122, 460, 69);
		panel.add(lProductos);
		lProductos.setModel(jList);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(89, 145, 56, 16);
		panel.add(lblProductos);
		
		JLabel lblNewLabel = new JLabel("Personal");
		lblNewLabel.setBounds(89, 272, 56, 16);
		panel.add(lblNewLabel);
		
		cmbPersonal = new JComboBox();
		cmbPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargaPersonal();
			}
		});
		cmbPersonal.setBounds(281, 269, 460, 22);
		panel.add(cmbPersonal);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(89, 345, 56, 16);
		panel.add(lblNewLabel_1);
		
		cmbCliente = new JComboBox();
		cmbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCliente();
			}
		});
		cmbCliente.setBounds(281, 342, 460, 22);
		panel.add(cmbCliente);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(89, 416, 56, 16);
		panel.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(281, 413, 460, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(89, 485, 56, 16);
		panel.add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(281, 482, 460, 22);
		panel.add(textField_1);
		
		JButton btnAadirVenta = new JButton("A\u00F1adir Venta");
		btnAadirVenta.setBackground(SystemColor.textHighlight);
		btnAadirVenta.setBounds(203, 583, 388, 25);
		panel.add(btnAadirVenta);
		
		

	}
	
	/*public void cargaProducto() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while(registro.next()) {
				modelo.addElement(registro.getObject("nombreProducto"));
				lProductos.setModel(modelo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void cargaProducto() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while(registro.next()) {
				registro.toString();
				lProductos.add((Component) registro.getObject("nombreProducto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargaPersonal() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombre from personal");
			while(registro.next()) {
				cmbPersonal.addItem(registro.getObject("nombre"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargaCliente() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombre from cliente");
			while(registro.next()) {
				cmbCliente.addItem(registro.getObject("nombre"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
