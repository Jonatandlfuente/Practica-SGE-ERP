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

public class ConsultarVentas extends JPanel {
	private JTable tablaVentas;
	private JComboBox cmbVenta; 

	/**
	 * Create the panel.
	 */
	public ConsultarVentas() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultarVenta = new JLabel("Consultar Venta");
		lblConsultarVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarVenta.setBounds(628, 13, 133, 16);
		panel.add(lblConsultarVenta);
		
		JLabel lblVenta = new JLabel("Venta:");
		lblVenta.setBounds(125, 132, 60, 16);
		panel.add(lblVenta);
		
		cmbVenta = new JComboBox();
		cmbVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaVenta();
			}
		});
		cmbVenta.setBounds(197, 129, 466, 22);
		panel.add(cmbVenta);
		
		JButton button = new JButton("Consultar");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(308, 179, 170, 25);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 255, 644, 347);
		panel.add(scrollPane);
		
		tablaVentas = new JTable();
		scrollPane.setViewportView(tablaVentas);

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

}
