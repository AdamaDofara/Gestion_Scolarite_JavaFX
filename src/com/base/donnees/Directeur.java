package com.base.donnees;
// Generated 8 mars 2022 � 09:59:35 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Directeur generated by hbm2java
 */
@Entity
@Table(name = "directeur", catalog = "gestion_scolarite_javafx")
public class Directeur implements java.io.Serializable {

	private String matricule;
	private String nom;
	private String prenom;
	private String pseudo;
	private String motPasse;
	private Set<Agentdescolarite> agentdescolarites = new HashSet<Agentdescolarite>(0);

	public Directeur() {
	}

	public Directeur(String matricule, String nom, String prenom, String pseudo, String motPasse) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motPasse = motPasse;
	}

	public Directeur(String matricule, String nom, String prenom, String pseudo, String motPasse,
			Set<Agentdescolarite> agentdescolarites) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motPasse = motPasse;
		this.agentdescolarites = agentdescolarites;
	}

	@Id

	@Column(name = "matricule", unique = true, nullable = false, length = 50)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "directeur")
	public Set<Agentdescolarite> getAgentdescolarites() {
		return this.agentdescolarites;
	}

	public void setAgentdescolarites(Set<Agentdescolarite> agentdescolarites) {
		this.agentdescolarites = agentdescolarites;
	}

}
