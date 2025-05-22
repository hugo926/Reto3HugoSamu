package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.PedidoProducto;
import clases.Pedidos;
import clases.Productos;
import util.Conexion;

public class PedidoProductoDao {

	public static void insertaProducto(Productos producto, Pedidos pedido, PedidoProducto pp) {

		try {
			// System.out.println("hola " + pedido.getIdPedido());
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(
					"insert into pedidoproducto (idpedido, idproducto, unidades, precio)" + "values (?,?,?,?);",
					java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, pedido.getIdPedido()); // en BD es int entonces cojo categroia y luego // de categoria cojo
													// id(int)
			pst.setInt(2, producto.getIdProducto());
			pst.setInt(3, pp.getUnidades());
			pst.setDouble(4, pp.getPrecio());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			// pa coger el idProducto
			if (rs.next()) {
				pp.setIdPedidoProducto(rs.getInt(1));

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
	}
public static void actualizaprecio(Pedidos pedido) {
	


	try {
		// System.out.println("hola " + pedido.getIdPedido());
		Connection con = Conexion.abreConexion();
		PreparedStatement pst = con.prepareStatement(
				"	update pedidos set precioTotal=(SELECT sum(precio) FROM tienda.pedidoproducto\r\n"
				+ "where idpedido=?);",
				java.sql.Statement.RETURN_GENERATED_KEYS);
		pst.setInt(1, pedido.getIdPedido()); // en BD es int entonces cojo categroia y luego // de categoria cojo
												// id(int
		pst.executeUpdate();
		ResultSet rs = pst.getGeneratedKeys();
		// pa coger el idProducto
		if (rs.next()) {
		

		}
		rs.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Conexion.cierraConexion();
	}
}
}
