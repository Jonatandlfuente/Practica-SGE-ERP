package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AnadirCompra extends JPanel {
	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5;
	private JComboBox cmbPersonal;
	private JScrollPane scrollPaneles;
	private JList list; 
	private JLabel lblNewLabel, lblNewLabel_1, lblFechaSolicitado, lblEstado, lblFechaEntrega, lblFechaRequerido, lblFechaAnulado, lblValor, label;
	private JButton btnAadirCompra, button;
	private DefaultListModel jList = new DefaultListModel();
	//private PanelGeneralCompras pgCompra = new PanelGeneralCompras();

	/**
	 * Create the panel.
	 */
	public AnadirCompra() {
		setLayout(null);
		
		JPanel pCompra = new JPanel();
		pCompra.setBackground(SystemColor.text);
		pCompra.setBounds(0, 0, 772, 643);
		add(pCompra);
		pCompra.setLayout(null);
		
		lblNewLabel = new JLabel("Compras");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(684, 13, 76, 16);
		pCompra.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Personal");
		lblNewLabel_1.setBounds(142, 130, 56, 16);
		pCompra.add(lblNewLabel_1);
		
		cmbPersonal = new JComboBox();
		cmbPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargaPersonal();
			}
		});
		cmbPersonal.setBounds(291, 127, 409, 22);
		pCompra.add(cmbPersonal);
		
		lblFechaSolicitado = new JLabel("Fecha solicitado");
		lblFechaSolicitado.setBounds(142, 184, 91, 16);
		pCompra.add(lblFechaSolicitado);
		
		textField = new JTextField();
		textField.setBounds(291, 181, 409, 22);
		pCompra.add(textField);
		textField.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(142, 231, 91, 16);
		pCompra.add(lblEstado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(291, 228, 409, 22);
		pCompra.add(textField_1);
		textField_1.setColumns(10);
		
		lblFechaEntrega = new JLabel("Fecha entrega");
		lblFechaEntrega.setBounds(142, 276, 91, 16);
		pCompra.add(lblFechaEntrega);
		
		lblFechaRequerido = new JLabel("Fecha requerido");
		lblFechaRequerido.setBounds(142, 318, 108, 16);
		pCompra.add(lblFechaRequerido);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(291, 273, 409, 22);
		pCompra.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(291, 315, 409, 22);
		pCompra.add(textField_3);
		
		lblFechaAnulado = new JLabel("Fecha anulado");
		lblFechaAnulado.setBounds(142, 364, 91, 16);
		pCompra.add(lblFechaAnulado);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(291, 361, 409, 22);
		pCompra.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(291, 405, 409, 22);
		pCompra.add(textField_5);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(142, 408, 91, 16);
		pCompra.add(lblValor);
		
		label = new JLabel("Productos");
		label.setBounds(142, 453, 56, 16);
		pCompra.add(label);
		
		btnAadirCompra = new JButton("A\u00F1adir Compra");
		btnAadirCompra.setBackground(SystemColor.textHighlight);
		btnAadirCompra.setBounds(216, 605, 388, 25);
		pCompra.add(btnAadirCompra);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				cargaProducto();
			}
		});
		list.setBackground(SystemColor.controlHighlight);
		list.setBounds(291, 452, 409, 84);
		pCompra.add(list);
		list.setModel(jList);
		
		button = new JButton("< ATR\u00C1S");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//scrollPaneles.setViewportView(pgCompra);
				hacerInvisible();
			}
		});
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(12, 11, 106, 25);
		pCompra.add(button);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		add(scrollPaneles);

	}
	
	public void cargaPersonal() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombre from personal");
			while(registro.next()) {
				cmbPersonal.addItem(registro.getObject("nombre"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cargaProducto() {
		BbddControllers conection = new BbddControllers();
		try {
			Connection conexion = conection.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombreProducto from productos");
			while(registro.next()) {
				registro.toString();
				list.add((Component) registro.getObject("nombreProducto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void hacerInvisible() {
		scrollPaneles.setVisible(false);;
		button.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		textField_4.setVisible(false);
		textField_5.setVisible(false);
		cmbPersonal.setVisible(false);
		list.setVisible(false);
		lblNewLabel.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblFechaSolicitado.setVisible(false);
		lblEstado.setVisible(false);
		lblFechaEntrega.setVisible(false);
		lblFechaRequerido.setVisible(false);
		lblFechaAnulado.setVisible(false);
		lblValor.setVisible(false);
		label.setVisible(false);
		btnAadirCompra.setVisible(false);
		
	}
}
