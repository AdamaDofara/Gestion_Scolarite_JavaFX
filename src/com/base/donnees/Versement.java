package com.base.donnees;
// Generated 8 mars 2022 � 09:59:35 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Versement generated by hbm2java
 */
@Entity
@Table(name = "versement", catalog = "gestion_scolarite_javafx")
public class Versement implements java.io.Serializable {

	private VersementId id;
	private Agentdescolarite agentdescolarite;
	private Etudiant etudiant;
	private Date dateVersement;
	private double montant;

	public Versement() {
	}

	public Versement(VersementId id, Agentdescolarite agentdescolarite, Etudiant etudiant, Date dateVersement,
			double montant) {
		this.id = id;
		this.agentdescolarite = agentdescolarite;
		this.etudiant = etudiant;
		this.dateVersement = dateVersement;
		this.montant = montant;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idAgent", column = @Column(name = "id_agent", nullable = false)),
			@AttributeOverride(name = "matricule", column = @Column(name = "matricule", nullable = false, length = 50)) })
	public VersementId getId() {
		return this.id;
	}

	public void setId(VersementId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agent", nullable = false, insertable = false, updatable = false)
	public Agentdescolarite getAgentdescolarite() {
		return this.agentdescolarite;
	}

	public void setAgentdescolarite(Agentdescolarite agentdescolarite) {
		this.agentdescolarite = agentdescolarite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricule", nullable = false, insertable = false, updatable = false)
	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_versement", nullable = false, length = 10)
	public Date getDateVersement() {
		return this.dateVersement;
	}

	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	@Column(name = "montant", nullable = false, precision = 22, scale = 0)
	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}