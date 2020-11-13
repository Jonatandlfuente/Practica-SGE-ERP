package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AñadirProducto extends JPanel {
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JComboBox cmbProducto, cmbMarca, cmbProveedor;

	/**
	 * Create the panel.
	 */
	public AñadirProducto() {
		setLayout(null);
		
		JPanel pProducto = new JPanel();
		pProducto.setBackground(SystemColor.text);
		pProducto.setBounds(282, 0, 773, 643);
		add(pProducto);
		pProducto.setLayout(null);
		
		JLabel lblProducto = new JLabel("Productos");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProducto.setBounds(673, 13, 88, 16);
		pProducto.add(lblProducto);
		
		JLabel lblNombreProd = new JLabel("Producto");
		lblNombreProd.setBounds(144, 106, 56, 16);
		pProducto.add(lblNombreProd);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(300, 155, 308, 22);
		pProducto.add(txtNombre);
		txtNombre.setColumns(10);
		
		cmbProducto = new JComboBox();
		cmbProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaProducto();
			}
		});
		cmbProducto.setBounds(300, 103, 308, 22);
		pProducto.add(cmbProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(144, 158, 56, 16);
		pProducto.add(lblNombre);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(144, 215, 88, 16);
		pProducto.add(lblDescripcin);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(300, 212, 308, 22);
		pProducto.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(144, 268, 56, 16);
		pProducto.add(lblStock);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(144, 324, 56, 16);
		pProducto.add(lblMarca);
		
		cmbMarca = new JComboBox();
		cmbMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaMarca();
			}
		});
		cmbMarca.setBounds(300, 321, 308, 22);
		pProducto.add(cmbMarca);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(144, 382, 88, 16);
		pProducto.add(lblProveedor);
		
		cmbProveedor = new JComboBox();
		cmbProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaEmpresa();
			}
		});
		cmbProveedor.setBounds(300, 379, 308, 22);
		pProducto.add(cmbProveedor);
		
		txtStock = new JTextField();
		txtStock.setBounds(300, 265, 308, 22);
		pProducto.add(txtStock);
		txtStock.setColumns(10);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir Producto");
		btnAadirProducto.setBackground(SystemColor.textHighlight);
		btnAadirProducto.setBounds(200, 532, 388, 25);
		pProducto.add(btnAadirProducto);

	}
	
	public void cargaProducto() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while(registro.next()) {
				cmbProducto.addItem(registro.getObject("nombreProducto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargaMarca() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select marca from marca");
			while(registro.next()) {
				cmbMarca.addItem(registro.getObject("marca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargaEmpresa() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select empresa from proveedores");
			while(registro.next()) {
				cmbProveedor.addItem(registro.getObject("empresa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
