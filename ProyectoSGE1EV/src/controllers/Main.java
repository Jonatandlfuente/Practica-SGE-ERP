package controllers;

import java.util.Scanner;

import views.Login;

public class Main {

	/*
	 * cuando compres productos y el estado sea entregado cambiar el valor del stock
	 * de productos
	 */

	public static void main(String[] args) {

		BbddControllers controlador = new BbddControllers();
		FileControllers registro = new FileControllers();
		String user = "";
		String pass = "";
		
		Login vntLogin= new Login();
		//vntLogin.cargaVntLogin(vntLogin);

		// user = "pedroruizlamas";
		// pass = "3458897";
		boolean comprobacion = false;
		Scanner teclado = new Scanner(System.in);
		//registro.escribirFichero(user, pass);
//		do {
//			System.out.println("Escribir user: ");
//			user = teclado.nextLine();
//			System.out.println("Escribir pass: ");
//			pass = teclado.nextLine();
//			comprobacion = registro.leerFichero(user, pass);
//		} while (comprobacion != true);
//		controlador.escribirBBDDColor("azul");
//		controlador.escribirBBDDMarca("samsung", "galaxy S8", 1);
//		controlador.escribirBBDDProveedor("A80192727", "JuanXXIII", "C/Nueva nº3", 638058729, 638058728, "cole@juanxxii.net");
//		controlador.escribirBBDDProductos("GS8", "Galaxy S8 con 12gb de ram", 7, 1,5);
//		controlador.escribirBBDDClientes("jonatan", "de la fuente", "47465160Z", "madrid", 686426667, 686426668, "avda/de la caza nº19 2ºB", "jonatan.delafuente@juanxxiii.net");
//		controlador.escribirBBDDPersonal("gonzalo", "piñuela", "c/carretas nº19", 686426669, 686426670, "gonzalojopiñuela@gmail.com", "12-05-1986", "tecnico de ventas", "47462461A", "ES6600190020961234569997");
//		controlador.escribirBBDDCompras(2, "05-11-2020", "entregado", "06-11-2020", "06-11-2020", "00-00-0000",3000 , 5);
//		controlador.escribirBBDDFacturaCompras(1, 5, 500.4f, "07-11-2020");
//		controlador.escribirBBDDVentas(5, 2, 1, 120, "07-11-2020");
//		controlador.escribirBBDDFacturaVentas(1, 3, 140.0f, "07-11-2020");
//		controlador.escribirBBDDEscandallos("i5 8gb gforcegtx 660ti");
//		controlador.escribirBBDDColecciones(6, 8, 1);
//		controlador.escribirBBDDFabricacion(3, 2, 60.5f, 1);
		//controlador.updateBBDDColor(controlador.selectBbddIDColor("verde"),"rojo");
	}
}
