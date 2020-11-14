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
	private JScrollPane scrollPane, scrollPaneles;
	private JLabel lblConsultarProveedor, lblProveedor;
	private JButton button, button_1;
	//private PanelGeneralProv pgProv = new PanelGeneralProv();

	/**
	 * Create the panel.
	 */
	public ConsultarProveedor() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
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
		
		JButton button_2 = new JButton("< ATR\u00C1S");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgProv);
				hacerInvisible();
			}
		});
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(12, 11, 106, 25);
		panel.add(button_2);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		panel.add(scrollPaneles);

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
	
	public void hacerInvisible() {
		tablaProveedores.setVisible(false);
		cmbProveedor.setVisible(false);
		scrollPaneles.setVisible(false);
		scrollPane.setVisible(false);
		lblConsultarProveedor.setVisible(false);
		lblProveedor.setVisible(false);
		button.setVisible(false);
		button_1.setVisible(false);
	}
}
