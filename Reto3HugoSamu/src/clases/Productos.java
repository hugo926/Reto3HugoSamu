package clases;

public class Productos {
private int idProducto;
private Categorias idCategoria;
private String nombre;
private double precio;
private String descripcion;
private String color;
private String talla;
private int Stock;
public Productos(int idProducto, Categorias idCategoria, String nombre, double precio, String descripcion, String color,
		String talla, int stock) {
	super();
	this.idProducto = idProducto;
	this.idCategoria = idCategoria;
	this.nombre = nombre;
	this.precio = precio;
	this.descripcion = descripcion;
	this.color = color;
	this.talla = talla;
	Stock = stock;
}
public Productos() {
	super();
}

public int getIdProducto() {
	return idProducto;
}

public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}

public Categorias getIdCategoria() {
	return idCategoria;
}

public void setIdCategoria(Categorias idCategoria) {
	this.idCategoria = idCategoria;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getTalla() {
	return talla;
}

public void setTalla(String talla) {
	this.talla = talla;
}

public int getStock() {
	return Stock;
}

public void setStock(int stock) {
	Stock = stock;
}
@Override
public String toString() {
	return "Productos [idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", precio="
			+ precio + ", descripcion=" + descripcion + ", color=" + color + ", talla=" + talla + ", Stock=" + Stock
			+ "]";
}




}
