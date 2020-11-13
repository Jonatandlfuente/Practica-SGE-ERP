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

public class ConsultarCompras extends JPanel {
	private JTable tablaCompras;
	private JComboBox cmbCompra; 

	/**
	 * Create the panel.
	 */
	public ConsultarCompras() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultarCompra = new JLabel("Consultar Compra");
		lblConsultarCompra.setBounds(614, 13, 147, 22);
		lblConsultarCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblConsultarCompra);
		
		JLabel lblCompra = new JLabel("Compra:");
		lblCompra.setBounds(108, 138, 60, 16);
		panel.add(lblCompra);
		
		cmbCompra = new JComboBox();
		cmbCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCompra();
			}
		});
		cmbCompra.setBounds(172, 135, 466, 22);
		panel.add(cmbCompra);
		
		JButton button = new JButton("Consultar");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(288, 187, 170, 25);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 257, 644, 347);
		panel.add(scrollPane);
		
		tablaCompras = new JTable();
		scrollPane.setViewportView(tablaCompras);

	}
	
	public void cargaCompra() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_compra from compras");
			while(registro.next()) {
				cmbCompra.addItem(registro.getObject("id_compra"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
