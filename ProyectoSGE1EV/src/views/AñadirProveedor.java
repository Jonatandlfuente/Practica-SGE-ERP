package views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controllers.BbddControllers;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;

public class AñadirProveedor extends JPanel {
	private JTextField txtEmpresa;
	private JTextField txtCIF;
	private JTextField txtDireccion;
	private JTextField txtTelf;
	private JTextField txtTelf_1;
	private JComboBox jcbProveedores;
	/**
	 * Create the panel.
	 */
	public AñadirProveedor() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);

		JLabel lblEmpresas = new JLabel("Empresa");
		lblEmpresas.setBounds(99, 124, 56, 16);
		panel.add(lblEmpresas);

		jcbProveedores = new JComboBox();
		jcbProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaEmpresa();
			}
		});
		jcbProveedores.setBounds(294, 121, 350, 22);
		panel.add(jcbProveedores);

		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(294, 217, 350, 22);
		panel.add(txtEmpresa);
		txtEmpresa.setColumns(10);

		JLabel lblCIF = new JLabel("CIF");
		lblCIF.setBounds(99, 171, 56, 16);
		panel.add(lblCIF);

		txtCIF = new JTextField();
		txtCIF.setBounds(294, 168, 350, 22);
		panel.add(txtCIF);
		txtCIF.setColumns(10);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(99, 273, 56, 16);
		panel.add(lblDireccion);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(99, 220, 56, 16);
		panel.add(lblNombre);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(294, 270, 350, 22);
		panel.add(txtDireccion);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(99, 321, 56, 16);
		panel.add(lblTelfono);

		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(294, 318, 350, 22);
		panel.add(txtTelf);

		JLabel lblNewLabel = new JLabel("Proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(659, 13, 102, 16);
		panel.add(lblNewLabel);

		JLabel lblTelfono_1 = new JLabel("Tel\u00E9fono 2");
		lblTelfono_1.setBounds(99, 373, 68, 16);
		panel.add(lblTelfono_1);

		txtTelf_1 = new JTextField();
		txtTelf_1.setColumns(10);
		txtTelf_1.setBounds(294, 370, 350, 22);
		panel.add(txtTelf_1);

		JButton btnAñadirProv = new JButton("A\u00F1adir Proveedor");
		btnAñadirProv.setBackground(SystemColor.textHighlight);
		btnAñadirProv.setBounds(183, 497, 388, 25);
		panel.add(btnAñadirProv);

	}

	public void cargaEmpresa() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select empresa from proveedores");
			while(registro.next()) {
				jcbProveedores.addItem(registro.getObject("empresa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
