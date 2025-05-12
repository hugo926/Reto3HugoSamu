package main;

import java.util.List;

import clases.Categorias;
import clases.Clientes;

public class pruebas {

	public static void main(String[] args) {
		Categorias cat = new Categorias(1,"prueba");
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
}
		}


	}

