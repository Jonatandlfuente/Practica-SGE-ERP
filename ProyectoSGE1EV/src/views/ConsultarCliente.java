package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
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

public class ConsultarCliente extends JPanel {
	private JTable tablaClientes;
	private JComboBox cmbClientes;
	private JScrollPane scrollPaneles, scrollPane;
	private JLabel lblConsultarCliente, lblCliente;
	private JButton button, button_1;
	//private PanelGeneralClientes pgCliente = new PanelGeneralClientes();

	/**
	 * Create the panel.
	 */
	public ConsultarCliente() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		lblConsultarCliente = new JLabel("Consultar Cliente");
		lblConsultarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarCliente.setBounds(628, 13, 133, 16);
		panel.add(lblConsultarCliente);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(150, 135, 60, 16);
		panel.add(lblCliente);
		
		cmbClientes = new JComboBox();
		cmbClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCliente();
			}
		});
		cmbClientes.setBounds(216, 132, 466, 22);
		panel.add(cmbClientes);
		
		button = new JButton("Consultar");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(334, 179, 170, 25);
		panel.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 257, 644, 347);
		panel.add(scrollPane);
		
		tablaClientes = new JTable();
		scrollPane.setViewportView(tablaClientes);
		
		button_1 = new JButton("< ATR\u00C1S");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgCliente);
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
	
	
	public void cargaCliente() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombre from cliente");
			while(registro.next()) {
				cmbClientes.addItem(registro.getObject("nombre"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void hacerInvisible() {
		tablaClientes.setVisible(false);
		cmbClientes.setVisible(false);
		scrollPaneles.setVisible(false);
		scrollPane.setVisible(false);
		lblConsultarCliente.setVisible(false);
		lblCliente.setVisible(false);
		button.setVisible(false);
		button_1.setVisible(false);
	}
}
