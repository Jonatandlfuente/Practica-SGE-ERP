package views;

import javax.swing.JPanel;

import controllers.BbddControllers;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Borrar extends JPanel {

	private JComboBox cmbBProv, cmbBProd, cmbBCliente, cmbBCompra, cmbBVenta;
	/**
	 * Create the panel.
	 */
	public Borrar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(705, 13, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblBProd = new JLabel("Seleccione el producto que desea borrar");
		lblBProd.setBounds(277, 61, 238, 16);
		panel.add(lblBProd);
		
		cmbBProd = new JComboBox();
		cmbBProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaProducto();
			}
		});
		cmbBProd.setBounds(175, 90, 431, 22);
		panel.add(cmbBProd);
		
		JButton btnBorrarProducto = new JButton("Borrar Producto");
		btnBorrarProducto.setBackground(SystemColor.textHighlight);
		btnBorrarProducto.setBounds(300, 125, 170, 25);
		panel.add(btnBorrarProducto);
		
		JLabel lblBProv = new JLabel("Seleccione el proveedor que desea borrar");
		lblBProv.setBounds(277, 177, 254, 16);
		panel.add(lblBProv);
		
		cmbBProv = new JComboBox();
		cmbBProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaEmpresa();
			}
		});
		cmbBProv.setBounds(175, 206, 431, 22);
		panel.add(cmbBProv);
		
		JButton btnBorrarProveedor = new JButton("Borrar Proveedor");
		btnBorrarProveedor.setBackground(SystemColor.textHighlight);
		btnBorrarProveedor.setBounds(300, 241, 170, 25);
		panel.add(btnBorrarProveedor);
		
		JLabel lblBCliente = new JLabel("Seleccione el cliente que desea borrar");
		lblBCliente.setBounds(277, 290, 254, 16);
		panel.add(lblBCliente);
		
		cmbBCliente = new JComboBox();
		cmbBCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCliente();
			}
		});
		cmbBCliente.setBounds(175, 319, 431, 22);
		panel.add(cmbBCliente);
		
		JButton btnBorrarCliente = new JButton("Borrar Cliente");
		btnBorrarCliente.setBackground(SystemColor.textHighlight);
		btnBorrarCliente.setBounds(300, 354, 170, 25);
		panel.add(btnBorrarCliente);
		
		JLabel lblBVenta = new JLabel("Seleccione la venta que desea borrar");
		lblBVenta.setBounds(277, 411, 254, 16);
		panel.add(lblBVenta);
		
		cmbBVenta = new JComboBox();
		cmbBVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVenta();
			}
		});
		cmbBVenta.setBounds(175, 440, 431, 22);
		panel.add(cmbBVenta);
		
		JButton btnBorrarVenta = new JButton("Borrar Venta");
		btnBorrarVenta.setBackground(SystemColor.textHighlight);
		btnBorrarVenta.setBounds(300, 475, 170, 25);
		panel.add(btnBorrarVenta);
		
		JLabel lblBCompra = new JLabel("Seleccione la compra que desea borrar");
		lblBCompra.setBounds(277, 522, 254, 16);
		panel.add(lblBCompra);
		
		cmbBCompra = new JComboBox();
		cmbBCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCompra();
			}
		});
		cmbBCompra.setBounds(175, 551, 431, 22);
		panel.add(cmbBCompra);
		
		JButton btnBorrarCompra = new JButton("Borrar Compra");
		btnBorrarCompra.setBackground(SystemColor.textHighlight);
		btnBorrarCompra.setBounds(300, 586, 170, 25);
		panel.add(btnBorrarCompra);

	}
	
	public void cargaProducto() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while(registro.next()) {
				cmbBProd.addItem(registro.getObject("nombreProducto"));
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
				cmbBProv.addItem(registro.getObject("empresa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				cmbBCliente.addItem(registro.getObject("nombre"));
			}
		}catch(SQLException e) {
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
				cmbBVenta.addItem(registro.getObject("id_venta"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargaCompra() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_compra from compras");
			while(registro.next()) {
				cmbBCompra.addItem(registro.getObject("id_compra"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
