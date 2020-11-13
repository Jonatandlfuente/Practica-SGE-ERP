package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controllers.BbddControllers;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ModificarCompra extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox cmbComprasid; 

	/**
	 * Create the panel.
	 */
	public ModificarCompra() {
		setLayout(null);
		
		JPanel pCompra = new JPanel();
		pCompra.setBackground(SystemColor.text);
		pCompra.setBounds(282, 0, 772, 643);
		add(pCompra);
		pCompra.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificar Compras");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(604, 13, 156, 16);
		pCompra.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personal");
		lblNewLabel_1.setBounds(142, 130, 56, 16);
		pCompra.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(291, 127, 409, 22);
		pCompra.add(comboBox);
		
		JLabel lblFechaSolicitado = new JLabel("Fecha solicitado");
		lblFechaSolicitado.setBounds(142, 184, 91, 16);
		pCompra.add(lblFechaSolicitado);
		
		textField = new JTextField();
		textField.setBounds(291, 181, 409, 22);
		pCompra.add(textField);
		textField.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(142, 231, 91, 16);
		pCompra.add(lblEstado);
		
		textField_1 = new JTextField();
		textField_1.setBounds(291, 228, 409, 22);
		pCompra.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaEntrega = new JLabel("Fecha entrega");
		lblFechaEntrega.setBounds(142, 276, 91, 16);
		pCompra.add(lblFechaEntrega);
		
		JLabel lblFechaRequerido = new JLabel("Fecha requerido");
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
		
		JLabel lblFechaAnulado = new JLabel("Fecha anulado");
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
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(142, 408, 91, 16);
		pCompra.add(lblValor);
		
		JLabel label = new JLabel("Productos");
		label.setBounds(142, 453, 56, 16);
		pCompra.add(label);
		
		JButton btnAadirCompra = new JButton("A\u00F1adir Compra");
		btnAadirCompra.setBackground(SystemColor.textHighlight);
		btnAadirCompra.setBounds(216, 605, 388, 25);
		pCompra.add(btnAadirCompra);
		
		JLabel lblIdCompra = new JLabel("Id_Compra");
		lblIdCompra.setBounds(142, 83, 73, 16);
		pCompra.add(lblIdCompra);
		
		cmbComprasid = new JComboBox();
		cmbComprasid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaCompra();
			}
		});
		cmbComprasid.setBounds(291, 80, 409, 22);
		pCompra.add(cmbComprasid);

	}
	
	public void cargaCompra() {
		BbddControllers bbdd = new BbddControllers();
		try {
			Connection conexion = bbdd.conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_compra from compras");
			while(registro.next()) {
				cmbComprasid.addItem(registro.getObject("id_compra"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
