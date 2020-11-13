package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import controllers.BbddControllers;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarProveedor extends JPanel {
	private JTable tablaProveedores;
	private JComboBox cmbProveedor; 

	/**
	 * Create the panel.
	 */
	public ConsultarProveedor() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultarProveedor = new JLabel("Consultar Proveedor");
		lblConsultarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarProveedor.setBounds(601, 13, 160, 16);
		panel.add(lblConsultarProveedor);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(128, 126, 69, 16);
		panel.add(lblProveedor);
		
		cmbProveedor = new JComboBox();
		cmbProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaEmpresa();
			}
		});
		cmbProveedor.setBounds(207, 123, 466, 22);
		panel.add(cmbProveedor);
		
		JButton button = new JButton("Consultar");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(317, 165, 170, 25);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 241, 644, 347);
		panel.add(scrollPane);
		
		tablaProveedores = new JTable();
		scrollPane.setViewportView(tablaProveedores);

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
