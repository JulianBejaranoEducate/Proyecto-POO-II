package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_boleta") // Asegúrate de usar el nombre correcto de la tabla en la base de datos
public class TipoBoleta implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_boleta")
    private int id;

    @Column(name = "nombre")
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "id_tipoboleta", insertable = false, updatable = false) // Mapeo correcto
    private TipoBoleta tipoBoleta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoBoleta getTipoBoleta() {
		return tipoBoleta;
	}

	public void setTipoBoleta(TipoBoleta tipoBoleta) {
		this.tipoBoleta = tipoBoleta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoBoleta [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipoBoleta=");
		builder.append(tipoBoleta);
		builder.append("]");
		return builder.toString();
	}
}

