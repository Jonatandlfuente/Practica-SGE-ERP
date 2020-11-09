import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		label.setIcon(new ImageIcon("C:\\Users\\loren\\Desktop\\ASIGNATURAS\\SEGUNDO\\SGE\\T1\\logo_preview_rev_1.png"));
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
		
		JCheckBox chckbxRecurdame = new JCheckBox("Recu\u00E9rdame");
		chckbxRecurdame.setBackground(SystemColor.textHighlight);
		chckbxRecurdame.setBounds(540, 422, 113, 25);
		pLogin.add(chckbxRecurdame);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});
		btnIniciarSesin.setBounds(429, 469, 182, 25);
		pLogin.add(btnIniciarSesin);
	}
	
	public void nuevoPanel(JPanel panelActual) {
		contentPane.removeAll();
		contentPane.add(panelActual, BorderLayout.SOUTH);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
