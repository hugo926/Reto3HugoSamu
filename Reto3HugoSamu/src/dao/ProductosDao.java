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
	
	public static List<Productos> listaProductos() {
		
	List<Productos> lista = new ArrayList<Productos>();
	
	try {
		Connection con = Conexion.abreConexion();
		PreparedStatement pst = con.prepareStatement("select idproducto, c.idcategoria,c.nombre as nombreCat, p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
				+ "inner join categorias c on p.idcategoria = c.idcategoria \r\n"
				+ "order by idproducto;");
		ResultSet rs = pst.executeQuery(); //aqui guardo lo q nos devuelve la consulta
		while(rs.next()) //bucle mientras exista un resultado a continuacion del anterior
		{
			Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombreCat"));
			lista.add(new Productos(rs.getInt("idproducto"), cat , rs.getString("nombre"), rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),rs.getInt("stock")));
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
	
	public static List<Productos> listaProductosXcategoria(Categorias catego) {
		
		List<Productos> lista = new ArrayList<Productos>();
		
		try {
			Connection con = Conexion.abreConexion();
			
			PreparedStatement pst = con.prepareStatement("select idproducto, c.idcategoria,c.nombre as nombreCat, p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria = c.idcategoria \r\n"
					+ "where c.idcategoria = ?\r\n"
					+ "order by idproducto;");
			pst.setInt(1, catego.getIdCategoria());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) //bucle mientras exista un resultado a continuacion del anterior
			{
				Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombreCat"));
				lista.add(new Productos(rs.getInt("idproducto"), cat , rs.getString("nombre"), rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),rs.getInt("stock")));
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
