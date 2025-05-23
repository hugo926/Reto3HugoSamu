package clases;

import java.sql.Date;

/**
 * Clase que representa los pedidos
 */
public class Pedidos {
    private int idPedido;
    private Clientes idCliente;
    private double precioToatal;
    private String direccEnvio;
    private Date fecha;
	
	/**
	 * Constructor por defecto
	 */
	public Pedidos() {
		super();
	}

	/**
	 * Constructor con todos los atributos
	 * @param int idPedido ID del pedido
	 * @param Clientes idCliente id del Cliente que realiza el pedido
	 * @param double precioToatal Precio total del pedido
	 * @param string direccEnvio Direccion de envio
	 * @param Date fecha Fecha del pedido
	 */
	public Pedidos(int idPedido, Clientes idCliente, double precioToatal, String direccEnvio, Date fecha) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.precioToatal = precioToatal;
		this.direccEnvio = direccEnvio;
		this.fecha = fecha;
	}

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}

	public double getPrecioToatal() {
		return precioToatal;
	}

	public void setPrecioToatal(double precioToatal) {
		this.precioToatal = precioToatal;
	}

	public String getDireccEnvio() {
		return direccEnvio;
	}

	public void setDireccEnvio(String direccEnvio) {
		this.direccEnvio = direccEnvio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precioToatal=" + precioToatal
				+ ", direccEnvio=" + direccEnvio + ", fecha=" + fecha + "]";
	}

}
