package com.base.donnees;
// Generated 24 mars 2022 ? 09:24:39 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Agentdescolarite generated by hbm2java
 */
@Entity
@Table(name = "agentdescolarite", catalog = "gestion_scolarite_javafx")
public class Agentdescolarite implements java.io.Serializable {

	private Integer idAgent;
	private Directeur directeur;
	private String nom;
	private String prenom;
	private String maill;
	private String pseudo;
	private String motPasse;
	private Set<Versement> versements = new HashSet<Versement>(0);

	public Agentdescolarite() {
	}

	public Agentdescolarite(Directeur directeur, String nom, String prenom, String maill, String pseudo,
			String motPasse) {
		this.directeur = directeur;
		this.nom = nom;
		this.prenom = prenom;
		this.maill = maill;
		this.pseudo = pseudo;
		this.motPasse = motPasse;
	}

	public Agentdescolarite(Directeur directeur, String nom, String prenom, String maill, String pseudo,
			String motPasse, Set<Versement> versements) {
		this.directeur = directeur;
		this.nom = nom;
		this.prenom = prenom;
		this.maill = maill;
		this.pseudo = pseudo;
		this.motPasse = motPasse;
		this.versements = versements;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_agent", unique = true, nullable = false)
	public Integer getIdAgent() {
		return this.idAgent;
	}

	public void setIdAgent(Integer idAgent) {
		this.idAgent = idAgent;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "matricule", nullable = false)
	public Directeur getDirecteur() {
		return this.directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "maill", nullable = false, length = 50)
	public String getMaill() {
		return this.maill;
	}

	public void setMaill(String maill) {
		this.maill = maill;
	}

	@Column(name = "pseudo", nullable = false, length = 50)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "mot_passe", nullable = false, length = 50)
	public String getMotPasse() {
		return this.motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "agentdescolarite")
	public Set<Versement> getVersements() {
		return this.versements;
	}

	public void setVersements(Set<Versement> versements) {
		this.versements = versements;
	}

}
