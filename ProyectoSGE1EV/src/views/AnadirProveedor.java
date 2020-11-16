package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JCheckBox;

public class AnadirProveedor extends JPanel {
	private JTextField txtEmpresa, txtCIF, txtDireccion, txtTelf, txtTelf_1, txtEmail;
	private JComboBox jcbProveedor = null;
	private JLabel lblEmpresas, lblCIF, lblDireccion, lblTelfono, lblTelfono_1, lblNewLabel, lblEmail;
	private JButton button, btnAnadirProv;
	private JScrollPane scrollPaneles;
	private JCheckBox chckbxEmpresa;
	// private PanelGeneralProv pgProv = new PanelGeneralProv();

	/**
	 * Create the panel.
	 */
	public AnadirProveedor() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);

		jcbProveedor = new JComboBox();
		jcbProveedor.setBounds(294, 168, 350, 22);
		panel.add(jcbProveedor);
		cargaEmpresa(jcbProveedor);

		chckbxEmpresa = new JCheckBox("Seleccionar Empresa");
		chckbxEmpresa.setBounds(94, 166, 174, 26);
		panel.add(chckbxEmpresa);

		lblEmpresas = new JLabel("Empresa");
		lblEmpresas.setBounds(99, 220, 56, 16);
		panel.add(lblEmpresas);

		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(294, 217, 350, 22);
		panel.add(txtEmpresa);
		txtEmpresa.setColumns(10);

		lblCIF = new JLabel("CIF");
		lblCIF.setBounds(99, 122, 56, 16);
		panel.add(lblCIF);

		txtCIF = new JTextField();
		txtCIF.setBounds(294, 119, 350, 22);
		panel.add(txtCIF);
		txtCIF.setColumns(10);

		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(99, 273, 56, 16);
		panel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(294, 270, 350, 22);
		panel.add(txtDireccion);

		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(99, 321, 56, 16);
		panel.add(lblTelfono);

		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(294, 318, 350, 22);
		panel.add(txtTelf);

		lblNewLabel = new JLabel("Proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(659, 13, 102, 16);
		panel.add(lblNewLabel);

		lblTelfono_1 = new JLabel("Tel\u00E9fono 2");
		lblTelfono_1.setBounds(99, 373, 68, 16);
		panel.add(lblTelfono_1);

		txtTelf_1 = new JTextField();
		txtTelf_1.setColumns(10);
		txtTelf_1.setBounds(294, 370, 350, 22);
		panel.add(txtTelf_1);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(99, 422, 68, 16);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(294, 422, 350, 22);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		btnAnadirProv = new JButton("A\u00F1adir Proveedor");
		btnAnadirProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String empresa = "";
				String cif = "";
				String direccion = "";
				String telefonoS = "";
				String telefono2S = "";
				int telefono = 0;
				int telefono2 = 0;
				String email = "";
				BbddControllers insertarProveedor = null;
				if (chckbxEmpresa.isSelected()) {
					empresa = jcbProveedor.getSelectedItem().toString();
				} else {
					empresa = txtEmpresa.getText();
				}
				cif = txtCIF.getText();
				direccion = txtDireccion.getText();
				telefonoS = txtTelf.getText();
				telefono2S = txtTelf_1.getText();
				email = txtEmail.getText();
				if (telefonoS.length() == 0 || telefono2S.length() == 0) {
					telefono = 0;
					telefono2 = 0;
				} else {
					try {
						telefono = Integer.parseInt(telefonoS);
						telefono2 = Integer.parseInt(telefono2S);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Has introducido letras en vez de números en el campo telefonos", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				insertarProveedor = new BbddControllers();
				if (cif != "" && direccion != "" && telefono != 0 && telefono2 != 0 && email != "") {
					if (chckbxEmpresa.isSelected() || empresa.length() != 0) {
						insertarProveedor.escribirBBDDProveedor(cif, empresa, direccion, telefono, telefono2, email);
						JOptionPane.showMessageDialog(null,
								"Proveedor insertado con éxito!!", "Éxito en la insercción", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Has introducido algún campo vacio por favor complete todos los campos!!", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Has introducido algún campo vacio por favor complete todos los campos!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				System.out.println("el nombre de la empresa es: " + empresa + " CIF: " + cif + " dirección: "
						+ direccion + " telefono1: " + telefono + "telefono2: " + telefono2 + "email: " + email);

				jcbProveedor.setSelectedIndex(0);
				txtEmpresa.setText("");
				txtCIF.setText("");
				txtDireccion.setText("");
				txtTelf.setText("");
				txtTelf_1.setText("");
				txtEmail.setText("");
			}
		});
		btnAnadirProv.setBackground(SystemColor.textHighlight);
		btnAnadirProv.setBounds(183, 497, 388, 25);
		panel.add(btnAnadirProv);

		button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// scrollPaneles.setViewportView(pgProv);
				AnadirProveedor nuevoProvedor = new AnadirProveedor();
				hacerInvisible();
			}
		});
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(12, 11, 106, 25);
		panel.add(button);

		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 832, 643);
		panel.add(scrollPaneles);

	}

	public void cargaEmpresa(JComboBox jcbProveedores) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select empresa from proveedores");
			while (registro.next()) {
				jcbProveedores.addItem(registro.getObject("empresa"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void hacerInvisible() {
		scrollPaneles.setVisible(false);
		button.setVisible(false);
		btnAnadirProv.setVisible(false);
		txtEmpresa.setVisible(false);
		txtCIF.setVisible(false);
		txtDireccion.setVisible(false);
		txtTelf.setVisible(false);
		txtTelf_1.setVisible(false);
		txtEmail.setVisible(false);
		jcbProveedor.setVisible(false);
		lblEmpresas.setVisible(false);
		lblCIF.setVisible(false);
		lblDireccion.setVisible(false);
		lblTelfono.setVisible(false);
		lblTelfono_1.setVisible(false);
		lblNewLabel.setVisible(false);
		lblEmail.setVisible(false);
		chckbxEmpresa.setVisible(false);
	}
}
