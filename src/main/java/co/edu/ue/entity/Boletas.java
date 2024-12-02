package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "boletas")
@NamedQuery(name = "Boletas.findAll", query = "SELECT b FROM Boletas b")
public class Boletas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_boleta")
	private int id_boleta;

	@Column(name = "asiento_asignado")
	private String asiento_asignado;

	@Column(name = "id_tipoboleta")
	private int id_tipoboleta;

	@Column(name = "id_pelicula")
	private int id_pelicula;

	@ManyToOne
	@JoinColumn(name = "id_tipoboleta")
	private TipoBoleta tipoBoleta;

	@ManyToOne
	@JoinColumn(name = "id_pelicula")
	private Pelicula pelicula;

	public Boletas() {
		super();
	}

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public String getAsiento_asignado() {
		return asiento_asignado;
	}

	public void setAsiento_asignado(String asiento_asignado) {
		this.asiento_asignado = asiento_asignado;
	}

	public int getId_tipoboleta() {
		return id_tipoboleta;
	}

	public void setId_tipoboleta(int id_tipoboleta) {
		this.id_tipoboleta = id_tipoboleta;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public TipoBoleta getTipoBoleta() {
		return tipoBoleta;
	}

	public void setTipoBoleta(TipoBoleta tipoBoleta) {
		this.tipoBoleta = tipoBoleta;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Boletas [id_boleta=" + id_boleta + ", asiento_asignado=" + asiento_asignado + ", id_tipoboleta="
				+ id_tipoboleta + ", id_pelicula=" + id_pelicula + ", tipoBoleta=" + tipoBoleta + ", pelicula="
				+ pelicula + "]";
	}
}
