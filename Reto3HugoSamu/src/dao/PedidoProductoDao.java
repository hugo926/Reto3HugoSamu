package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.PedidoProducto;
import clases.Productos;
import util.Conexion;

public class PedidoProductoDao {
	
	public static void insertaProducto(Productos producto) {
		
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(
					"insert into pedidoproducto (idpedidoproducto, idpedido, idproducto, unidades)"
							+ "values (?,?,?,?);",
					java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdCategoria().getIdCategoria()); // en BD es int entonces cojo categroia y luego
																		// de categoria cojo id(int)
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getDescripcion());

			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			// pa coger el idProducto
			if (rs.next()) {
				PedidoProducto.set
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
	}

}
