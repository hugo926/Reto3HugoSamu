package clases;

/**
 * Clase que representa los clientes del sistema
 */
public class Clientes {
    private int idCliente;
    private String nombre;
    private String direccion;
    private int codigo;

    /**
     * Constructor por defecto
     */
    public Clientes() {
        super();
    }

    /**
     * Constructor con todos los atributos
     * @param int idCliente ID del cliente
     * @param string nombre Nombre del cliente
     * @param string direccion Direccion del cliente
     * @param int codigo Codigo del cliente
     */
    public Clientes(int idCliente, String nombre, String direccion, int codigo) {
        super();
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigo = codigo;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }
 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", codigo=" + codigo
                + "]";
    }

}
