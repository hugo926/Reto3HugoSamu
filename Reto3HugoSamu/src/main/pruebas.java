package main;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import clases.Clientes;
import clases.Pedidos;
import clases.Productos;
import dao.PedidosDao;
import util.Validarfunciones;

public class pruebas {

	public static void main(String[] args) {
		
		Productos p = dao.ProductosDao.buscarProductoXNombre("Jogger gris");
		System.out.println(p);
		
		
		/*LocalDate hoy =LocalDate.now();
		Date fecha =   Validarfunciones.convierte_LocalDate_a_Date(hoy);

		Clientes c= new Clientes(2,"hjose","wf3fv3v",34);
		Pedidos pedido = new Pedidos(0, c, 43, "madrid",(java.sql.Date) Validarfunciones.convierteFechaASQL(fecha));
		PedidosDao.crearPedido(pedido, c);
		
		List<Pedidos> li = dao.PedidosDao.listaPedidos();
		for (Pedidos pedidos : li) {
			System.out.println(pedidos);
		}
		
		System.out.println("hugo");
		
		
/*		Categorias cat = new Categorias(2,"pantalones");
	//	dao.CategoriasDao.inserta(cat);
		/*	List<Categorias> lista= dao.ProductosDao.listaCategorias();
				for (Categorias categorias : lista) {
					System.out.println(categorias);
				}
			*/
		
/*		Productos produ = new Productos(3, cat, "cintu", 13, "...", "negro", "xs", 3);
		dao.ProductosDao.insertaProducto(produ);
		List<Productos> lista= dao.ProductosDao.listaProductos();
		for (Productos productos : lista) {
			System.out.println(productos);
		}*/
		
	/*	List<Productos> lista2= dao.ProductosDao.listaProductosXcategoria(cat);
		for (Productos productos : lista2) {
			System.out.println(productos);
		}*/
		
		
				
			
			/*	dao.ClientesDao.inserta(c);
List<Clientes> cl=	dao.ClientesDao.lista();
for (Clientes clientes : cl) {
	System.out.println(clientes);
}*/
		}


	}

