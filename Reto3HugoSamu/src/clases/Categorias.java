package clases;

/**
 * Clase que representa las categorias de productos
 */
public class Categorias {
private int idCategorias;
private String nombre;

    /**
     * Constructor por defecto
     */
    public Categorias() {
        super();
    }

    /**
     * Constructor con todos los atributos
     * @param int idCategoria IDcategoria 
     * @param string nombre Nombre de la categoria
     */
    public Categorias(int idCategoria, String nombre) {
		super();
		this.idCategorias = idCategoria;
		this.nombre = nombre;
	}
    
    /**
     * Constructor con id categorias
     * @param int idCategoria IDcategoria 
     */
    public Categorias(int idCategorias) {
	super();
	this.idCategorias = idCategorias;
}

    public int getIdCategoria() {
        return idCategorias;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategorias = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Categorias [idCategoria=" + idCategorias + ", nombre=" + nombre + "]";
}



}
