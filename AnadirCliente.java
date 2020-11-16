package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnadirCliente extends JPanel {
	private JTextField txtNombre, txtApellidos, txtDNI, txtProvincia, txtTelf, txtTelf_1, txtDireccion, txtEmail;
	private JScrollPane scrollPaneles;
	private JLabel lblCliente, lblNombre, lblApellidos, lblDni,lblProvincia, lblTelfono, lblTelfono_1, lblDireccin, lblEmail; 
	private JButton button, btnAadirCliente;
	private BbddControllers insertarCliente;
	//private PanelGeneralClientes pgCliente = new PanelGeneralClientes();

	/**
	 * Create the panel.
	 */
	public AnadirCliente() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		lblCliente = new JLabel("Clientes");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCliente.setBounds(682, 13, 79, 16);
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
		
		btnAadirCliente = new JButton("A\u00F1adir Cliente");
		btnAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=txtNombre.getText();
				String apellido=txtApellidos.getText();
				String dni=txtDNI.getText();
				String provincia=txtProvincia.getText();
				String telefonoS=txtTelf.getText();
				String telefono2S=txtTelf_1.getText();
				int telefono=0;
				int telefono2=0;
				String direccion=txtDireccion.getText();
				String email=txtEmail.getText();
				insertarCliente= new BbddControllers();
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
				insertarCliente = new BbddControllers();
				if (nombre != "" && apellido != "" && dni != "" &&  provincia !="" && telefono != 0 && telefono2 != 0 && direccion!="" && email != "") {
					insertarCliente.escribirBBDDClientes(nombre, apellido, dni, provincia, telefono, telefono2, direccion, email);	
					JOptionPane.showMessageDialog(null,
							"Cliente insertado con éxito!!", "Éxito en la insercción", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Has introducido algún campo vacio por favor complete todos los campos!!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				txtNombre.setText("");
				txtApellidos.setText("");
				txtDNI.setText("");
				txtProvincia.setText("");
				txtTelf.setText("");
				txtTelf_1.setText("");
				txtDireccion.setText("");
				txtEmail.setText("");
			}
		});
		btnAadirCliente.setBackground(SystemColor.textHighlight);
		btnAadirCliente.setBounds(187, 573, 388, 25);
		panel.add(btnAadirCliente);
		
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
	}

}
