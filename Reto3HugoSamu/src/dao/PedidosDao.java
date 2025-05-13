package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clases.Clientes;
import clases.Pedidos;
import util.Conexion;

public class PedidosDao {
	
	public static Pedidos crearPedidos(Clientes cliente) {
		
		Pedidos pedido = new Pedidos();
		try {
			Connection con = Conexion.abreConexion();
			
			PreparedStatement pst = con.prepareStatement("select * from productos where nombre = ?");
			ResultSet rs = pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return pedido;
	}
	
	public static List<Pedidos> verPedidos() {
		List<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		try {
			Connection con = Conexion.abreConexion();
			
			PreparedStatement pst = con.prepareStatement("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return listaPedidos;
	}

}
