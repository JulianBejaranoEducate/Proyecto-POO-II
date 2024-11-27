package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the datos database table.
 */
@Entity
@Table(name = "datos")
@NamedQuery(name = "Dato.findAll", query = "SELECT d FROM Dato d")
public class Dato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dat_id")
	private int datId;

	@Column(name = "dat_document")
	private String datDocument;

	@Column(name = "dat_email")
	private String datEmail;

	@Column(name = "dat_lastNames")
	private String datLastNames;

	@Column(name = "dat_names")
	private String datNames;

	@Column(name = "dat_password")
	private String datPassword;

	// bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name = "tip_id")
	private TipoUsuario tipoUsuario;

	public Dato() {
	}

	public int getDatId() {
		return this.datId;
	}

	public void setDatId(int datId) {
		this.datId = datId;
	}

	public String getDatDocument() {
		return this.datDocument;
	}

	public void setDatDocument(String datDocument) {
		this.datDocument = datDocument;
	}

	public String getDatEmail() {
		return this.datEmail;
	}

	public void setDatEmail(String datEmail) {
		this.datEmail = datEmail;
	}

	public String getDarLastNames() {
		return datLastNames;
	}

	public void setDarLastNames(String darLastNames) {
		this.datLastNames = darLastNames;
	}

	public String getDatNames() {
		return this.datNames;
	}

	public void setDatNames(String datNames) {
		this.datNames = datNames;
	}

	public String getDatPassword() {
		return this.datPassword;
	}

	public void setDatPassword(String datPassword) {
		this.datPassword = datPassword;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dato [datId=");
		builder.append(datId);
		builder.append(", datDocument=");
		builder.append(datDocument);
		builder.append(", datEmail=");
		builder.append(datEmail);
		builder.append(", darLastNames=");
		builder.append(datLastNames);
		builder.append(", datNames=");
		builder.append(datNames);
		builder.append(", datPassword=");
		builder.append(datPassword);
		builder.append(", tipoUsuario=");
		builder.append(tipoUsuario);
		builder.append("]");
		return builder.toString();
	}
	
	

}