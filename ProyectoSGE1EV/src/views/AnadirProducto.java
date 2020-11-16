package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AnadirProducto extends JPanel {
	private JTextField txtDescripcion, txtStock;
	private JComboBox cmbMarca, cmbProveedor, cmbModelo, cmbColor;
	private JLabel lblProducto, lblNombre, lblMarca, lblDescripcin, lblStock;
	private JButton button, btnAadirProducto;
	private JScrollPane scrollPaneles;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JCheckBox chckbxSeleccionarModelo, chckbxSeleccionarMarca, chckbxSeleccionarColor,
			chckbxSeleccionarProveedor;
	// private PanelGeneralProd pgProd = new PanelGeneralProd();

	/**
	 * Create the panel.
	 */
	public AnadirProducto() {
		setLayout(null);

		JPanel pProducto = new JPanel();
		pProducto.setBackground(SystemColor.text);
		pProducto.setBounds(0, 0, 773, 643);
		add(pProducto);
		pProducto.setLayout(null);

		lblProducto = new JLabel("Productos");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProducto.setBounds(673, 13, 88, 16);
		pProducto.add(lblProducto);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(144, 133, 56, 16);
		pProducto.add(lblNombre);

		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(144, 171, 88, 16);
		pProducto.add(lblDescripcin);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(320, 168, 308, 22);
		pProducto.add(txtDescripcion);

		lblStock = new JLabel("Stock");
		lblStock.setBounds(144, 209, 56, 16);
		pProducto.add(lblStock);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(144, 285, 56, 16);
		pProducto.add(lblMarca);

		cmbMarca = new JComboBox();
		cmbMarca.setBounds(320, 247, 308, 22);
		pProducto.add(cmbMarca);
		cargaMarca(cmbMarca);

		cmbProveedor = new JComboBox();
		cmbProveedor.setBounds(320, 475, 308, 22);
		pProducto.add(cmbProveedor);
		cargaProveedor(cmbProveedor);

		cmbColor = new JComboBox();
		cmbColor.setBounds(320, 399, 308, 22);
		pProducto.add(cmbColor);
		cargacolor(cmbColor);

		cmbModelo = new JComboBox();
		cmbModelo.setBounds(320, 323, 308, 22);
		pProducto.add(cmbModelo);
		cargaModelo(cmbModelo);

		txtStock = new JTextField();
		txtStock.setBounds(320, 206, 308, 22);
		pProducto.add(txtStock);
		txtStock.setColumns(10);

		btnAadirProducto = new JButton("A\u00F1adir Producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreProducto;
				String descripcion;
				String stockS;
				int stock;
				String marcaS="";
				int id_marca;
				String modeloS="";
				int id_modelo;
				String colorS="";
				int id_color;
				String proveedorS="";
				int id_proveedor;
				BbddControllers insertarProducto = null;

				nombreProducto = txtNombre.getText();
				descripcion = txtDescripcion.getText();
				stockS = txtStock.getText();
				if (chckbxSeleccionarMarca.isSelected()) {
					marcaS = cmbMarca.getSelectedItem().toString();
				}
				if (chckbxSeleccionarModelo.isSelected()) {
					modeloS = cmbModelo.getSelectedItem().toString();
				}
				if (chckbxSeleccionarColor.isSelected()) {
					colorS = cmbColor.getSelectedItem().toString();
				}
				if (chckbxSeleccionarProveedor.isSelected()) {
					proveedorS = cmbProveedor.getSelectedItem().toString();
				}

				if (stockS.length() == 0) {
					stock=0;
				} else {
					try {
						stock = Integer.parseInt(stockS);
						insertarProducto = new BbddControllers();
						if (nombreProducto != "" && descripcion != "" && stock == 0) {
							if (chckbxSeleccionarProveedor.isSelected() && chckbxSeleccionarMarca.isSelected() && chckbxSeleccionarModelo.isSelected()&& chckbxSeleccionarColor.isSelected()) {
								BbddControllers conseguirIdMarca=new BbddControllers();
								id_marca=conseguirIdMarca.cargaIdMarca(marcaS);
								BbddControllers conseguirIdModelo=new BbddControllers();
								id_modelo=conseguirIdModelo.cargaIdModelo(modeloS); 
								BbddControllers conseguirIdColor=new BbddControllers();
								id_color=conseguirIdColor.cargaIdColor(colorS);
								BbddControllers conseguirIdProveedor =new BbddControllers();
								id_proveedor=conseguirIdProveedor.cargaIdProveedor(proveedorS);
								insertarProducto.escribirBBDDProductos(nombreProducto, descripcion, stock, id_marca, id_modelo, id_color, id_proveedor);
								
								JOptionPane.showMessageDialog(null, "Producto insertado con éxito!!", "Éxito en la insercción",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null,
										"por favor seleccione todos los campos!!", "Warning",
										JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Has introducido algún campo vacio por favor complete todos los campos!!", "Warning",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Has introducido letras en vez de números en el campo stock", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
		
				txtColor.setText("");
				txtDescripcion.setText("");
				txtMarca.setText("");
				txtModelo.setText("");
				txtNombre.setText("");
				txtStock.setText("");
				cmbColor.setSelectedIndex(0);
				cmbModelo.setSelectedIndex(0);
				cmbMarca.setSelectedIndex(0);
				cmbProveedor.setSelectedIndex(0);
				
			}
		});
		btnAadirProducto.setBackground(SystemColor.textHighlight);
		btnAadirProducto.setBounds(199, 539, 388, 25);
		pProducto.add(btnAadirProducto);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(144, 361, 46, 14);
		pProducto.add(lblModelo);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(144, 437, 46, 14);
		pProducto.add(lblColor);

		txtModelo = new JTextField();
		txtModelo.setBounds(320, 358, 308, 22);
		pProducto.add(txtModelo);
		txtModelo.setColumns(10);

		txtColor = new JTextField();
		txtColor.setBounds(320, 434, 308, 22);
		pProducto.add(txtColor);
		txtColor.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(320, 130, 308, 22);
		pProducto.add(txtNombre);

		chckbxSeleccionarMarca = new JCheckBox("Seleccionar Marca");
		chckbxSeleccionarMarca.setBounds(140, 247, 170, 23);
		pProducto.add(chckbxSeleccionarMarca);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(320, 282, 308, 22);
		pProducto.add(txtMarca);

		chckbxSeleccionarModelo = new JCheckBox("Seleccionar Modelo");
		chckbxSeleccionarModelo.setBounds(140, 323, 170, 23);
		pProducto.add(chckbxSeleccionarModelo);

		JCheckBox chckbxSeleccionarColor = new JCheckBox("Seleccionar Color");
		chckbxSeleccionarColor.setBounds(140, 399, 170, 23);
		pProducto.add(chckbxSeleccionarColor);

		JCheckBox chckbxSeleccionarProveedor = new JCheckBox("Seleccionar Proveedor");
		chckbxSeleccionarProveedor.setBounds(140, 475, 170, 23);
		pProducto.add(chckbxSeleccionarProveedor);

		JButton btnMarca = new JButton("Add");
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marcaS = txtMarca.getText();
				BbddControllers addMarca = new BbddControllers();
				if (marcaS.length() != 0) {
					addMarca.escribirBBDDMarca(marcaS);
					JOptionPane.showMessageDialog(null, "Marca insertada con éxito!!", "Éxito al insertar Marca",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido el campo vacio!!", "Fallo al insertar Marca",
							JOptionPane.WARNING_MESSAGE);
				}
				cmbMarca.removeAllItems();
				cargaMarca(cmbMarca);
				cmbMarca.setSelectedIndex(0);
				txtMarca.setText("");
			}
		});
		btnMarca.setBounds(650, 282, 89, 22);
		pProducto.add(btnMarca);

		JButton btnModelo = new JButton("Add");
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String modeloS = txtModelo.getText();
				BbddControllers addModelo = new BbddControllers();
				if (modeloS.length() != 0) {
					addModelo.escribirBBDDModelos(modeloS);
					JOptionPane.showMessageDialog(null, "Modelo insertada con éxito!!", "Éxito al insertar Modelo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido el campo vacio!!", "Fallo al insertar Modelo",
							JOptionPane.WARNING_MESSAGE);
				}
				cmbModelo.removeAllItems();
				cargaModelo(cmbModelo);
				cmbModelo.setSelectedIndex(0);
				txtModelo.setText("");
			}
		});
		btnModelo.setBounds(650, 357, 89, 22);
		pProducto.add(btnModelo);

		JButton btnColor = new JButton("Add");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String colorS = txtColor.getText();
				BbddControllers addColor = new BbddControllers();
				if (colorS.length() != 0) {
					addColor.escribirBBDDColor(colorS);
					JOptionPane.showMessageDialog(null, "Color insertado con éxito!!", "Éxito al insertar Color",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido el campo vacio!!", "Fallo al insertar Color",
							JOptionPane.WARNING_MESSAGE);
				}
				cmbColor.removeAllItems();
				cargacolor(cmbColor);
				cmbColor.setSelectedIndex(0);
				txtColor.setText("");

			}
		});
		btnColor.setBounds(650, 433, 89, 22);
		pProducto.add(btnColor);

		button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// scrollPaneles.setViewportView(pgProd);
				hacerInvisible();
			}
		});
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(12, 11, 106, 25);
		add(button);

		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		add(scrollPaneles);

	}

	public void cargaProducto(JComboBox cmbProducto) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while (registro.next()) {
				cmbProducto.addItem(registro.getObject("nombreProducto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargaMarca(JComboBox cmbMarca) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select marca from marca");
			while (registro.next()) {
				cmbMarca.addItem(registro.getObject("marca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargaProveedor(JComboBox cmbProveedor) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select empresa from proveedores");
			while (registro.next()) {
				cmbProveedor.addItem(registro.getObject("empresa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargaModelo(JComboBox cmbModelo) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreModelo from modelos");
			while (registro.next()) {
				cmbModelo.addItem(registro.getObject("nombreModelo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargacolor(JComboBox cmbColor) {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select color from color");
			while (registro.next()) {
				cmbColor.addItem(registro.getObject("color"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hacerInvisible() {
		scrollPaneles.setVisible(false);
		button.setVisible(false);
		btnAadirProducto.setVisible(false);
		txtDescripcion.setVisible(false);
		txtStock.setVisible(false);
		cmbMarca.setVisible(false);
		cmbProveedor.setVisible(false);
		lblProducto.setVisible(false);
		lblNombre.setVisible(false);
		lblMarca.setVisible(false);
		lblDescripcin.setVisible(false);
		lblStock.setVisible(false);

	}
}
