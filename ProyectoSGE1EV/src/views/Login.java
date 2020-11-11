package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.FileControllers;
import models.Identificador;

import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */

	public static void cargaVntLogin(Login frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {

		setTitle("Mushi ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 690);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel pLogin = new JPanel();
		pLogin.setBackground(SystemColor.textHighlight);
		contentPane.add(pLogin, "name_132265509906200");
		pLogin.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(
				new ImageIcon("img\\logo_preview_rev_1.png"));
		label.setBounds(403, 86, 200, 185);
		pLogin.add(label);

		txtUsername = new JTextField();
		txtUsername.setBounds(387, 317, 266, 33);
		pLogin.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(387, 367, 266, 33);
		pLogin.add(txtPassword);

		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean comprobacion = false;
				String user = "";
				String pass = "";
				Identificador identify;
				FileControllers registro = new FileControllers();
				comprobacion = false;
				user = txtUsername.getText();
				pass = txtPassword.getText();
				comprobacion = registro.leerFichero(user, pass);

				if (comprobacion != true) {
					txtUsername.setText("");
					txtPassword.setText("");
				} else {
					Principal principal = new Principal();
					principal.setVisible(true);
				}
			}
		});
		btnIniciarSesin.setBounds(429, 469, 182, 25);
		pLogin.add(btnIniciarSesin);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(312, 326, 46, 14);
		pLogin.add(lblNewLabel);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(312, 376, 46, 14);
		pLogin.add(lblPass);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(225, 232, 164, 33);
		pLogin.add(lblNewLabel_1);
	}

	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual, BorderLayout.SOUTH);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
