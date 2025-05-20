package clases;

public class PedidoProducto {
private int idPedidoProducto;
private Pedidos idPedido;
private Productos idProducto;
private int unidades;
private double precio;

public PedidoProducto() {
	super();
}

public PedidoProducto(int idPedidoProducto, Pedidos idPedido, Productos idProducto, int unidades) {
	super();
	this.idPedidoProducto = idPedidoProducto;
	this.idPedido = idPedido;
	this.idProducto = idProducto;
	this.unidades = unidades;
	this.precio = unidades*idProducto.getPrecio();
}

public int getIdPedidoProducto() {
	return idPedidoProducto;
}

public void setIdPedidoProducto(int idPedidoProducto) {
	this.idPedidoProducto = idPedidoProducto;
}

public Pedidos getIdPedido() {
	return idPedido;
}

public void setIdPedido(Pedidos idPedido) {
	this.idPedido = idPedido;
}

public Productos getIdProducto() {
	return idProducto;
}

public void setIdProducto(Productos idProducto) {
	this.idProducto = idProducto;
}

public int getUnidades() {
	return unidades;
}

public void setUnidades(int unidades) {
	this.unidades = unidades;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
public String toString() {
	return "PedidoProducto [idPedidoProducto=" + idPedidoProducto + ", idPedido=" + idPedido + ", idProducto="
			+ idProducto + ", unidades=" + unidades + ", precio=" + precio + "]";
}


}
