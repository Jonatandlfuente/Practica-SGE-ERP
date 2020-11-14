package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

public class AnadirProveedor extends JPanel {
	private JTextField txtEmpresa, txtCIF, txtDireccion,txtTelf, txtTelf_1;
	private JComboBox jcbProveedores;
	private JLabel lblEmpresas, lblCIF, lblDireccion,lblNombre, lblTelfono, lblTelfono_1, lblNewLabel;
	private JButton button, btnAnadirProv;
	private JScrollPane scrollPaneles;
	//private PanelGeneralProv pgProv = new PanelGeneralProv();
	
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

		lblEmpresas = new JLabel("Empresa");
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

		lblCIF = new JLabel("CIF");
		lblCIF.setBounds(99, 171, 56, 16);
		panel.add(lblCIF);

		txtCIF = new JTextField();
		txtCIF.setBounds(294, 168, 350, 22);
		panel.add(txtCIF);
		txtCIF.setColumns(10);

		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(99, 273, 56, 16);
		panel.add(lblDireccion);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(99, 220, 56, 16);
		panel.add(lblNombre);

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

		btnAnadirProv = new JButton("A\u00F1adir Proveedor");
		btnAnadirProv.setBackground(SystemColor.textHighlight);
		btnAnadirProv.setBounds(183, 497, 388, 25);
		panel.add(btnAnadirProv);
		
		button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgProv);
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
	
	public void hacerInvisible() {
		scrollPaneles.setVisible(false);
		button.setVisible(false);
		btnAnadirProv.setVisible(false);
		lblNombre.setVisible(false);
		txtEmpresa.setVisible(false);
		txtCIF.setVisible(false);
		txtDireccion.setVisible(false);
		txtTelf.setVisible(false);
		txtTelf_1.setVisible(false);
		jcbProveedores.setVisible(false);
		lblEmpresas.setVisible(false);
		lblCIF.setVisible(false);
		lblDireccion.setVisible(false);
		lblNombre.setVisible(false);
		lblTelfono.setVisible(false);
		lblTelfono_1.setVisible(false);
		lblNewLabel.setVisible(false);
	}
}
