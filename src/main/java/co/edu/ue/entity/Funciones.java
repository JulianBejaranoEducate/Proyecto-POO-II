	package co.edu.ue.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

public class Funciones {
	@Entity
	@Table(name = "funciones")
	@NamedQuery(name = "funciones.findAll", query = "SELECT f FROM funciones f")
	public class Usuarios implements Serializable {
	    private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_funcion")
	    private Integer IdFuncion;
	    
	    @Column(name = "fecha")
	    private Date FechaFuncion;
	    
	    @Column(name = "hora")
	    private Time HoraFuncion;
	    
	    @Column(name = "sala")
	    private String SalaFuncion;
	    
	    @Column(name = "estado")
	    private int EstadoFuncion;
	    
	
		public Usuarios(Integer idFuncion, Date fechaFuncion, Time horaFuncion, String salaFuncion, int estadoFuncion) {
			super();
			IdFuncion = idFuncion;
			FechaFuncion = fechaFuncion;
			HoraFuncion = horaFuncion;
			SalaFuncion = salaFuncion;
			EstadoFuncion = estadoFuncion;
		}

		public Integer getIdFuncion() {
			return IdFuncion;
		}

		public void setIdFuncion(Integer idFuncion) {
			IdFuncion = idFuncion;
		}

		public Date getFechaFuncion() {
			return FechaFuncion;
		}

		public void setFechaFuncion(Date fechaFuncion) {
			FechaFuncion = fechaFuncion;
		}

		public Time getHoraFuncion() {
			return HoraFuncion;
		}

		public void setHoraFuncion(Time horaFuncion) {
			HoraFuncion = horaFuncion;
		}

		public String getSalaFuncion() {
			return SalaFuncion;
		}

		public void setSalaFuncion(String salaFuncion) {
			SalaFuncion = salaFuncion;
		}

		public int getEstadoFuncion() {
			return EstadoFuncion;
		}

		public void setEstadoFuncion(int estadoFuncion) {
			EstadoFuncion = estadoFuncion;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Usuarios [IdFuncion=");
			builder.append(IdFuncion);
			builder.append(", FechaFuncion=");
			builder.append(FechaFuncion);
			builder.append(", HoraFuncion=");
			builder.append(HoraFuncion);
			builder.append(", SalaFuncion=");
			builder.append(SalaFuncion);
			builder.append(", EstadoFuncion=");
			builder.append(EstadoFuncion);
			builder.append("]");
			return builder.toString();
		}
	    
	    
	}

}
