package co.edu.ue.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "boletas")
@NamedQuery(name = "Dato.findAll", query = "SELECT d FROM Dato d")
public class Boletas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "precio")
	private int precio;

	@Column(name = "fecha_compra")
	private Date fecha_compra;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// Enum declarado por fuera
	public enum Estado {
		ACTIVO, USADA
	}
}
