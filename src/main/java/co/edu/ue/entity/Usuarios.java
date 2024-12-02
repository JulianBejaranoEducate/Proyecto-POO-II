package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
@NamedQuery(name = "usuarios.findAll", query = "SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer IdUser;

    @Column(name = "nombrecompleto")
    private String NameUser;

    @Column(name = "email")
    private String EmailUser;

    @Column(name = "numero_telefono")
    private int NumeroUser;

    @Column(name = "estadousuario")
    private int estadousuario;

    public Usuarios() {
		super();
	}

	public EstadoUser.Estado getEstadousuario() {
        return EstadoUser.Estado.fromCodigo(estadousuario); 
    }

    public void setEstadousuario(EstadoUser.Estado estadoUser) {
        this.estadousuario = estadoUser.getCodigo(); 
    }

    public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}

	public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(String emailUser) {
        EmailUser = emailUser;
    }

    public int getNumeroUser() {
        return NumeroUser;
    }

    public void setNumeroUser(int numeroUser) {
        NumeroUser = numeroUser;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuarios [id=");
		builder.append(IdUser);
		builder.append(", NameUser=");
		builder.append(NameUser);
		builder.append(", EmailUser=");
		builder.append(EmailUser);
		builder.append(", NumeroUser=");
		builder.append(NumeroUser);
		builder.append(", estadousuario=");
		builder.append(estadousuario);
		builder.append("]");
		return builder.toString();
	}
    
    
}
