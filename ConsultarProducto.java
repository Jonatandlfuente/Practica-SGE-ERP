package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.BbddControllers;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ConsultarProducto extends JPanel {
	private JTable tablaPorductos;
	private JComboBox cmbProducto; 
	private JScrollPane scrollPane, scrollPaneles;
	private JLabel lblNewLabel, lblProducto;
	private JButton button, button_1;
	//private PanelGeneralProd pgProd = new PanelGeneralProd();

	/**
	 * Create the panel.
	 */
	public ConsultarProducto() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(601, 13, 160, 16);
		panel.add(lblNewLabel);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(128, 119, 56, 16);
		panel.add(lblProducto);
		
		cmbProducto = new JComboBox();
		cmbProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaProducto();
			}
		});
		cmbProducto.setBounds(204, 116, 466, 22);
		panel.add(cmbProducto);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(SystemColor.textHighlight);
		btnConsultar.setBounds(314, 161, 170, 25);
		panel.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 257, 644, 347);
		panel.add(scrollPane);
		
		tablaPorductos = new JTable();
		scrollPane.setViewportView(tablaPorductos);
		
		JButton button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgProd);
				hacerInvisible();
			}
		});
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(12, 11, 106, 25);
		panel.add(button);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		panel.add(scrollPaneles);

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
	
	public void hacerInvisible() {
		tablaPorductos.setVisible(false);
		cmbProducto.setVisible(false);
		scrollPaneles.setVisible(false);
		scrollPane.setVisible(false);
		lblNewLabel.setVisible(false);
		lblProducto.setVisible(false);
		button.setVisible(false);
		button_1.setVisible(false);
	}
}
