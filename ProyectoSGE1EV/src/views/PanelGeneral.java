package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelGeneral extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGeneral() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(282, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u00BFQU\u00C9 QUIERES HACER?");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(222, 45, 327, 39);
		panel.add(label);
		
		JLabel lblAnadir = new JLabel("A\u00F1adir");
		lblAnadir.setBounds(160, 153, 56, 16);
		panel.add(lblAnadir);
		
		JButton btnAnadir = new JButton("");
		btnAnadir.setIcon(new ImageIcon("C:\\Users\\loren\\git\\PracticaSGE\\ProyectoSGE1EV\\img\\iconoA\u00F1adir.png"));
		btnAnadir.setBounds(93, 182, 191, 191);
		panel.add(btnAnadir);
		
		JLabel lblModificar = new JLabel("Modificar");
		lblModificar.setBounds(516, 153, 56, 16);
		panel.add(lblModificar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon("C:\\Users\\loren\\git\\PracticaSGE\\ProyectoSGE1EV\\img\\iconoModificar.png"));
		btnModificar.setBounds(445, 182, 191, 191);
		panel.add(btnModificar);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(160, 408, 56, 16);
		panel.add(lblConsultar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\loren\\git\\PracticaSGE\\ProyectoSGE1EV\\img\\iconoConsultar.png"));
		btnConsultar.setBounds(93, 439, 191, 191);
		panel.add(btnConsultar);
		
		JLabel lblBorrar = new JLabel("Borrar");
		lblBorrar.setBounds(516, 408, 56, 16);
		panel.add(lblBorrar);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\loren\\git\\PracticaSGE\\ProyectoSGE1EV\\img\\iconoBorrar.png"));
		btnBorrar.setBounds(445, 439, 191, 191);
		panel.add(btnBorrar);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setBounds(603, 61, 56, 16);
		panel.add(lblNewLabel);

	}

}
