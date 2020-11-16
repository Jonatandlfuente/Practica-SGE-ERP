package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileControllers {
	public void escribirFichero(String user, String pass) {
		File file = new File("access.txt");
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(user);
			fw.append(";");
			fw.write(pass);
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean leerFichero(String user, String pass) {
		boolean comprobacionUsuario = false;
		try {
			String ruta = "access.txt";
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] tokens = linea.split(";");
				if (user.compareToIgnoreCase(tokens[0]) == 0 && pass.compareToIgnoreCase(tokens[1]) == 0) {
					comprobacionUsuario = true;
				}
			}
			if (comprobacionUsuario) {
				JOptionPane.showMessageDialog(null,
						"Correct login!!!","Action successfully!!",JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"There is some empty field or try to enter a correct user and pass", "Warning",
						JOptionPane.WARNING_MESSAGE);
				/*JOptionPane.showMessageDialog(null,
						"There is some empty field or try to enter a correct user and pass", "Warning",
						JOptionPane.DEFAULT_OPTION);
				JOptionPane.showMessageDialog(null,
						"There is some empty field or try to enter a correct user and pass", "Warning",
						JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null,
						"There is some empty field or try to enter a correct user and pass", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null,
						"There is some empty field or try to enter a correct user and pass", "Warning",
						JOptionPane.QUESTION_MESSAGE);*/
			
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return comprobacionUsuario;
	}
}
