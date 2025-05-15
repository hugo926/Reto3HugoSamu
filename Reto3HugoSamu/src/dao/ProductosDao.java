package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.Productos;
import util.Conexion;

public class ProductosDao {
	
	public static List<Categorias> listaCategorias() {
		
	List<Categorias> lista = new ArrayList<Categorias>();
	
	try {
		Connection con = Conexion.abreConexion();
		PreparedStatement pst = con.prepareStatement("select * from categorias");
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			lista.add(new Categorias(rs.getInt("idcategoria"), rs.getString("nombre")));
		}
		rs.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		Conexion.cierraConexion();
	}
	
	return lista;
	
	}
	
	public static Productos insertaProducto(Productos producto) {
		
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("insert into productos (idcategoria, nombre, precio, descripcion, color, talla, stock)"
					+ "values (?,?,?,?,?,?,?);", java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdCategoria().getIdCategoria()); //en BD es int entonces cojo categroia y luego de categoria cojo id(int) 
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getDescripcion());
			pst.setString(5, producto.getColor());
			pst.setString(6, producto.getTalla());
			pst.setInt(7, producto.getStock());
			pst.executeUpdate(); 
			ResultSet rs = pst.getGeneratedKeys();
			//pa coger el idProducto
			if (rs.next()) {
				producto.setIdProducto(rs.getInt(1));
				}rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return null;
	}

}
