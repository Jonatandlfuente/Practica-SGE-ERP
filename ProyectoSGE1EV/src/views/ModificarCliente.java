package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ModificarCliente extends JPanel {
	private JTextField txtNombre, txtApellidos, txtDNI, txtProvincia, txtTelf, txtTelf_1, txtDireccion, txtEmail;
	private JScrollPane scrollPaneles;
	private JLabel lblCliente, lblNombre, lblApellidos, lblDni,lblProvincia, lblTelfono, lblTelfono_1, lblDireccin, lblEmail, lblClientecmb; 
	private JButton button, btnAadirCliente;
	//private PanelGeneralClientes pgCliente = new PanelGeneralClientes();
	private JComboBox cmbCliente;

	/**
	 * Create the panel.
	 */
	public ModificarCliente() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		lblCliente = new JLabel("Modificar Clientes");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCliente.setBounds(602, 13, 159, 16);
		panel.add(lblCliente);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(113, 116, 56, 16);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(251, 113, 388, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(113, 169, 56, 16);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(251, 166, 388, 22);
		panel.add(txtApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(113, 220, 56, 16);
		panel.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(251, 217, 388, 22);
		panel.add(txtDNI);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(113, 274, 56, 16);
		panel.add(lblProvincia);
		
		txtProvincia = new JTextField();
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(251, 271, 388, 22);
		panel.add(txtProvincia);
		
		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(113, 325, 56, 16);
		panel.add(lblTelfono);
		
		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(251, 322, 388, 22);
		panel.add(txtTelf);
		
		lblTelfono_1 = new JLabel("Tel\u00E9fono 2");
		lblTelfono_1.setBounds(113, 378, 73, 16);
		panel.add(lblTelfono_1);
		
		txtTelf_1 = new JTextField();
		txtTelf_1.setColumns(10);
		txtTelf_1.setBounds(251, 375, 388, 22);
		panel.add(txtTelf_1);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(113, 435, 73, 16);
		panel.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(251, 432, 388, 22);
		panel.add(txtDireccion);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(113, 488, 73, 16);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(251, 485, 388, 22);
		panel.add(txtEmail);
		
		btnAadirCliente = new JButton("Modificar Cliente");
		btnAadirCliente.setBackground(SystemColor.textHighlight);
		btnAadirCliente.setBounds(187, 573, 388, 25);
		panel.add(btnAadirCliente);
		
		lblClientecmb = new JLabel("Cliente");
		lblClientecmb.setBounds(113, 66, 56, 16);
		panel.add(lblClientecmb);
		
		cmbCliente = new JComboBox();
		cmbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCliente();
			}
		});
		cmbCliente.setBounds(251, 63, 388, 22);
		panel.add(cmbCliente);
		
		button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgCliente);
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
		scrollPaneles.setVisible(false);;
		button.setVisible(false);
		txtNombre.setVisible(false);
		txtApellidos.setVisible(false);
		txtDNI.setVisible(false);
		txtProvincia.setVisible(false);
		txtTelf.setVisible(false);
		txtTelf_1.setVisible(false);
		txtDireccion.setVisible(false);
		txtEmail.setVisible(false);
		lblCliente.setVisible(false);
		lblNombre.setVisible(false);
		lblApellidos.setVisible(false);
		lblDni.setVisible(false);
		lblProvincia.setVisible(false);
		lblTelfono.setVisible(false);
		lblTelfono_1.setVisible(false);
		lblDireccin.setVisible(false);
		lblEmail.setVisible(false);
		btnAadirCliente.setVisible(false);
		lblClientecmb.setVisible(false);
		cmbCliente.setVisible(false);
	}
}
