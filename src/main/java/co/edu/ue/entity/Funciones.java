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

@Entity
@Table(name = "funciones")
@NamedQuery(name = "funciones.findAll", query = "SELECT f FROM Funciones f")
public class Funciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private Integer idFuncion;

    @Column(name = "fecha")
    private Date fechaFuncion;

    @Column(name = "hora")
    private Time horaFuncion;

    @Column(name = "sala")
    private String salaFuncion;

    @Column(name = "estado")
    private Byte estadoFuncion; 

    public Funciones() {
    }

    public Funciones(Integer idFuncion, Date fechaFuncion, Time horaFuncion, String salaFuncion, Byte estadoFuncion) {
        this.idFuncion = idFuncion;
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.salaFuncion = salaFuncion;
        this.estadoFuncion = estadoFuncion;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Date getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public Time getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(Time horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public String getSalaFuncion() {
        return salaFuncion;
    }

    public void setSalaFuncion(String salaFuncion) {
        this.salaFuncion = salaFuncion;
    }

    public Byte getEstadoFuncion() {
        return estadoFuncion;
    }

    public void setEstadoFuncion(Byte estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    @Override
    public String toString() {
        return "Funciones [idFuncion=" + idFuncion + ", fechaFuncion=" + fechaFuncion + ", horaFuncion=" + horaFuncion
                + ", salaFuncion=" + salaFuncion + ", estadoFuncion=" + estadoFuncion + "]";
    }
}