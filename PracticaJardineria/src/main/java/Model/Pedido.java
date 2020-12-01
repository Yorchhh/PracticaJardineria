package Model;

import java.util.Date;

public class Pedido {
	@Override
	public String toString() {
		return "Pedido con Id: " + codigoPedido + " con fecha de pedido " + fechaPedido
				+ " y con fecha de entrega el dia " + fechaEntrega + ", con fecha esperada el dia "
				+fechaEsperada+" corresponde al cliente con Id: " + codigoCliente + " .";
	}

	private Integer codigoPedido;
	private Date fechaPedido;
	private Date fechaEntrega;
	private Date fechaEsperada;
	private Integer codigoCliente;

	public Pedido(Integer codigoPedido, Date fechaPedido, Date fechaEntrega, Integer id, Date fechaEsperada) {
		super();
		this.codigoPedido = codigoPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.codigoCliente = id;
		this.fechaEsperada = fechaEsperada;
	}
	public int getId() {
		return codigoCliente;
	}

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Date getFechaEsperada() {
		return fechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

}
