package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.Productos;
import util.Conexion;

public class ProductosDao {
	
	/**
     * Lista productos cuyo stock es igual o menor a 5 unidades.
     * @return Lista de productos productos
     */
	public static List<Productos> productosXstock(){
		List<Productos> lista = new ArrayList<Productos>();
		try {
		Connection con = Conexion.abreConexion();
		PreparedStatement pst=con.prepareStatement("select idcategoria, nombre, precio, descripcion, color, talla, stock from  productos\r\n"
				+ "where stock<=5;");
		ResultSet rs = pst.executeQuery(); 
		while (rs.next()) 
		{
			Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombre"));
		lista.add(new Productos(0, cat, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
		}
		rs.close();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		Conexion.cierraConexion();
	}

	return lista;
	}
	
	/**
     * Lista todos los productos
     * @return Lista de Productos productos
     */
	public static List<Productos> listaProductos() {

		List<Productos> lista = new ArrayList<Productos>();

		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(
					"select idproducto, c.idcategoria,c.nombre as nombreCat, p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
							+ "inner join categorias c on p.idcategoria = c.idcategoria \r\n" + "order by idproducto;");
			ResultSet rs = pst.executeQuery(); // aqui guardo lo q nos devuelve la consulta
			while (rs.next()) // bucle mientras exista un resultado a continuacion del anterior
			{
				Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombreCat"));
				lista.add(new Productos(rs.getInt("idproducto"), cat, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}

		return lista;

	}

	/**
     * Lista productos filtrados por una categoría dada
     * @param Categorias catego a filtrar.
     * @return Lista de productos que pertenecen a la categoría.
     */
	public static List<Productos> listaProductosXcategoria(Categorias catego) {

		List<Productos> lista = new ArrayList<Productos>();

		try {
			Connection con = Conexion.abreConexion();

			PreparedStatement pst = con
					.prepareStatement("select  p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
							+ "inner join categorias c on p.idcategoria = c.idcategoria \r\n"
							+ "where c.idcategoria = ?\r\n" + "order by idproducto;");
			pst.setInt(1, catego.getIdCategoria());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) // bucle mientras exista un resultado a continuacion del anterior
			{
				// Categorias cat = new Categorias(rs.getInt("idcategoria"),
				// rs.getString("nombreCat"));
				lista.add(new Productos(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"),
						rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return lista;

	}
	
	/**
     * Busca productos por nombre, talla y color.
     * @param string nombre Nombre del producto.
     * @param string talla Talla del producto.
     * @param string color Color del producto.
     * @return Lista de productos que coinciden con los filtros.
     */
	public static List<Productos> buscarProducto(String nombre, String talla, String color) {

		
		List<Productos> lista = new ArrayList<Productos>();
		try {
			Connection con = Conexion.abreConexion();

			String texto = "select idproducto, c.idcategoria,c.nombre as nombreCat, p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria = c.idcategoria" + " where 1 = 1 ";
			if (!nombre.equals("")) {
				texto = texto + "and p.nombre=?";
			}
			if (!talla.equals("")) {
				texto = texto + "and p.talla=?";
			}
			if (!color.equals("")) {
				texto = texto + "and p.color=?";
			}

			PreparedStatement pst = con.prepareStatement(texto + " order by idproducto;");
			filtros(nombre, talla, color, pst);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombreCat"));
				lista.add(new Productos(rs.getInt("idproducto"), cat, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return lista;
	}
	
	/**
     * Busca un producto por su nombre
     * @param string nombre Nombre del producto.
     * @return Productos Producto encontrado o vacío si no existe.
     */
	public static Productos buscarProductoXNombre(String nombre) {

		Productos p = new Productos();
		try {
			Connection con = Conexion.abreConexion();

			String texto = "select idproducto, c.idcategoria,c.nombre as nombreCat, p.nombre, precio, descripcion, color, talla, stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria = c.idcategoria" + " where 1 = 1 and p.nombre=?";

			PreparedStatement pst = con.prepareStatement(texto + " order by idproducto;");
			
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Categorias cat = new Categorias(rs.getInt("idcategoria"), rs.getString("nombreCat"));
			p=(new Productos(rs.getInt("idproducto"), cat, rs.getString("nombre"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return p;
	}
///se utiliza para buscar productos y si falta algun filtro
	public static void filtros(String nombre, String talla, String color, PreparedStatement pst) throws SQLException {
		if (nombre.equals("")) {
			if (talla.equals("")) {
				pst.setString(1, color);
			} else if (color.equals("")) {
				pst.setString(1, talla);
			} else {
				pst.setString(1, talla);
				pst.setString(2, color);
			}

		} else if (talla.equals("")) {

			if (color.equals("")) {
				pst.setString(1, nombre);
			} else if (nombre.equals("")) {
				pst.setString(1, color);
			} else {
				pst.setString(1, nombre);
				pst.setString(2, color);
			}
		} else if (color.equals("")) {

			if (nombre.equals("")) {
				pst.setString(1, talla);
			} else if (talla.equals("")) {
				pst.setString(1, nombre);
			} else {
				pst.setString(1, nombre);
				pst.setString(2, talla);
			}
		} else {
			pst.setString(1, nombre);
			pst.setString(2, talla);
			pst.setString(3, color);
		}
	}
	
	 /**
     * Inserta un nuevo producto 
     * @param productos producto Producto a insertar.
     * @return Producto con su ID asignado.
     */
	public static Productos insertaProducto(Productos producto) {

		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(
					"insert into productos (idcategoria, nombre, precio, descripcion, color, talla, stock)"
							+ "values (?,?,?,?,?,?,?);",
					java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getIdCategoria().getIdCategoria()); // en BD es int entonces cojo categroia y luego
																		// de categoria cojo id(int)
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getDescripcion());
			pst.setString(5, producto.getColor());
			pst.setString(6, producto.getTalla());
			pst.setInt(7, producto.getStock());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			// pa coger el idProducto
			if (rs.next()) {
				producto.setIdProducto(rs.getInt(1));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return null;
	}

}
