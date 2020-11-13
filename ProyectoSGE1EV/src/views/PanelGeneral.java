package views;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;

public class PanelGeneral extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGeneral() {
		setLayout(null);
		JPanel f = new JPanel();
		f.setBounds(0, 0, 1054, 643);
		add(f);
		f.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.MAGENTA);
		f.add(panel, BorderLayout.EAST);
		
		JLabel label = new JLabel("\u00BFQU\u00C9 QUIERES HACER?");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(264, 45, 327, 39);
		panel.add(label);
		
		JLabel label_1 = new JLabel("A\u00F1adir");
		label_1.setBounds(219, 130, 56, 16);
		panel.add(label_1);
		
		JButton button = new JButton("");
		button.setBounds(143, 159, 191, 191);
		panel.add(button);
		
		JLabel label_2 = new JLabel("Modificar");
		label_2.setBounds(580, 130, 56, 16);
		panel.add(label_2);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(509, 159, 191, 191);
		panel.add(button_1);
		
		JLabel label_3 = new JLabel("Consultar");
		label_3.setBounds(209, 389, 56, 16);
		panel.add(label_3);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(143, 418, 191, 191);
		panel.add(button_2);
		
		JLabel label_4 = new JLabel("Borrar");
		label_4.setBounds(580, 389, 56, 16);
		panel.add(label_4);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(509, 418, 191, 191);
		panel.add(button_3);
		
		JLabel label_5 = new JLabel("*");
		label_5.setBounds(603, 61, 56, 16);
		panel.add(label_5);
		setVisible(true);

	}

}
