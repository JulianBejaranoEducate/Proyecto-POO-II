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

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuarios usuarios;


	@Column(name = "metodo_pago")
	private String metodo_pago;

	@ManyToOne
	@JoinColumn(name = "id_boleta")
	private Boletas boletas;

	@Column(name = "precio_unitario")
	private float precio_unitario;	

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "total")
	private float total;




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




	public Usuarios getUsuarios() {
		return usuarios;
	}




	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}




	public String getMetodo_pago() {
		return metodo_pago;
	}




	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}




	public Boletas getBoletas() {
		return boletas;
	}




	public void setBoletas(Boletas boletas) {
		this.boletas = boletas;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura{");
        sb.append("id_factura=").append(id_factura);
        sb.append(", fecha_factura=").append(fecha_factura);
        sb.append(", usuarios=").append(usuarios);
        sb.append(", metodo_pago=").append(metodo_pago);
        sb.append(", boletas=").append(boletas);
        sb.append(", precio_unitario=").append(precio_unitario);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }


	
	
}
// Holi