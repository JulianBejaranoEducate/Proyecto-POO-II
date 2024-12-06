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
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUser;

    @Column(name = "nombrecompleto")
    private String nameUser;

    @Column(name = "email")
    private String emailUser;

    @Column(name = "numero_telefono")
    private String numeroUser;

    @Column(name = "estadousuario")
    private byte estadoUsuario;

    public Usuarios() {
        super();
    }

    public Usuarios(int idUser, String nameUser, String emailUser, String numeroUser, byte estadoUsuario) {
        super();
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.numeroUser = numeroUser;
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNumeroUser() {
        return numeroUser;
    }

    public void setNumeroUser(String numeroUser) {
        this.numeroUser = numeroUser;
    }

    public byte getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(byte estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios [idUser=" + idUser + ", nameUser=" + nameUser + ", emailUser=" + emailUser + ", numeroUser="
                + numeroUser + ", estadoUsuario=" + estadoUsuario + "]";
    }
}