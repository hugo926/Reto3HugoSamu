package clases;

/**
 * Clase que representa los productos
 */
public class Productos {

	private int idProducto;
	private Categorias idCategoria;
	private String nombre;
	private double precio;
	private String descripcion;
	private String color;
	private String talla;
	private int Stock;

	/**
	 * Constructor por defecto
	 */
	public Productos() {
		super();
	}

	/**
	 * Constructor con todos los atributos
	 * @param int idProducto ID del producto
	 * @param Categorias idCategoria idCategoria del produtco
	 * @param string nombre Nombre del producto
	 * @param double precio Precio del producto
	 * @param string descripcion Descripcion del producto
	 * @param string color Color del producto
	 * @param int talla Talla del producto
	 * @param int stock Cantidad disponible
	 */
	public Productos(int idProducto, Categorias idCategoria, String nombre, double precio, String descripcion,
			String color, String talla, int stock) {
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

	public Productos(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Productos(String nombre, double precio, String descripcion, String color, String talla, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		Stock = stock;
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
		return "Productos [ idCategoria=" + idCategoria + ", nombre=" + nombre
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", color=" + color + ", talla=" + talla
				+ ", Stock=" + Stock + "]";
	}

	public String imprimir() {
		return "Productos [ nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + ", color="
				+ color + ", talla=" + talla + ", Stock=" + Stock + "]";
	}

}
