package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BbddControllers {
	
	//Conexión BBDD
	public Connection conexionBbdd() {

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbo_erptelefonos", "admin",
				"admin");
		} catch (SQLException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Connection Failed!!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		return conexion;
	}
	
	// Insert Colores
	public void escribirBBDDColor(String color) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
				consulta.executeUpdate("insert into color(color) values('" + color + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Marcas
	public void escribirBBDDMarca(String marca, String modelo, int id_color) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate("insert into marca(marca,modelo,id_color) values('" + marca + "','" + modelo + "',"
					+ id_color + ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Productos
	public void escribirBBDDProductos(String nombreProducto, String descripcion, int stock, int id_marca,
			int id_proveedor) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate(
					"insert into productos(nombreProducto,descripcion,stock,id_marca,id_proveedor) values('"
							+ nombreProducto + "','" + descripcion + "'," + stock + "," + id_marca + "," + id_proveedor
							+ ")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Proveedores
	public void escribirBBDDProveedor(String CIF, String empresa, String direccion, int telefono, int telefono2,
			String email) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate(
					"insert into proveedores(CIF,empresa,direccion,telefono,telefono2,email) values('" + CIF + "','"
							+ empresa + "','" + direccion + "'," + telefono + "," + telefono2 + ",'" + email + "')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Insert Clientes
	public void escribirBBDDClientes(String nombre, String apellido, String dni, String provincia, int telefono,
			int telefono2, String direccion, String email) {
		try {
			Connection conexion= conexionBbdd();
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
	}

	// Insert Personal
	public void escribirBBDDPersonal(String nombre, String apellido, String direccion, int telefono, int telefono2,
			String email, String fechaNacimiento, String puesto, String dni, String numeroCuenta) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate(
					"insert into personal(nombre,apellido,direccion,telefono,telefono2,email,fecha_Nacimiento,puesto,dni,numero_cuenta) values('"
							+ nombre + "','" + apellido + "','" + direccion + "'," + telefono + "," + telefono2 + ",'"
							+ email + "','" + fechaNacimiento + "','" + puesto +"','"+dni+"','"+numeroCuenta+"')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Insert Compra
	
	public void escribirBBDDCompras(int id_personal, String fecha_solicitado, String estado, String fecha_entrega, String fecha_requerido,
			String fecha_anulado, float valor, int id_producto) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate(
					"insert into compras(id_personal,fecha_solicitado,estado,fecha_entrega,fecha_requerido,fecha_anulado,valor,id_producto) values("
							+ id_personal + ",'" + fecha_solicitado + "','" + estado + "','" + fecha_entrega + "','" + fecha_requerido + "','"
							+ fecha_anulado + "'," + valor + "," + id_producto +")");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Insert FacturaCompras
	
	public void escribirBBDDFacturaCompras(int id_compra, int num_productos, float precio, String fecha) {
		try {
			Connection conexion= conexionBbdd();
			if (conexion != null) {
				Statement consulta = conexion.createStatement();
			consulta.executeUpdate(
					"insert into factura_compras(id_compra,num_productos,precio,fecha) values("
							+ id_compra + "," + num_productos + "," + precio + ",'" + fecha +"')");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Insert Ventas
	
		public void escribirBBDDVentas(int id_producto, int id_personal , int id_cliente , float valor,String fecha) {
			try {
				Connection conexion= conexionBbdd();
				if (conexion != null) {
					Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into ventas(id_producto,id_personal ,id_cliente,valor,fecha) values("
								+ id_producto + "," + id_personal  + "," + id_cliente + "," +valor +",'" + fecha +"')");
				}
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Insert FacturaVentas
		
		public void escribirBBDDFacturaVentas(int id_venta , int num_productos, float precio, String fecha) {
			try {
				Connection conexion= conexionBbdd();
				if (conexion != null) {
					Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into factura_ventas(id_venta,num_productos,precio,fecha) values("
								+ id_venta + "," + num_productos + "," + precio + ",'" + fecha +"')");
				}
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Insert Escandallos
		
		public void escribirBBDDEscandallos(String nombreEscandallo) {
			try {
				Connection conexion= conexionBbdd();
				if (conexion != null) {
					Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into escandallos(nombreEscandallo) values('" + nombreEscandallo +"')");
				}
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Insert colecciones
		
		public void escribirBBDDColecciones(int idEscandallo ,int idProducto,int unidadesColecciones ) {
			try {
				Connection conexion= conexionBbdd();
				if (conexion != null) {
					Statement consulta = conexion.createStatement();
				consulta.executeUpdate(
						"insert into colecciones(idEscandallo,idProducto,unidadesColecciones) values("+idEscandallo+","+idProducto+","+unidadesColecciones+")");
				}
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				Connection conexion = conexionBbdd();
				Statement consulta = conexion.createStatement();
				int valor = consulta.executeUpdate("update modelos set CONSUMO=" + consumption + " where ID=" + id);
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Insert fabricación
		
			public void escribirBBDDFabricacion(int idEscandallo, int idPersonal  , float tiempoFabricacion,int unidadesFabricacion) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into fabricacion(idEscandallo,idPersonal,tiempoFabricacion,unidadesFabricacion) values("
									+ idEscandallo + "," + idPersonal   + "," + tiempoFabricacion + "," +unidadesFabricacion +")");
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Update Colores
			public void escribirBBDDColor(String color) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
						consulta.executeUpdate("insert into color(color) values('" + color + "')");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// Insert Marcas
			public void escribirBBDDMarca(String marca, String modelo, int id_color) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate("insert into marca(marca,modelo,id_color) values('" + marca + "','" + modelo + "',"
							+ id_color + ")");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// Insert Productos
			public void escribirBBDDProductos(String nombreProducto, String descripcion, int stock, int id_marca,
					int id_proveedor) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into productos(nombreProducto,descripcion,stock,id_marca,id_proveedor) values('"
									+ nombreProducto + "','" + descripcion + "'," + stock + "," + id_marca + "," + id_proveedor
									+ ")");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// Insert Proveedores
			public void escribirBBDDProveedor(String CIF, String empresa, String direccion, int telefono, int telefono2,
					String email) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into proveedores(CIF,empresa,direccion,telefono,telefono2,email) values('" + CIF + "','"
									+ empresa + "','" + direccion + "'," + telefono + "," + telefono2 + ",'" + email + "')");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// Insert Clientes
			public void escribirBBDDClientes(String nombre, String apellido, String dni, String provincia, int telefono,
					int telefono2, String direccion, String email) {
				try {
					Connection conexion= conexionBbdd();
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
			}

			// Insert Personal
			public void escribirBBDDPersonal(String nombre, String apellido, String direccion, int telefono, int telefono2,
					String email, String fechaNacimiento, String puesto, String dni, String numeroCuenta) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into personal(nombre,apellido,direccion,telefono,telefono2,email,fecha_Nacimiento,puesto,dni,numero_cuenta) values('"
									+ nombre + "','" + apellido + "','" + direccion + "'," + telefono + "," + telefono2 + ",'"
									+ email + "','" + fechaNacimiento + "','" + puesto +"','"+dni+"','"+numeroCuenta+"')");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//Insert Compra
			
			public void escribirBBDDCompras(int id_personal, String fecha_solicitado, String estado, String fecha_entrega, String fecha_requerido,
					String fecha_anulado, float valor, int id_producto) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into compras(id_personal,fecha_solicitado,estado,fecha_entrega,fecha_requerido,fecha_anulado,valor,id_producto) values("
									+ id_personal + ",'" + fecha_solicitado + "','" + estado + "','" + fecha_entrega + "','" + fecha_requerido + "','"
									+ fecha_anulado + "'," + valor + "," + id_producto +")");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//Insert FacturaCompras
			
			public void escribirBBDDFacturaCompras(int id_compra, int num_productos, float precio, String fecha) {
				try {
					Connection conexion= conexionBbdd();
					if (conexion != null) {
						Statement consulta = conexion.createStatement();
					consulta.executeUpdate(
							"insert into factura_compras(id_compra,num_productos,precio,fecha) values("
									+ id_compra + "," + num_productos + "," + precio + ",'" + fecha +"')");
					}
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			//Insert Ventas
			
				public void escribirBBDDVentas(int id_producto, int id_personal , int id_cliente , float valor,String fecha) {
					try {
						Connection conexion= conexionBbdd();
						if (conexion != null) {
							Statement consulta = conexion.createStatement();
						consulta.executeUpdate(
								"insert into ventas(id_producto,id_personal ,id_cliente,valor,fecha) values("
										+ id_producto + "," + id_personal  + "," + id_cliente + "," +valor +",'" + fecha +"')");
						}
						conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//Insert FacturaVentas
				
				public void escribirBBDDFacturaVentas(int id_venta , int num_productos, float precio, String fecha) {
					try {
						Connection conexion= conexionBbdd();
						if (conexion != null) {
							Statement consulta = conexion.createStatement();
						consulta.executeUpdate(
								"insert into factura_ventas(id_venta,num_productos,precio,fecha) values("
										+ id_venta + "," + num_productos + "," + precio + ",'" + fecha +"')");
						}
						conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//Insert Escandallos
				
				public void escribirBBDDEscandallos(String nombreEscandallo) {
					try {
						Connection conexion= conexionBbdd();
						if (conexion != null) {
							Statement consulta = conexion.createStatement();
						consulta.executeUpdate(
								"insert into escandallos(nombreEscandallo) values('" + nombreEscandallo +"')");
						}
						conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//Insert colecciones
				
				public void escribirBBDDColecciones(int idEscandallo ,int idProducto,int unidadesColecciones ) {
					try {
						Connection conexion= conexionBbdd();
						if (conexion != null) {
							Statement consulta = conexion.createStatement();
						consulta.executeUpdate(
								"insert into colecciones(idEscandallo,idProducto,unidadesColecciones) values("+idEscandallo+","+idProducto+","+unidadesColecciones+")");
						}
						conexion.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//Insert fabricación
				
					public void escribirBBDDFabricacion(int idEscandallo, int idPersonal  , float tiempoFabricacion,int unidadesFabricacion) {
						try {
							Connection conexion= conexionBbdd();
							if (conexion != null) {
								Statement consulta = conexion.createStatement();
							consulta.executeUpdate(
									"insert into fabricacion(idEscandallo,idPersonal,tiempoFabricacion,unidadesFabricacion) values("
											+ idEscandallo + "," + idPersonal   + "," + tiempoFabricacion + "," +unidadesFabricacion +")");
							}
							conexion.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
			
			
}
