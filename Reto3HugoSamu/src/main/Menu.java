package main;

import clases.Categorias;
import clases.Clientes;
import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import util.Validarfunciones;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			opcion = util.Validarfunciones.dimeEntero(
					"1-.Mantenimientos \n2-.Catalogo de productos\n3-.Pedidos\n4-.Informes\n5-.Salir\nIntroduce una opcion",
					sc);
			switch (opcion) {
			case 1:
				menuMantenimientos(sc);

				break;
			case 2:
				menuCatalogoProductos(sc);

				break;
			case 3:
				menuPedidos(sc);

				break;
			case 4:
				menuInformes(sc);

				break;

			default:
				break;
			}
		} while (opcion != 5);

	}

	public static void menuInformes(Scanner sc) {
		int opcion4 = 0;
		do {
			opcion4 = util.Validarfunciones
					.dimeEntero("4.1-.Bajo Stock\n4.2-.Pedidos por cliente\n4.3-.Productos mas vendidos\n4-.Salir", sc);
			switch (opcion4) {
			case 1:
				mostrarProductosBajoStock();

				break;
			case 2:
				int codCliente = 0;
				do {

					codCliente = Validarfunciones.dimeEntero("Introduce un codigo de cliente", sc);

				} while (!verificarIdCliente(codCliente));
				Clientes clientePedido = dao.ClientesDao.buscarXcodigo(codCliente);
				List<Pedidos>listaXcliente=dao.PedidosDao.verPedidosCliente(clientePedido);
				if (listaXcliente.size()==0) {
					System.out.println("No hay pedidos para ese cliente");
					
				}
				for (Pedidos pedidos : listaXcliente) {
					System.out.println(pedidos);
				}

				break;
			case 3:

				break;
			default:
				break;
			}
		} while (opcion4 != 4);
	}

	public static void mostrarProductosBajoStock() {
		List<Productos> listaBajoStock = dao.ProductosDao.productosXstock();
		for (Productos productos : listaBajoStock) {
			System.out.println(productos);
		}
	}

	public static void menuCatalogoProductos(Scanner sc) {
		int opcion3 = 0;
		do {
			opcion3 = util.Validarfunciones
					.dimeEntero("2.1-.Listar productos por categoria\n2.2-.Buscar productos\n3-.Salir", sc);
			switch (opcion3) {
			case 1:
				mostrarCategorias();
				boolean salir = false;
				int categoriaElegida = 0;
				do {

					categoriaElegida = util.Validarfunciones.dimeEntero("Introduce una opcion", sc);
					/// verifico que existe la categoria y la devuelvo para insertar el produto en
					/// ella

					if (verificarCategoria(categoriaElegida) == null)
						salir = true;
					else
						salir = false;

				} while (salir);

				/// verifico que existe la categoria y la devuelvo para mostrar los productos
				/// filtrados por ella

				Categorias c = verificarCategoria(categoriaElegida);
				mostrarPorductosXcategoria(c);

				break;
			case 2:
				String nombreProductos = util.Validarfunciones.dimeString2("Introduce nombre de producto a buscar", sc);
				String color = util.Validarfunciones.dimeString2("Introduce el color que quieras", sc);
				String talla = util.Validarfunciones.dimeString2("Introduce la talla que quieras", sc);

				mostrarPorductosXBusqueda(nombreProductos, talla, color);

				break;
			default:
				break;
			}
		} while (opcion3 != 3);
	}

	public static void mostrarPorductosXcategoria(Categorias c) {
		List<Productos> listaXCategoria = dao.ProductosDao.listaProductosXcategoria(c);
		for (Productos productos : listaXCategoria) {
			System.out.println(productos.imprimir());
		}
	}

	public static List<Productos> mostrarPorductos() {
		List<Productos> lista = dao.ProductosDao.listaProductos();
		for (Productos productos : lista) {
			System.out.println(productos);
		}
		return lista;
	}

	public static void mostrarPorductosXBusqueda(String nombre, String talla, String color) {
		List<Productos> listaXBusqueda = dao.ProductosDao.buscarProducto(nombre, talla, color);
		for (Productos productos : listaXBusqueda) {
			System.out.println(productos);
		}
	}

	public static void menuPedidos(Scanner sc) {
		int opcion3 = 0;
		do {
			opcion3 = util.Validarfunciones.dimeEntero("3.1-.Crear pedido\n3.2-.Ver pedidos\n3-.Salir", sc);
			switch (opcion3) {
			case 1:
				/// boolean salir = false;
				///
				int codCliente = 0;
				do {

					codCliente = Validarfunciones.dimeEntero("Introduce un codigo de cliente", sc);

				} while (!verificarIdCliente(codCliente));
				Clientes clientePedido = dao.ClientesDao.buscarXcodigo(codCliente);
				System.out.println(clientePedido.getCodigo() + " " + clientePedido.getNombre());
				LocalDate hoy = LocalDate.now();
				Date fecha = util.Validarfunciones.convierte_LocalDate_a_Date(hoy);

				Pedidos ped = new Pedidos(0, clientePedido, 0, clientePedido.getDireccion(),
						(java.sql.Date) util.Validarfunciones.convierteFechaASQL(fecha));
				ped = dao.PedidosDao.crearPedido(ped, clientePedido);
				String nombreProducto = "";
				do {
					nombreProducto = util.Validarfunciones
							.dimeString2("Introduce un nombre de producto o No para terminar", sc);
					Productos p = dao.ProductosDao.buscarProductoXNombre(nombreProducto);
					List<Productos> listaproductos = dao.ProductosDao.listaProductos();
					System.out.println(p);
					for (Productos productos : listaproductos) {
						if (productos.getIdProducto() == p.getIdProducto()) {

							int unidadesProducto = util.Validarfunciones
									.dimeEntero("Introduce la cantidad de unidades del producto", sc);
							if (unidadesProducto > p.getStock()) {
								unidadesProducto = p.getStock();

							}
							PedidoProducto pP = new PedidoProducto(0, ped, p, unidadesProducto);
							dao.PedidoProductoDao.insertaProducto(productos, ped, pP);

						}

					}

					System.out.println(clientePedido.getDireccion() + ", ¿Quieres cambiar direccion? s/n");
					String cambioDirec = sc.nextLine();
					if (cambioDirec.equals("s")) {
						String direccionNueva = util.Validarfunciones.dimeString2("introduce la nueva direccion", sc);
						clientePedido.setDireccion(direccionNueva);

					}
					//System.out.println("EL pedido se ha guardado");
					break;
				} while (!nombreProducto.equals("No"));
				dao.PedidoProductoDao.actualizaprecio(ped);

				break;

			case 2:
			List<Pedidos>listaMes=	dao.PedidosDao.verPedidosMes();
			for (Pedidos pedidos : listaMes) {
				System.out.println(pedidos);
			}

				break;
			default:
				break;
			}
		} while (opcion3 != 3);
	}

	public static void menuMantenimientos(Scanner sc) {

		int opcion2 = 0;
		do {
			opcion2 = util.Validarfunciones.dimeEntero(
					"1.1-.Gestion de categorias \n1.2-.Gestion de productos\n1.3-.Gestion de clientes\n4-.Salir\nIntroduce una opcion",
					sc);
			switch (opcion2) {
			case 1:
				String nombreCat = util.Validarfunciones.dimeString("Introduce un nombre para una nueva categoria", sc);
				Categorias catNueva = new Categorias(1, nombreCat);
				dao.CategoriasDao.inserta(catNueva);

				break;
			case 2:

				String nombreProducto = util.Validarfunciones.dimeString("Introduce un nombre para el producto", sc);
				double precioProducto = util.Validarfunciones.dimeDouble("Introduce el precio del producto", sc);
				String descripcion = util.Validarfunciones.dimeString("Introduce una descripcion para el producto", sc);
				String colorProducto = util.Validarfunciones.dimeString("Introduce el color del producto", sc);
				String tallaProducto = util.Validarfunciones.dimeString("Introduce la talla del producto", sc);
				int stock = util.Validarfunciones.dimeEntero("Introduce la cantidad de stock", sc);

				mostrarCategorias();
				int categoriaElegida = 0;
				boolean salir = false;
				do {

					categoriaElegida = util.Validarfunciones.dimeEntero("Introduce una opcion", sc);
					/// verifico que existe la categoria y la devuelvo para insertar el produto en
					/// ella

					if (verificarCategoria(categoriaElegida) == null)
						salir = true;
					else
						salir = false;

				} while (salir);
				Categorias c = new Categorias(categoriaElegida);
				Productos p = new Productos(1, c, nombreProducto, precioProducto, descripcion, colorProducto,
						tallaProducto, stock);
				dao.ProductosDao.insertaProducto(p);
				break;

			case 3:
				menuGestionClientes(sc);
				break;

			default:
				break;
			}
		} while (opcion2 != 4);
	}

	public static boolean verificarIdCliente(int clienteCod) {

		List<Clientes> lista = dao.ClientesDao.lista();
		for (Clientes clientes : lista) {
			if (clientes.getCodigo() == clienteCod) {
				return true;

			}

		}
		return false;
	}

	public static Categorias verificarCategoria(int categoriaElegida) {
		Categorias catElegida = null;
		List<Categorias> lista = dao.CategoriasDao.lista();
		for (Categorias categorias : lista) {
			if (categorias.getIdCategoria() == categoriaElegida) {
				catElegida = categorias;
				break;
			}

		}
		return catElegida;
	}

	public static void mostrarCategorias() {
		List<Categorias> lista = dao.CategoriasDao.lista();
		for (Categorias categorias : lista) {
			System.out.println(categorias);
		}
	}

	public static void menuGestionClientes(Scanner sc) {

		int opcion3 = 0;
		do {
			opcion3 = util.Validarfunciones.dimeEntero("1-.Alta de nuevos clientes\n2-.Busqueda por codigo\n3-.Salir",
					sc);
			switch (opcion3) {
			case 1:
				String nombreCliente = util.Validarfunciones.dimeString("Introduce el nombre del nuevo cliente", sc);
				String direccionCliente = util.Validarfunciones.dimeString("Introduce la direccion", sc);
				int codigoCliente = util.Validarfunciones.dimeEntero("Introduce el codigo del cliente", sc);
				Clientes c = new Clientes(1, nombreCliente, direccionCliente, codigoCliente);
				dao.ClientesDao.inserta(c);
				break;
			case 2:
				int codBusqueda = util.Validarfunciones.dimeEntero("Introduce el codigo por el que buscar al cliente",
						sc);
				Clientes cl = dao.ClientesDao.buscarXcodigo(codBusqueda);

				if (cl == null) {
					System.out.println("El cliente no existe");

				} else {
					System.out.println(cl);
					String nombreCliente2 = util.Validarfunciones
							.dimeString("Introduce el nombre para actualizar al cliente", sc);
					String direccionCliente2 = util.Validarfunciones
							.dimeString("Introduce la nueva direccion para actualizar al cliente", sc);
					int codigoCliente2 = util.Validarfunciones
							.dimeEntero("Introduce el codigo para actualizar al cliente", sc);
					Clientes c2 = new Clientes(cl.getIdCliente(), nombreCliente2, direccionCliente2, codigoCliente2);
					dao.ClientesDao.actualiza(c2);
					System.out.println(c2);
				}

				break;
			default:
				break;
			}

		} while (opcion3 != 3);
	}

}
