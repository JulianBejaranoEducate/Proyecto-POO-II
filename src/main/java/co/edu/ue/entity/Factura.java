package co.edu.ue.entity;

import java.io.Serializable;
import java.sql.Date;

import co.edu.ue.entity.Boletas.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Factura")
@NamedQuery(name = "Dato.findAll", query = "SELECT d FROM Dato d")
public class Factura implements Serializable{
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

}
