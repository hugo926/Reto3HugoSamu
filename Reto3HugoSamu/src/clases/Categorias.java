package clases;

public class Categorias {
private int idCategorias;
private String nombre;

public Categorias(int idCategoria, String nombre) {
	super();
	this.idCategorias = idCategoria;
	this.nombre = nombre;
}


public Categorias(int idCategorias) {
	super();
	this.idCategorias = idCategorias;
}


public Categorias() {
	super();
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
