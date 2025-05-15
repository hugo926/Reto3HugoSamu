package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import clases.Categorias;
import clases.Clientes;
import clases.Productos;

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
		} while (opcion > 5 || opcion <= 0);

	}

	public static void menuInformes(Scanner sc) {
		int opcion4 = 0;
		do {
			opcion4 = util.Validarfunciones
					.dimeEntero("4.1-.Bajo Stock\n4.2-.Pedidos por cliente\n4.3-.Productos mas vendidos\n4-.Salir", sc);
			switch (opcion4) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			default:
				break;
			}
		} while (opcion4 > 4 || opcion4 <= 0 );
	}

	public static void menuCatalogoProductos(Scanner sc) {
		int opcion3 = 0;
		do {
			opcion3 = util.Validarfunciones.dimeEntero("2.1-.Listar productos por categoria\n2.2-.Buscar productos\n3-.Salir",
					sc);
			switch (opcion3) {
			case 1:
				mostrarCategorias();
				int categoriaElegida = util.Validarfunciones.dimeEntero("Introduce una opcion", sc);
				/// verifico que existe la categoria y la devuelvo para mostrar los productos
				/// filtrados por ella

				Categorias c = verificarCategoria(categoriaElegida);
				mostrarPorductosXcategoria(c);

				break;
			case 2:

				break;
			default:
				break;
			}
		} while (opcion3 > 3 || opcion3 <= 0);
	}

	public static void mostrarPorductosXcategoria(Categorias c) {
		List<Productos> listaXCategoria = dao.ProductosDao.listaProductosXcategoria(c);
		for (Productos productos : listaXCategoria) {
			System.out.println(productos);
		}
	}

	public static void menuPedidos(Scanner sc) {
		int opcion3 = 0;
		do {
			opcion3 = util.Validarfunciones.dimeEntero("3.1-.Crear pedido\n3.2-.Ver pedidos\n3-.Salir", sc);
			switch (opcion3) {
			case 1:

				break;
			case 2:

				break;
			default:
				break;
			}
		} while (opcion3 >3 || opcion3 <= 0 );
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

				int categoriaElegida = util.Validarfunciones.dimeEntero("Introduce una opcion", sc);
				/// verifico que existe la categoria y la devuelvo para insertar el produto en
				/// ella

				Categorias c = verificarCategoria(categoriaElegida);
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
		} while (opcion2 > 3 || opcion2 <= 0 );
	}

	public static Categorias verificarCategoria(int categoriaElegida) {
		Categorias catElegida = null;
		List<Categorias> lista = dao.CategoriasDao.lista();
		for (Categorias categorias : lista) {
			if (categorias.getIdCategoria() == categoriaElegida) {
				catElegida = categorias;

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
				System.out.println(dao.ClientesDao.buscarXcodigo(codBusqueda));
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

		} while (opcion3 > 3 || opcion3 <= 0 );
	}

}
