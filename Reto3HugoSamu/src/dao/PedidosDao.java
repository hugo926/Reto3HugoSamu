package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clases.Categorias;
import clases.Clientes;
import clases.Pedidos;
import util.Conexion;
import util.Validarfunciones;

public class PedidosDao {
	
	public static void crearPedido(Pedidos pedido, Clientes cli) {

		try {
			Connection con = Conexion.abreConexion();
			
			PreparedStatement pst = con.prepareStatement("insert into pedidos (idcliente,precioTotal,direccionEnvio,fecha)\r\n"
					+ "values (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, cli.getIdCliente());
			pst.setDouble(2, pedido.getPrecioToatal());
			pst.setString(3, cli.getDireccion());
			pst.setDate(4,Validarfunciones.convierteFechaASQL(pedido.getFecha()));
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				pedido.setIdPedido(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
	}
	
	public static List<Pedidos> listaPedidos (){
		List<Pedidos> lista= new ArrayList<Pedidos>();
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("select * from pedidos p\r\n"
					+ "inner join clientes c on p.idcliente = c.idcliente");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				Clientes c = new Clientes(rs.getInt("idcliente"), rs.getString("nombre"), rs.getString("direccion"), rs.getInt("codigo"));
				lista.add(new Pedidos(rs.getInt("idpedido"),c,rs.getDouble("precioTotal"),rs.getString("direccionEnvio"),rs.getDate("fecha")));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
		return lista;
	}
	
	public static List<Pedidos> verPedidosMes () {
			List<Pedidos> lista = new ArrayList<Pedidos>();
			
			try {
				Connection con = Conexion.abreConexion();
				
				PreparedStatement pst = con.prepareStatement("");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				Conexion.cierraConexion();
			}
			
			
			return lista;
	}

}
