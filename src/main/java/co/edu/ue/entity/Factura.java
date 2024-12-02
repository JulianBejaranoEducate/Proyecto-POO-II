package co.edu.ue.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Factura")
@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private int id_factura;

	@Column(name = "fecha_factura")
	private Date fecha_factura;

	@Column(name = "id_usuario")
	private int id_usario;

	@Column(name = "metodo_pago")
	private String metodo_pago;

	@Column(name = "id_boleta")
	private int id_boleta;

	@Column(name = "precio_unitario")
	private float precio_unitario;	

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "total")
	private float total;

	@ManyToOne
	@JoinColumn(name = "id_usuaruio")
	private Usuarios usuarios;

	@ManyToOne
	@JoinColumn(name = "id_boleta")
	private Boletas boletas;

	public Factura() {
		super();
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public int getId_usario() {
		return id_usario;
	}

	public void setId_usario(int id_usario) {
		this.id_usario = id_usario;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Boletas getBoletas() {
		return boletas;
	}

	public void setBoletas(Boletas boletas) {
		this.boletas = boletas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Factura [id_factura=");
		builder.append(id_factura);
		builder.append(", fecha_factura=");
		builder.append(fecha_factura);
		builder.append(", id_usario=");
		builder.append(id_usario);
		builder.append(", metodo_pago=");
		builder.append(metodo_pago);
		builder.append(", id_boleta=");
		builder.append(id_boleta);
		builder.append(", precio_unitario=");
		builder.append(precio_unitario);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", total=");
		builder.append(total);
		builder.append(", usuarios=");
		builder.append(usuarios);
		builder.append(", boletas=");
		builder.append(boletas);
		builder.append("]");
		return builder.toString();
	}
}
