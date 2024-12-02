package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "boletas")
@NamedQuery(name = "Boletas.findAll", query = "SELECT d FROM Boletas d")
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
}
