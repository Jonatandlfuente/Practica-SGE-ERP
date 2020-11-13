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
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;

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
		this.setResizable(false);
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

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon("img\\logo_preview_rev_1.png"));
		lblLogo.setBounds(403, 86, 200, 185);
		pLogin.add(lblLogo);

		txtUsername = new JTextField();
		txtUsername.setBounds(387, 317, 266, 33);
		pLogin.add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				boolean comprobacion = false;
				String user = "";
				String pass = "";
				Identificador identify;
				FileControllers registro = new FileControllers();
				comprobacion = false;
				user = txtUsername.getText();
				pass = passwordField.getText();
				comprobacion = registro.leerFichero(user, pass);

				if (comprobacion != true) {
					txtUsername.setText("");
					passwordField.setText("");
				} else {
					Principal principal = new Principal();
					principal.setVisible(true);
					dispose();
				}
			}
		});
		btnIniciarSesin.setBounds(429, 469, 182, 25);
		pLogin.add(btnIniciarSesin);
		
		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("img\\usuario.png"));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(362, 317, 16, 37);
		pLogin.add(lblUser);
		
		JLabel lblPass = new JLabel("");
		lblPass.setIcon(new ImageIcon("img\\contrasena.png"));
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(357, 367, 32, 47);
		pLogin.add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(387, 374, 266, 36);
		pLogin.add(passwordField);
	}

	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual, BorderLayout.SOUTH);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
