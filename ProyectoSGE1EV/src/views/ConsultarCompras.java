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
	private JScrollPane scrollPane, scrollPaneles;
	private JLabel lblConsultarCompra, lblCompra;
	private JButton button, button_1;
	//private PanelGeneralCompras pgCompra = new PanelGeneralCompras();

	/**
	 * Create the panel.
	 */
	public ConsultarCompras() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		lblConsultarCompra = new JLabel("Consultar Compra");
		lblConsultarCompra.setBounds(614, 13, 147, 22);
		lblConsultarCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblConsultarCompra);
		
		lblCompra = new JLabel("Compra:");
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 257, 644, 347);
		panel.add(scrollPane);
		
		tablaCompras = new JTable();
		scrollPane.setViewportView(tablaCompras);
		
		JButton button_1 = new JButton("< ATR\u00C1S");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgCompra);
				hacerInvisible();
			}
		});
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(12, 14, 106, 25);
		panel.add(button_1);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		panel.add(scrollPaneles);

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
	
	public void hacerInvisible() {
		tablaCompras.setVisible(false);
		cmbCompra.setVisible(false);
		scrollPaneles.setVisible(false);
		scrollPane.setVisible(false);
		lblConsultarCompra.setVisible(false);
		lblCompra.setVisible(false);
		button.setVisible(false);
		button_1.setVisible(false);
	}

}
