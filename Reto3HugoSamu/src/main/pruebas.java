package main;

import java.util.List;

import clases.Categorias;
import clases.Clientes;
import clases.Productos;

public class pruebas {

	public static void main(String[] args) {
		/*Categorias cat = new Categorias(1,"prueba");
		dao.CategoriasDao.inserta(cat);
			List<Categorias> lista= dao.CategoriasDao.lista();
				for (Categorias categorias : lista) {
					System.out.println(categorias);
				}
				Clientes c= new Clientes(1,"hjose","wf3fv3v",34);
				dao.ClientesDao.inserta(c);
List<Clientes> cl=	dao.ClientesDao.lista();
for (Clientes clientes : cl) {
	System.out.println(clientes);
}*/
/*System.out.println(dao.ClientesDao.buscarXcodigo(25));
Clientes c= new Clientes(5,"epe","wf3fv3v",25);
dao.ClientesDao.actualiza(c);*/
List<Categorias> lista= dao.CategoriasDao.lista();
for (Categorias categorias : lista) {
	System.out.println(categorias);
}

System.out.println(dao.CategoriasDao.lista());
/*Categorias c=dao.CategoriasDao.lista().getLast();
Productos p = new Productos(1,c,"j",34,".","rojo","m",12);
dao.ProductosDao.insertaProducto(p);*/

List<Productos> lista2=dao.ProductosDao.productosXstock();
for (Productos productos : lista2) {
	System.out.println(productos);
}
		}


	}

