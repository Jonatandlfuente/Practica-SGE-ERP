package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

public class ModificarVenta extends JPanel {

	private JList lProductos;
	private DefaultListModel modelo; 
	private JTextField textField, textField_1;
	private JComboBox cmbPersonal, cmbCliente, cmbVenta;
	private JButton button_1,  btnAadirVenta;
	private JLabel lblVentas, lblProductos, lblNewLabel, lblNewLabel_1, lblValor, lblFecha, lblIdVenta;
	private JScrollPane scrollPaneles;
	//private PanelGeneralVentas pgVenta = new PanelGeneralVentas();
	private DefaultListModel jList = new DefaultListModel();

	
	/**
	 * Create the panel.
	 */
	public ModificarVenta() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		lblVentas = new JLabel("Modificar Ventas");
		lblVentas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVentas.setBounds(623, 13, 138, 16);
		panel.add(lblVentas);
		
		lProductos = new JList();
		lProductos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				cargaProducto();
			}
		});
		lProductos.setBackground(SystemColor.controlHighlight);
		lProductos.setBounds(281, 173, 460, 69);
		panel.add(lProductos);
		lProductos.setModel(jList);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setBounds(89, 196, 56, 16);
		panel.add(lblProductos);
		
		lblNewLabel = new JLabel("Personal");
		lblNewLabel.setBounds(89, 272, 56, 16);
		panel.add(lblNewLabel);
		
		cmbPersonal = new JComboBox();
		cmbPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaPersonal();
			}
		});
		cmbPersonal.setBounds(281, 269, 460, 22);
		panel.add(cmbPersonal);
		
		lblNewLabel_1 = new JLabel("Cliente");
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
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(89, 416, 56, 16);
		panel.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(281, 413, 460, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(89, 485, 56, 16);
		panel.add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(281, 482, 460, 22);
		panel.add(textField_1);
		
		btnAadirVenta = new JButton("Modificar Venta");
		btnAadirVenta.setBackground(SystemColor.textHighlight);
		btnAadirVenta.setBounds(203, 583, 388, 25);
		panel.add(btnAadirVenta);
		
		lblIdVenta = new JLabel("Id_Venta");
		lblIdVenta.setBounds(89, 119, 56, 16);
		panel.add(lblIdVenta);
		
		cmbVenta = new JComboBox();
		cmbVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVenta();
			}
		});
		cmbVenta.setBounds(281, 116, 460, 22);
		panel.add(cmbVenta);
		
		button_1 = new JButton("< ATR\u00C1S");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgVenta);
				hacerInvisible();
			}
		});
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(12, 11, 106, 25);
		panel.add(button_1);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		panel.add(scrollPaneles);

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
	
	public void cargaVenta() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_venta from ventas");
			while(registro.next()) {
				cmbVenta.addItem(registro.getObject("id_venta"));
			}
		}catch(SQLException e) {
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
	
	public void hacerInvisible() {
		cmbVenta.setVisible(false);
		scrollPaneles.setVisible(false);
		button_1.setVisible(false);
		lProductos.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		cmbPersonal.setVisible(false);
		cmbCliente.setVisible(false);
		cmbVenta.setVisible(false);
		btnAadirVenta.setVisible(false);
		lblVentas.setVisible(false);
		lblProductos.setVisible(false);
		lblNewLabel.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblValor.setVisible(false);
		lblFecha.setVisible(false);
		lblIdVenta.setVisible(false);
		
	}

}
