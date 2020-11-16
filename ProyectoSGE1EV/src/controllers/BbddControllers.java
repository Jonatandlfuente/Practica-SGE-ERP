package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class BbddControllers {

	// Conexión BBDD
	public Connection conexionBbdd() {

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbo_erptelefonos", "admin", "admin");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection Failed!!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		return conexion;
	}

	// Insert Colores
	public void escribirBBDDColor(String color) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into color(color) values('" + color + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Modelos
	public void escribirBBDDModelos(String nombreModelo) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into modelos(nombreModelo) values('" + nombreModelo + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Marcas
	public void escribirBBDDMarca(String marca) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into marca(marca) values('" + marca + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Productos
	public void escribirBBDDProductos(String nombreProducto, String descripcion, int stock, int id_marca, int id_modelo,
			int id_color, int id_proveedor) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into productos(nombreProducto,descripcion,stock,id_marca,id_modelo,id_color,id_proveedor) values('"
								+ nombreProducto + "','" + descripcion + "'," + stock + "," + id_marca + "," + id_modelo
								+ "," + id_color + "," + id_proveedor + ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Proveedores
	public void escribirBBDDProveedor(String cif, String empresa, String direccion, int telefono, int telefono2,
			String email) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into proveedores(CIF,empresa,direccion,telefono,telefono2,email) values('" + cif + "','"
								+ empresa + "','" + direccion + "'," + telefono + "," + telefono2 + ",'" + email
								+ "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		String CIF=txtCIF.getText();
//		String empresa=txtEmpresa.getText();
//		String direccion=txtDireccion.getText();
//		int telefono=Integer.parseInt(txtTelf.getText());
//		int telefono2=Integer.parseInt(txtTelf_1.getText());
//		String email=txtEmail.getText();
//		BbddControllers insertarProveedor = new BbddControllers();
//		insertarProveedor.escribirBBDDProveedor(CIF, empresa, direccion, telefono, telefono2, email);
	}

	// Insert Clientes
	public void escribirBBDDClientes(String nombre, String apellido, String dni, String provincia, int telefono,
			int telefono2, String direccion, String email) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into cliente(nombre,apellido,dni,provincia,telefono,telefono2,direccion,email) values('"
								+ nombre + "','" + apellido + "','" + dni + "','" + provincia + "'," + telefono + ","
								+ telefono2 + ",'" + direccion + "','" + email + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		String nombre=txtNombre.getText();
//		String apellido=txtApellidos.getText();
//		String dni=txtDNI.getText();
//		String provincia=txtProvincia.getText();
//		int telefono=Integer.parseInt(txtTelf.getText());
//		int telefono2=Integer.parseInt(txtTelf_1.getText());
//		String direccion=txtDireccion.getText();
//		String email=txtEmail.getText();
//		BbddControllers insertarCliente= new BbddControllers();
//		insertarCliente.escribirBBDDClientes(nombre, apellido, dni, provincia, telefono, telefono2, direccion, email);
	}

	// Insert Personal
	public void escribirBBDDPersonal(String nombre, String apellido, String direccion, int telefono, int telefono2,
			String email, String fecha_Nacimiento, String puesto, String dni, String numero_cuenta) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into personal(nombre,apellido,direccion,telefono,telefono2,email,fecha_Nacimiento,puesto,dni,numero_cuenta) values('"
								+ nombre + "','" + apellido + "','" + direccion + "'," + telefono + "," + telefono2
								+ ",'" + email + "','" + fecha_Nacimiento + "','" + puesto + "','" + dni + "','"
								+ numero_cuenta + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Compra

	public void escribirBBDDCompras(int id_personal, String fecha_solicitado, String estado, String fecha_entrega,
			String fecha_requerido, String fecha_anulado, float valor, int id_producto) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into compras(id_personal,fecha_solicitado,estado,fecha_entrega,fecha_requerido,fecha_anulado,valor,id_producto) values("
								+ id_personal + ",'" + fecha_solicitado + "','" + estado + "','" + fecha_entrega + "','"
								+ fecha_requerido + "','" + fecha_anulado + "'," + valor + "," + id_producto + ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert FacturaCompras

	public void escribirBBDDFacturaCompras(int id_compra, int num_productos, float precio, String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into factura_compras(id_compra,num_productos,precio,fecha) values("
						+ id_compra + "," + num_productos + "," + precio + ",'" + fecha + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Ventas

	public void escribirBBDDVentas(int id_producto, int id_personal, int id_cliente, float valor, String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into ventas(id_producto,id_personal ,id_cliente,valor,fecha) values("
						+ id_producto + "," + id_personal + "," + id_cliente + "," + valor + ",'" + fecha + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert FacturaVentas

	public void escribirBBDDFacturaVentas(int id_venta, int num_productos, float precio, String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into factura_ventas(id_venta,num_productos,precio,fecha) values("
						+ id_venta + "," + num_productos + "," + precio + ",'" + fecha + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Escandallos

	public void escribirBBDDEscandallos(String nombreEscandallo) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into escandallos(nombreEscandallo) values('" + nombreEscandallo + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert colecciones

	public void escribirBBDDColecciones(int idEscandallo, int idProducto, int unidadesColecciones) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into colecciones(idEscandallo,idProducto,unidadesColecciones) values("
						+ idEscandallo + "," + idProducto + "," + unidadesColecciones + ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert fabricación

	public void escribirBBDDFabricacion(int idEscandallo, int idPersonal, float tiempoFabricacion,
			int unidadesFabricacion) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into fabricacion(idEscandallo,idPersonal,tiempoFabricacion,unidadesFabricacion) values("
								+ idEscandallo + "," + idPersonal + "," + tiempoFabricacion + "," + unidadesFabricacion
								+ ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	public String cargandoIdModeloconModelo(String modelo) {

		String id = "";
		try {
			Connection conexion = conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select ID from modelos where MODELO='" + modelo + "'");
			while (registro.next()) {
				id = (registro.getObject("ID").toString());
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// Select id_color

	public int selectBbddIDColor(String color) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id_color from color where color='" + color + "'");
			while (registro.next()) {
				id = (registro.getInt("id_color"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// Update Colores
	public void updateBBDDColor(int id_color, String color) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update color set color= '" + color + "' where id_color=" + id_color);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Marcas
	public void updateBBDDMarca(int id_marca, String marca) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update marca set marca='" + marca + "' where id_marca=" + id_marca);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Modelos
	public void updateBBDDModelos(int id_modelo, String nombreModelo) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"update modelos set nombreModelo='" + nombreModelo + "' where id_modelo=" + id_modelo);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Select Proveedores
	public int selectBBDDProveedor(String empresa) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				ResultSet registro = consulta
						.executeQuery("select id_proveedor from proveedores where empresa='" + empresa + "'");
				while (registro.next()) {
					id = (registro.getInt("id_proveedor"));
				}
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// Update Proveedores
	public void updateBBDDProveedor(int id_proveedor, String CIF, String empresa, String direccion, int telefono,
			int telefono2, String email) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update proveedores set CIF='" + CIF + "',empresa='" + empresa + "',direccion='"
						+ direccion + "',telefono=" + telefono + ",telefono2=" + telefono2 + ",email='" + email
						+ "' where id_proveedor=" + id_proveedor);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Productos
	public void updateBBDDProductos(int id_producto, String nombreProducto, String descripcion, int stock, int id_marca,
			int id_modelo, int id_color, int id_proveedor) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update productos set nombreProducto='" + nombreProducto + "',descripcion='"
						+ descripcion + "',stock=" + stock + ",id_marca=" + id_marca + ",id_modelo=" + id_modelo
						+ ",id_color=" + id_color + ",id_proveedor=" + id_proveedor + " where id_producto="
						+ id_producto);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Clientes
	public void updateBBDDClientes(int id_cliente, String nombre, String apellido, String dni, String provincia,
			int telefono, int telefono2, String direccion, String email) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update cliente set nombre='" + nombre + "',apellido='" + apellido + "',dni='"
						+ dni + "',provincia='" + provincia + "',telefono=" + telefono + ",telefono2=" + telefono2
						+ ",direccion='" + direccion + "',email='" + email + "' where id_cliente=" + id_cliente);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Personal
	public void updateBBDDPersonal(int id_personal, String nombre, String apellido, String direccion, int telefono,
			int telefono2, String email, String fecha_Nacimiento, String puesto, String dni, String numero_cuenta) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update personal set nombre='" + nombre + "',apellido='" + apellido
						+ "',direccion='" + direccion + "',telefono=" + telefono + ",telefono2=" + telefono2
						+ ",email='" + email + "',fecha_Nacimiento='" + fecha_Nacimiento + "',puesto='" + puesto
						+ "',dni='" + dni + "',numero_cuenta='" + numero_cuenta + "' where id_personal=" + id_personal);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Compras

	public void updateBBDDCompras(int id_compra, int id_personal, String fecha_solicitado, String estado,
			String fecha_entrega, String fecha_requerido, String fecha_anulado, float valor, int id_producto) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update compras set id_personal='" + id_personal + "',fecha_solicitado='"
						+ fecha_solicitado + "',estado='" + estado + "',fecha_entrega='" + fecha_entrega
						+ "',fecha_requerido='" + fecha_requerido + "',fecha_anulado='" + fecha_anulado + "',valor="
						+ valor + " where id_compra=" + id_compra);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update FacturaCompras

	public void updateBBDDFacturaCompras(int id_facturacompra, int id_compra, int num_productos, float precio,
			String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update factura_compras set id_compra=" + id_compra + ",num_productos="
						+ num_productos + ",precio=" + precio + ",fecha='" + fecha + "' where id_facturacompra="
						+ id_facturacompra);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Ventas

	public void updateBBDDVentas(int id_venta, int id_producto, int id_personal, int id_cliente, float valor,
			String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"update ventas set id_producto=" + id_producto + ",id_personal=" + id_personal + ",id_cliente="
								+ id_cliente + ",valor=" + valor + ",fecha='" + fecha + "' where id_venta=" + id_venta);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update FacturaVentas

	public void updateBBDDFacturaVentas(int id_facturaventas, int id_venta, int num_productos, float precio,
			String fecha) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update factura_ventas set id_venta=" + id_venta + ",num_productos="
						+ num_productos + ",precio=" + precio + ",fecha='" + fecha + "' where id_facturaventas="
						+ id_facturaventas);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Escandallos

	public void updateBBDDEscandallos(int id_escandallo, String nombreEscandallo) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update escandallos set nombreEscandallo='" + nombreEscandallo
						+ "' where id_escandallo=" + id_escandallo);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update colecciones

	public void updateBBDDColecciones(int idEscandallo, int idProducto, int unidadesColecciones) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update colecciones set unidadesColecciones=" + unidadesColecciones
						+ " where idEscandallo=" + idEscandallo + " AND idProducto=" + idProducto);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update fabricación

	public void updateBBDDFabricacion(int id_fabricacion, int idEscandallo, int idPersonal, float tiempoFabricacion,
			int unidadesFabricacion) {
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("update fabricacion set idEscandallo=" + idEscandallo + ",idPersonal="
						+ idPersonal + ",tiempoFabricacion=" + tiempoFabricacion + ",unidadesFabricacion="
						+ unidadesFabricacion + " where id_fabricacion=" + id_fabricacion);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



//----------------------------------------------------------------------------------------------------------------------------------------
	public int cargaIdColor(String color) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				ResultSet registro = consulta.executeQuery("select id_color from color where color='" + color + "'");
				while (registro.next()) {
					id = Integer.parseInt(registro.getObject("id_color").toString());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public int cargaIdModelo(String modelo) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				ResultSet registro = consulta.executeQuery("select id_modelo from color where nombreModelo='" + modelo + "'");
				while (registro.next()) {
					id = Integer.parseInt(registro.getObject("id_modelo").toString());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public int cargaIdMarca(String marca) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				ResultSet registro = consulta.executeQuery("select id_marca  from marca where marca='" + marca + "'");
				while (registro.next()) {
					id = Integer.parseInt(registro.getObject("id_marca").toString());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public int cargaIdProveedor(String empresa) {
		int id = 0;
		try {
			Connection conexion = conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				ResultSet registro = consulta.executeQuery("select id_proveedor from proveedores where empresa='" + empresa + "'");
				while (registro.next()) {
					id = Integer.parseInt(registro.getObject("id_proveedor").toString());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}