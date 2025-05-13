package main;

import java.util.Scanner;

import clases.Categorias;
import clases.Clientes;

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
				menuMantenimientos();

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;

			default:
				break;
			}
		} while (opcion > 5 || opcion <= 0);

	}

	public static void menuMantenimientos() {
		Scanner sc = new Scanner(System.in);
		int opcion2 = 0;
		do {
			opcion2 = util.Validarfunciones.dimeEntero(
					"1.1-.Gestion de categorias \n1.2-.Gestion de productos\n3-.Gestion de clientes\n4-.Salir\nIntroduce una opcion",
					sc);
			switch (opcion2) {
			case 1:
				String nombreCat = util.Validarfunciones.dimeString("Introduce un nombre para una nueva categoria", sc);
				Categorias catNueva = new Categorias(1, nombreCat);
				dao.CategoriasDao.inserta(catNueva);

				break;
			case 2:

				break;

			case 3:
				menuGestionClientes();
				break;

			default:
				break;
			}
		} while (opcion2 > 3 || opcion2 <= 0);
	}

	public static void menuGestionClientes() {
		Scanner sc = new Scanner(System.in);
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
				int codBusqueda=util.Validarfunciones.dimeEntero("Introduce el codigo por el que buscar al cliente", sc);
				Clientes cl= dao.ClientesDao.buscarXcodigo(codBusqueda);
			if (cl==null) {
				System.out.println("El cliente no existe");
				
			}else {
				System.out.println(cl);
				String nombreCliente2 = util.Validarfunciones.dimeString("Introduce el nombre para actualizar al cliente", sc);
				String direccionCliente2 = util.Validarfunciones.dimeString("Introduce la nueva direccion para actualizar al cliente", sc);
				int codigoCliente2 = util.Validarfunciones.dimeEntero("Introduce el codigo para actualizar al cliente", sc);
				Clientes c2 = new Clientes(cl.getIdCliente(), nombreCliente2, direccionCliente2, codigoCliente2);
				dao.ClientesDao.actualiza(c2);
				System.out.println(c2);
			}
			

				break;
			default:
				break;
			}

		} while (opcion3 > 2 || opcion3 <= 0);
	}

}
