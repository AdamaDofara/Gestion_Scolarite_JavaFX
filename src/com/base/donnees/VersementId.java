package com.base.donnees;
// Generated 8 mars 2022 � 09:59:35 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VersementId generated by hbm2java
 */
@Embeddable
public class VersementId implements java.io.Serializable {

	private int idAgent;
	private String matricule;

	public VersementId() {
	}

	public VersementId(int idAgent, String matricule) {
		this.idAgent = idAgent;
		this.matricule = matricule;
	}

	@Column(name = "id_agent", nullable = false)
	public int getIdAgent() {
		return this.idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	@Column(name = "matricule", nullable = false, length = 50)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VersementId))
			return false;
		VersementId castOther = (VersementId) other;

		return (this.getIdAgent() == castOther.getIdAgent())
				&& ((this.getMatricule() == castOther.getMatricule()) || (this.getMatricule() != null
						&& castOther.getMatricule() != null && this.getMatricule().equals(castOther.getMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdAgent();
		result = 37 * result + (getMatricule() == null ? 0 : this.getMatricule().hashCode());
		return result;
	}

}
