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
	
	public static Pedidos crearPedido(Pedidos pedido, Clientes cli) {

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
				pedido.setIdPedido(rs.getInt(1));
			//	System.out.println("Holaa"+pedido.getIdPedido());
			}
			return pedido;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return pedido;
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
				
				PreparedStatement pst = con.prepareStatement("select p.fecha,c.idcliente, c.nombre, p.precioTotal, p.direccionEnvio, cat.nombre, pr.nombre, pp.unidades\r\n"
						+ "from pedidos p\r\n"
						+ "inner join clientes c on p.idcliente = c.idcliente\r\n"
						+ "inner join pedidoproducto pp on p.idpedido = pp.idpedido\r\n"
						+ "inner join productos pr on pp.idproducto = pr.idproducto\r\n"
						+ "inner join categorias cat on pr.idcategoria = cat.idcategoria\r\n"
						+ "where MONTH(p.fecha) = ?\r\n"
						+ "order by fecha desc;");
				int mes = LocalDate.now().getMonthValue();
				pst.setInt(1, mes);
				ResultSet rs= pst.executeQuery();
				while(rs.next())
				{
					Clientes c = new Clientes(0, rs.getString("nombre"), rs.getString("p.direccionEnvio"),0);
					lista.add(new Pedidos(0,c,rs.getDouble("precioTotal"),rs.getString("p.direccionEnvio"),rs.getDate("fecha")));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				Conexion.cierraConexion();
			}
			
			return lista;
	}

}
