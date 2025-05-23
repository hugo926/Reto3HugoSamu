package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import clases.Clientes;
import util.Conexion;

public class ClientesDao {
	
	/**
     * Lista todos los clientes de tipo clientes
     * @return Lista de Clientes.
     */
	public static List<Clientes> lista (){
		List<Clientes> lista= new ArrayList<Clientes>();
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("select * from clientes");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				lista.add(new Clientes(rs.getInt("idcliente"), rs.getString("nombre"),rs.getString("direccion"),rs.getInt("codigo")));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return lista;
	}
	
	 /**
     * Inserta un nuevo cliente de tipo cliente
     * @param clien Cliente a insertar.
     */
	public static void inserta(Clientes clien) {
		try {
			Connection con= Conexion.abreConexion();
			PreparedStatement pst=con.prepareStatement("insert into clientes(nombre,direccion,codigo) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, clien.getNombre());
			pst.setString(2, clien.getDireccion());
			pst.setInt(3, clien.getCodigo());
			pst.executeUpdate();
			ResultSet rs=pst.getGeneratedKeys();
			if (rs.next()) {
			clien.setIdCliente(rs.getInt(1));
			}rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
	
	/**
     * Busca un cliente según su código único.
     * @param int cod Código del cliente.
     * @return cliente Clientes
     */
	public static Clientes buscarXcodigo(int cod) {
	
		Clientes c=null;	
		try {
			Connection con= Conexion.abreConexion();
			PreparedStatement pst=con.prepareStatement("select * from clientes where codigo = ?");
			pst.setInt(1, cod);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				c= new Clientes(rs.getInt("idCliente"),rs.getString("nombre"),rs.getString("direccion"),rs.getInt("codigo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return c;
	}
	
	/**
     * Actualiza los datos de un cliente
     * @param c Cliente con datos actualizados.
     */
	public static void actualiza(Clientes c) {
		try {
			Connection con= Conexion.abreConexion();
			PreparedStatement pst=con.prepareStatement("update clientes set nombre=?, direccion=?, codigo=? where idcliente=?");
			pst.setString(1, c.getNombre());
			pst.setString(2, c.getDireccion());
			pst.setInt(3, c.getCodigo());
			pst.setInt(4, c.getIdCliente());
			
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
