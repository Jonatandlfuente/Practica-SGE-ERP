package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGeneralProv extends JPanel {

	private JScrollPane scrollPaneles;
	private AnadirProveedor aProv = new AnadirProveedor();
	private ModificarProveedor mProv = new ModificarProveedor();
	private ConsultarProveedor cProv = new ConsultarProveedor();
	private Borrar borrar = new Borrar();
	private JButton btnAnadir, btnModificar, btnConsultar, btnBorrar; 
	private JLabel label, lblAnadir, lblModificar, lblConsultar, lblBorrar;
	
	/**
	 * Create the panel.
	 */
	public PanelGeneralProv() {
		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 773, 643);
		add(panel);
		panel.setLayout(null);
		
		label = new JLabel("\u00BFQU\u00C9 QUIERES HACER?");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(264, 45, 327, 39);
		panel.add(label);
		
		lblAnadir = new JLabel("A\u00F1adir");
		lblAnadir.setBounds(219, 130, 56, 16);
		panel.add(lblAnadir);
		
		btnAnadir = new JButton("");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneles.setViewportView(aProv);
				hacerInvisible();
			}
		});
		btnAnadir.setIcon(new ImageIcon("img\\iconoA\u00F1adir.png"));
		btnAnadir.setBounds(143, 159, 191, 191);
		panel.add(btnAnadir);
		
		lblModificar = new JLabel("Modificar");
		lblModificar.setBounds(580, 130, 56, 16);
		panel.add(lblModificar);
		
		btnModificar = new JButton("");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneles.setViewportView(mProv);
				hacerInvisible();
				
			}
		});
		btnModificar.setIcon(new ImageIcon("img\\iconoModificar.png"));
		btnModificar.setBounds(509, 159, 191, 191);
		panel.add(btnModificar);
		
		lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(209, 389, 56, 16);
		panel.add(lblConsultar);
		
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneles.setViewportView(cProv);
				hacerInvisible();
			}
		});
		btnConsultar.setIcon(new ImageIcon("img\\iconoConsultar.png"));
		btnConsultar.setBounds(143, 418, 191, 191);
		panel.add(btnConsultar);
		
		lblBorrar = new JLabel("Borrar");
		lblBorrar.setBounds(580, 389, 56, 16);
		panel.add(lblBorrar);
		
		btnBorrar = new JButton("");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneles.setViewportView(borrar);
				hacerInvisible();
			}
		});
		btnBorrar.setIcon(new ImageIcon("img\\iconoBorrar.png"));
		btnBorrar.setBounds(509, 418, 191, 191);
		panel.add(btnBorrar);
		
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 773, 643);
		panel.add(scrollPaneles);

	}
	
	public void hacerInvisible() {
		btnAnadir.setVisible(false);
		label.setVisible(false);
		lblAnadir.setVisible(false);
		lblModificar.setVisible(false);
		btnModificar.setVisible(false);
		lblConsultar.setVisible(false);
		btnConsultar.setVisible(false);
		lblBorrar.setVisible(false);
		btnBorrar.setVisible(false);
	}

}
