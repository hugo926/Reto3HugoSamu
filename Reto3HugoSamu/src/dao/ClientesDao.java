package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import clases.Clientes;
import util.Conexion;

public class ClientesDao {
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
}
