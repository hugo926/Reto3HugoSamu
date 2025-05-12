package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import util.Conexion;

public class CategoriasDao {
	public static List<Categorias> lista (){
		List<Categorias> lista= new ArrayList<Categorias>();
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("select * from categorias");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				lista.add(new Categorias(rs.getInt("idcategoria"), rs.getString("nombre")));
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
